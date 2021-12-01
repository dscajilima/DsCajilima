package com.AppScooter.service

import com.AppScooter.model.Usuarios
import com.AppScooter.repository.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service

class UsuariosService {
    @Autowired
    lateinit var usuariosRepository: UsuariosRepository


    fun list(): List<Usuarios> {


        return usuariosRepository.findAll()
    }

    fun save (@RequestBody usuarios: Usuarios): Usuarios {
        return usuariosRepository.save(usuarios)
    }

    fun update(@RequestBody usuarios: Usuarios): Usuarios {
        return usuariosRepository.save(usuarios)
    }

    fun updateTelefono (usuarios: Usuarios) {
        try {
            val response = usuariosRepository.findById(usuarios.id)
                ?: throw Exception()
            response.apply {
                this.usuario=CI

            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "Telefono no encontrado", ex)
        }
    }


    fun delete (id:Long): Boolean{
        usuariosRepository.deleteById(id)
        return true
    }
}