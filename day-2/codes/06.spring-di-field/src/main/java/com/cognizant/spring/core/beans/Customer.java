package com.cognizant.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	@Autowired
	private String customerName;
	
	@Autowired
	//@Qualifier("bmw")
	@Qualifier(value = "audi")
	private Car car;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Car getCar() {
		return car;
	}

}
