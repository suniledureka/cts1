package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

//@Component
//@Component("mycar")
@Component(value = "mycar")
public class Car {

	public Car() {
		System.out.println("Car :: Constructor");
	}
	
	public void startJourney() {
		boolean startStatus = new Random().nextBoolean();
		
		if(startStatus)
			System.out.println("Happy Journey!!!");
		else
			System.err.println("Journey Cancelled!!");
	}
}
