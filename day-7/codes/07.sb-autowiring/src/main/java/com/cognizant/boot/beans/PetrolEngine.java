package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine {

	public PetrolEngine() {
		System.out.println("PetrolEngine :: Constructor");
	}

	@Override
	public boolean startEngine() {
		System.out.println("Starting Petrol Engine!!!");
		boolean engineStatus = new Random().nextBoolean();
		return engineStatus;
	}

}
