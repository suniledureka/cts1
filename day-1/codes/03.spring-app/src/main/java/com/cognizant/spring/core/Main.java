package com.cognizant.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//-- initialize spring container		
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		System.out.println("=".repeat(80));
		
		//((ConfigurableApplicationContext)context).close();
		((ConfigurableApplicationContext)context).registerShutdownHook();
	}
}