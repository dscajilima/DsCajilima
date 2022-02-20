package com.AppScooter.service

import com.AppScooter.model.App
import com.AppScooter.repository.AppRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

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
        try {
            if (app.scooter.equals("") && (app.distancia.equals(""))) {
                throw Exception()
            } else {
                return appRepository.save(app)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NO_CONTENT, "No Puede estar vacio", ex,
            )
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
    fun verificarLetras(cedula: String?, nombre: String?, apellido: String?):Boolean{
        if (cedula?.length!! == 10){
            return false
        }
        if (nombre?.length!! < 20){
            return false
        }
        if (apellido?.length!! < 20){
            return false
        }

        return true
    }
}
