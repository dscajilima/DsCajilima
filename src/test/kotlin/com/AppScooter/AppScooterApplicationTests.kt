package com.AppScooter

import com.AppScooter.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HospitalApplicationTests {

	@Autowired
	lateinit var userService: UserService;

	@Test
	fun contextLoads() {
	}

	@Test
	fun verifySizeWordWhenIsIncorrect(){
		val response: Boolean = userService.verificarLetras("01064", "Diego Sebastian Cajilima Sauce", "Diego Sebastian Cajilima Sauce")
		Assertions.assertEquals(false,response)
	}

	@Test
	fun verifySizeWordWhenIsCorrect(){
		val response: Boolean = userService.verificarLetras("0106427206", "Diego Sebastian", "Cajilima Sauce")
		Assertions.assertEquals(true,response)
	}


}