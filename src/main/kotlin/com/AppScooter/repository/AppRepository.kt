package com.AppScooter.repository

import com.AppScooter.model.App
import org.springframework.data.jpa.repository.JpaRepository

interface AppRepository : JpaRepository<App, Long> {
    fun findById (id: Long?): App?
}