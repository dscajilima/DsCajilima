package com.AppScooter.service

import com.AppScooter.model.Usuarios
import com.AppScooter.repository.`Usuarios Repository`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service

class UsuariosService {
    @Autowired
    lateinit var usuariosRepository: `Usuarios Repository`


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
        val response = usuariosRepository.findById(usuarios.id)
            ?: throw Exception()
        response.apply {
            this.CI=usuario
        }
    }


    fun delete (id:Long): Boolean{
        usuariosRepository.deleteById(id)
        return true
    }
}