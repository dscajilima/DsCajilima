package com.AppScooter.service

import com.AppScooter.model.Scooter
import com.AppScooter.repository.ScooterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service

class ScooterService {
    @Autowired
    lateinit var scooterRepository: ScooterRepository
    fun list(): List<Scooter> {

        return scooterRepository.findAll()
    }
    fun save(scooter: Scooter): Scooter {

        return scooterRepository.save(scooter)
    }

    fun update(@RequestBody scooter: Scooter): Scooter {
        return scooterRepository.save(scooter)
    }

    fun updateUnidad (scooter: Scooter): Scooter {
        val response = scooterRepository.findById(scooter.id)
            ?: throw Exception()
        response.apply {
            this.habilitado=unidad
        }
        return scooterRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        scooterRepository.deleteById(id)
        return true
    }
}