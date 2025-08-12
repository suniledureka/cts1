package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine {

	public DieselEngine() {
		System.out.println("DieselEngine :: Constructor");
	}

	@Override
	public boolean startEngine() {
		System.out.println("Starting Diesel Engine!!!");
		boolean engineStatus = new Random().nextBoolean();
		return engineStatus;
	}

}
