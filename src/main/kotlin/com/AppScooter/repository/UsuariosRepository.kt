package com.AppScooter.repository

import com.AppScooter.model.Usuarios
import org.springframework.data.jpa.repository.JpaRepository

interface UsuariosRepository: JpaRepository<Usuarios, Long> {
    fun findById (id: Long?): Usuarios?
}