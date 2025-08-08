package com.cognizant.boot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
/*
@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration
*/
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("=".repeat(100));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans = " + noOfBeans);
		System.out.println("=".repeat(100));
		System.out.println();
		
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(bn -> System.out.println(bn));
	}
}