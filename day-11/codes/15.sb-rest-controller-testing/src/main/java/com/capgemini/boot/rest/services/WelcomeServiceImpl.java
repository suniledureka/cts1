package com.capgemini.boot.rest.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String generateWelcomeMessage() {
		return "Welcome to Capgemini";
	}

}
