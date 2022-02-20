package com.AppScooter.service

import com.AppScooter.model.App
import com.AppScooter.model.Scooter
import com.AppScooter.repository.AppRepository
import com.AppScooter.repository.ScooterRepository
import com.AppScooter.repository.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service

class ScooterService {

    @Autowired
    lateinit var appRepository: AppRepository

    @Autowired
    lateinit var scooterRepository: ScooterRepository
    fun list(): List<Scooter> {

        return scooterRepository.findAll()
    }

    fun save(scooter: Scooter): Scooter {

        return scooterRepository.save(scooter)
    }

    fun update(@RequestBody scooter: Scooter): Scooter {
        try {
            if (scooter.habilitado.equals("") && (scooter.unidad.equals(""))) {
                throw Exception()
            } else {
                return scooterRepository.save(scooter)
            }
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NO_CONTENT, "No Puede estar vacio", ex
            )
        }
    }

    fun updateUnidad(scooter: Scooter): Scooter {
        val response = scooterRepository.findById(scooter.id)
            ?: throw Exception()
        response.apply {
            this.habilitado = unidad
        }
        return scooterRepository.save(response)
    }

    fun delete(id: Long): Boolean {
        scooterRepository.deleteById(id)
        return true
    }

    fun validarScooter(tipo: String): Boolean {
        for (i in Scooter){
            if (tipo == i){
                return true
            }
        }
        return false
    }
}
}