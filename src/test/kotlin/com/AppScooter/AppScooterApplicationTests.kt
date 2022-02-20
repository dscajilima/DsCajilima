package com.AppScooter

import com.AppScooter.service.AppService
import com.AppScooter.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

 @SpringBootTest
class AppScooterApplicationTests {

	@Autowired
	lateinit var appService : AppService;

	@Test
	fun contextLoads() {
	}

	@Test
	fun verifySizeWordWhenIsIncorrect(){
		val response: Boolean = appService.verificarLetras("01064", "Diego Sebastian Cajilima Sauce", "Diego Sebastian Cajilima Sauce")
		Assertions.assertEquals(false,response)
	}

	@Test
	fun verifySizeWordWhenIsCorrect(){
		val response: Boolean = appService.verificarLetras("0106427206", "Diego Sebastian", "Cajilima Sauce")
		Assertions.assertEquals(true,response)
	}


}