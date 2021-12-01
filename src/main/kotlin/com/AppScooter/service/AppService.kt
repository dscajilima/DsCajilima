package com.AppScooter.service

import com.AppScooter.model.App
import com.AppScooter.repository.AppRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service

class AppService {
    @Autowired
    lateinit var appRepository: AppRepository


    fun list(): List<App> {

        return appRepository.findAll()
    }

    fun save(@RequestBody app: App): App {
        return appRepository.save(app)
    }

    fun update(@RequestBody app: App): App {
        if (app.scooter.equals("") && (app.distancia.equals(""))){
                throw Exception()
            } else {
                return appRepository.save(app)
            }
    }
    fun updateDistancia (app: App): App {
        val response = appRepository.findById(app.id)
            ?: throw Exception()
        response.apply {
            this.distancia=app.distancia
        }
        return appRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        appRepository.deleteById(id)
        return true
    }

}
