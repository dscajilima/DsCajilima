package com.AppScooter.controller

import com.AppScooter.model.Scooter
import com.AppScooter.service.ScooterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/scooter")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ScooterController {
    @Autowired
    lateinit var scooterService: ScooterService
    @GetMapping
    fun list(): List<Scooter>{
        return scooterService.list()
    }
    @PostMapping
    fun save (@RequestBody scooter: Scooter): Scooter{
        return scooterService.save(scooter)
    }

    @PutMapping
    fun update (@RequestBody scooter: Scooter): Scooter {
        return scooterService.update(scooter)
    }
    @PatchMapping
    fun updateUnidad # (@RequestBody scooter: Scooter): Scooter {
        return scooterService.updateUnidad #(scooter)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return scooterService.delete(id)
    }
}