package com.AppScooter.repository

import com.AppScooter.model.Scooter
import org.springframework.data.jpa.repository.JpaRepository

interface ScooterRepository: JpaRepository<Scooter, Long> {
    fun findById (id: Long?): Scooter?
    abstract fun save(any: ScooterRepository?): ScooterRepository
}