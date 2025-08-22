package com.cognizant.boot.rest.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognizant.boot.rest.services.WelcomeServices;

@WebMvcTest(value = WelcomeRestController.class)
class WelcomeRestControllerTest {

	@MockitoBean // from spring boot 3.4.0  -- before that @MockBean
	private WelcomeServices welService;

	@Autowired
	private MockMvc mockMvc; // used to send a request to REST API /welcome

	@Test
	void testShowWelcomeMessage() throws Exception {
		
		// define mock object behaviour
		Mockito.when(welService.generateWelcomeMessage()).thenReturn("Welcome to Cognizant");
		
		/*
		// prepare HTTP get request
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/welcome");

		// send request
		ResultActions perform = mockMvc.perform(reqBuilder);

		// hold the response
		MvcResult mvcResult = perform.andReturn();

		// validate response
		MockHttpServletResponse response = mvcResult.getResponse();

		String responseText = response.getContentAsString();
		System.out.println(responseText);
		
		int status = response.getStatus();
		System.out.println(status);

		assertNotNull(responseText);
		assertEquals(200, status);	
		*/
		
	
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
		  .andExpect(MockMvcResultMatchers.status().isOk());

	}

}
