package com.AppScooter.service

import com.AppScooter.model.App
import com.AppScooter.model.Scooter
import com.AppScooter.model.Usuarios
import com.AppScooter.repository.ScooterRepository
import com.AppScooter.repository.UsuariosRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest

class ScooterServiceTest {
    @InjectMocks
    lateinit var scooterService: ScooterService

    @Mock
    lateinit var scooterRepository: ScooterRepository

    @Mock
    lateinit var usuariosRepository: UsuariosRepository


    val returnObject: Scooter = Scooter().apply {
        id= 1
        habilitado= "Si"
        unidad= "4"
    }
    val newObject: Scooter = Scooter().apply {
        id= 1
        habilitado= "Si"
        unidad= "4"
    }

    //SAVE

    @Test
    fun saveIsCorrect(){


        Mockito.`when`(scooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(returnObject)
        val response = scooterService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.habilitado, newObject.habilitado)
        Assertions.assertEquals(response.unidad, newObject.unidad)

    }

    val jsonString = File("./src/test/resources/scooter/crearScooter.json").readText(Charsets.UTF_8)
    val scooterMock = Gson().fromJson(jsonString, Scooter::class.java)

    val jsonString1 = File("./src/test/resources/usuario/crearUsuario.json").readText(Charsets.UTF_8)
    val usuariosMock = Gson().fromJson(jsonString1, Usuarios::class.java)

    @Test
    fun saveScooter(){


        Mockito.`when`(scooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(scooterMock)
        val response = scooterService.save(scooterMock)
        Assertions.assertEquals(response.id, scooterMock.id)
        Assertions.assertEquals(response.habilitado, scooterMock.habilitado)
        Assertions.assertEquals(response.unidad, scooterMock.unidad)
    }

    @Test
    fun saveScooterFailedUsuarios(){
        Assertions.assertThrows(Exception::class.java) {


            Mockito.`when`(scooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(scooterMock)
            scooterService.save(scooterMock)
        }

    }

    //UPDATE


    @Test
    fun updateAppIsIdCorrect(){

        Mockito.`when`(scooterRepository.findById(returnObject.id)).thenReturn(returnObject)
        val response = scooterService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.habilitado, newObject.habilitado)
        Assertions.assertEquals(response.unidad, newObject.unidad)
    }
    @Test
    fun updateUsuariosIsIdFailedWhenIdNotExist() {
        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(scooterRepository.findById(returnObject.id)).thenReturn(null)
            Mockito.`when`(scooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(returnObject)
            scooterService.update(newObject)
        }
    }


    @Test
    fun updateScooterFailedUsuarios(){
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(scooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(scooterMock)

        }

    }

    @Test
    fun updateUsuariosFailedScooter() {
        Assertions.assertThrows(Exception::class.java) {

            Mockito.`when`(scooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(scooterMock)

        }
    }



    //DELETE

    @Test
    fun deleteAppCorrect(){
        Mockito.`when`(ScooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(returnObject)
        val response = scooterService.update(newObject)
        Assertions.assertEquals(response, true)
    }

    @Test
    fun deleteAppIsFailed(){
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(ScooterRepository.save(Mockito.any(Scooter::class.java))).thenReturn(returnObject)
            val response = scooterService.update(newObject)
            Assertions.assertEquals(response, true)
        }
    }
    @Test
    fun updateScooterIsListCorrect(){
        Mockito.`when`(scooterRepository.findById(returnObject.id)).thenReturn(returnObject)
        val response = scooterService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.unidad, newObject.unidad)
    }

    @Test
    fun updateCategoriasIsListIncorrect(){
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(scooterRepository.findById(returnObject.id)).thenReturn(scooterMock)
            Mockito.`when`(scooterRepository.save(Mockito.any(scooterMock::class.java))).thenReturn(scooterMock)
            scooterMock.update(scooterMock)
        }
    }
}

