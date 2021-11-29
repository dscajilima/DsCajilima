package com.AppScooter.controller

import com.AppScooter.model.App
import com.AppScooter.model.Scooter
import com.AppScooter.service.AppService
import com.AppScooter.service.ScooterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apli")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class AppController {
    @Autowired
    lateinit var appService: AppService

    @GetMapping
    fun list(): List<App>{
        return appService.list()
    }
    @PostMapping
    fun save (@RequestBody appService: AppService): App {
        return appService.save(App)
    }

    @PutMapping
    fun update (@RequestBody appService: AppService): App {
        return appService.update(App)
    }
    @PatchMapping
    fun updatedistancia (@RequestBody appService: AppService): App {
        return appService.updatedistancia(App)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return scooterService.delete(id)
    }

}