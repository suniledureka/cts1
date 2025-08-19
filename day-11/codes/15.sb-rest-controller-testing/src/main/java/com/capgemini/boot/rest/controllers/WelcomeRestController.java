package com.capgemini.boot.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.boot.rest.services.WelcomeService;

@RestController
public class WelcomeRestController {
	private WelcomeService service;
	
	public WelcomeRestController(WelcomeService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		String msg = service.generateWelcomeMessage();
		return msg;
	}
}
