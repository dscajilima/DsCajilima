package com.AppScooter.repository

import com.AppScooter.model.Usuarios
import org.springframework.data.jpa.repository.JpaRepository

interface `Usuarios Repository`: JpaRepository<Usuarios, Long> {
    fun findById (id: Long?): Usuarios?
}