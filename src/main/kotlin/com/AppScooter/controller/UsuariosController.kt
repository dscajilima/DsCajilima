package com.AppScooter.controller

import com.AppScooter.model.Usuarios
import com.AppScooter.service.UsuariosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

class UsuariosController {
    @RestController
    @RequestMapping("/usuarios")
    @CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

    class ProveedorController {
        @Autowired
        lateinit var usuariosService: UsuariosService

        @GetMapping
        fun list(): List<Usuarios> {
            return usuariosService.list()
        }

        @PostMapping
        fun save(@RequestBody usuarios: Usuarios): Usuarios {
            return usuariosService.save(usuarios)
        }

        @PutMapping
        fun update(@RequestBody usuarios: Usuarios): Usuarios {
            return usuariosService.update(usuarios)
        }

        @PatchMapping
        fun updateTelefono(@RequestBody usuarios: Usuarios): Usuarios {
            return usuariosService.update(usuarios)
        }

        @DeleteMapping("/delete/{id}")
        fun delete(@PathVariable("id") id: Long): Boolean {
            return usuariosService.delete(id)
        }

    }
}