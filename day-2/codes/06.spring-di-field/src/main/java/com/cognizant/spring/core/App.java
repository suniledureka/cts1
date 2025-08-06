package com.cognizant.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.Customer;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customer-car-beans.xml");
		
		Customer cust = (Customer)context.getBean("sanjay");
		
		String custDetails = String.format("%s owns a %s car, which costs Rs. %.2f", cust.getCustomerName(), cust.getCar().getModel(), cust.getCar().getCost());
		System.out.println(custDetails);
	}

}
