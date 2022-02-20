package com.AppScooter.service;

import com.AppScooter.model.App
import com.AppScooter.repository.AppRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
public class AppServiceTestEva {

    @InjectMocks
    lateinit var appService: AppService

    @Mock
    lateinit var appRepository: AppRepository
    //UPDATE


    val returnObject: App = App().apply {
        id = 1
        scooter = "12"
        distancia = "18 km"
    }
    val newObject: App = App().apply {
        id = 1
        scooter = "12"
        distancia = "18 km"
    }



    val jsonString = File("./src/test/resources/app/crearApp.json").readText(Charsets.UTF_8)
    val appMock = Gson().fromJson(jsonString, App::class.java)


    @Test
    fun updateAppIsCorrect(){
        Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(returnObject)

        Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
        val response = appService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.scooter, newObject.scooter)
        Assertions.assertEquals(response.distancia, newObject.distancia)
    }


    @Test
    fun updateAppIsFailed() {
        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(null)

            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
            appService.update(newObject)
        }
    }


    @Test
    fun updateAppIsPassedList(){

        Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(returnObject)
        Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
        val response = appService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.scooter, newObject.scooter)

    }


    @Test
    fun updateAppIsPassedListFaild(){
        Assertions.assertThrows(Exception::class.java) {
            appMock.apply { scooter= " "}
            Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(appMock)
            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(appMock)
            appService.update(appMock)
        }
    }



    @Test
    fun updateAppFailedScooter(){
        Assertions.assertThrows(Exception::class.java) {
            appMock.apply { scooter= " "}
            Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(appMock)
            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(appMock)
            appService.update(appMock)
        }
    }


    @Test
    fun updateAppFailedDistancia(){
        Assertions.assertThrows(Exception::class.java) {
            appMock.apply { distancia= " "}
            Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(appMock)
            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(appMock)
            appService.update(appMock)
        }
    }

}
