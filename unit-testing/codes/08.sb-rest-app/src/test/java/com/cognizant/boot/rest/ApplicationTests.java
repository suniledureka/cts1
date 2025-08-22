package com.cognizant.boot.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.boot.rest.controllers.WelcomeRestController;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	WelcomeRestController welController;
	
	
	@Test
	void contextLoadsController() {
		Assertions.assertThat(welController).isNotNull();
	}	

}
