package com.capgemini.boot.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.boot.rest.controllers.WelcomeRestController;
import com.capgemini.boot.rest.services.WelcomeService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	WelcomeService welService;
	
	@Autowired
	WelcomeRestController welController;
	
	@Test
	void contextLoadsService() {
		Assertions.assertThat(welService).isNotNull();
	}

	@Test
	void contextLoadsController() {
		Assertions.assertThat(welController).isNotNull();
	}	
}
