package com.cognizant.spring.core;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//-- initialize spring container
		//BeanFactory context = new ClassPathXmlApplicationContext("user-beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		System.out.println("=".repeat(80));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println("=".repeat(80));
		
		System.out.println("*********** BEAN NAMES **************\n");
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		//using normal for loop
		for(int i=0; i<beanNames.length; i++) {
			String beanName = beanNames[i];
			System.out.println("----> " + beanName);
		}
		System.out.println("-".repeat(80));
		
		//using for..each loop/ enhanced for loop
		for(String beanName : beanNames) {
			System.out.println("----> " + beanName);
		}
		System.out.println("-".repeat(80));
		
		//using stream API
		Arrays.stream(beanNames).forEach(beanName -> System.out.println("----> " + beanName));
		System.out.println("-".repeat(80));
		
		//using stream API with method reference
		Arrays.stream(beanNames).forEach(System.out::println);
	}
}
