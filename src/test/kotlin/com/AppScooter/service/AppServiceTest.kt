package com.AppScooter.service

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

class AppServiceTest {
    @InjectMocks
    lateinit var appService: AppService

    @Mock
    lateinit var appRepository: AppRepository


    //SAVE

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

    //SAVE

    @Test
    fun saveIsCorrect() {
        Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
        val response = AppService.save(newObject)
        Assertions.assertEquals(response.iddoctor, newObject.id)
        Assertions.assertEquals(response.nombre, newObject.scooter)
        Assertions.assertEquals(response.apellido, newObject.distancia)

    }

    val jsonString = File("./src/test/resources/app/crearApp.json").readText(Charsets.UTF_8)
    val appMock = Gson().fromJson(jsonString, App::class.java)

    @Test
    fun saveApp() {
        //Mockito.`when`(dietRepository.findById(dietMock.id)).thenReturn(dietMock)
        Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(appMock)
        val response = appService.save(appMock)
        Assertions.assertEquals(response.id, appMock.id)
        Assertions.assertEquals(response.scooter, appMock.scooter)
        Assertions.assertEquals(response.distancia, appMock.distancia)
    }


    @Test
    fun saveAppFailedScooter() {
        Assertions.assertThrows(Exception::class.java) {
            appMock.apply { scooter = " " }

            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(appMock)
            appService.save(appMock)
        }

    }

    @Test
    fun saveAppFailedDistancia() {
        Assertions.assertThrows(Exception::class.java) {
            appMock.apply { distancia = " " }

            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(appMock)
            appService.save(appMock)
        }

    }



    //UPDATE


    @Test
    fun updateAppIsIdCorrect(){
        Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(returnObject)
        Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
        val response = appService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.scooter, newObject.scooter)
        Assertions.assertEquals(response.distancia, newObject.distancia)
    }

    @Test
    fun updateAppIsIdFailedWhenIdNotExist() {
        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(null)
            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
            appService.update(newObject)
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
    fun updateDoctorFailedDistancia(){
        Assertions.assertThrows(Exception::class.java) {
            appMock.apply { distancia= " "}
            Mockito.`when`(appRepository.findById(returnObject.id)).thenReturn(appMock)
            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(appMock)
            appService.update(appMock)
        }

    }


    //DELETE

    @Test
    fun deleteAppCorrect(){
        Mockito.`when`(appRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
        val response = appService.delete(newObject.id)
        Assertions.assertEquals(response, true)
    }

    @Test
    fun deleteAppIsFailed(){
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(appRepository.findById(newObject.id)).thenReturn(null)
            Mockito.`when`(appRepository.save(Mockito.any(App::class.java))).thenReturn(returnObject)
            val response = appService.delete(newObject.id)
            Assertions.assertEquals(response, true)
        }
    }

}
