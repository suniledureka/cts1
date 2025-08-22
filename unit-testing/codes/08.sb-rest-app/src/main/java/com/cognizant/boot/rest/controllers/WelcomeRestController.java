package com.cognizant.boot.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.boot.rest.services.WelcomeServices;

@RestController
public class WelcomeRestController {
	@Autowired
	private WelcomeServices service;
	
	
	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		String msg = service.generateWelcomeMessage();
		return msg;
	}	
}
