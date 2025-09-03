package com.cognizant.boot.security;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.boot.security.controllers.WelcomeRestController;

@SpringBootApplication
public class Application {
	
	private final WelcomeRestController welcomeRestController;

	Application(WelcomeRestController welcomeRestController) {
		this.welcomeRestController = welcomeRestController;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*
		 * for(int i=1; i<=10; i++){ for(int j=1; j<=i; j++){ System.out.print(j+"   ");
		 * } System.out.println(); }
		 */
		/*
		IntStream.rangeClosed(1, 10).forEach(i -> {
			IntStream.rangeClosed(1, i).forEach(j -> System.out.print(j + "   "));
			System.out.println();
		});
		*/
		
		/*
		List<String> names = Arrays.asList("Anil","Suraj","Praveen","Sanjay","Suraj","Anil","Anil", "anil");
		
		Map<String, Long> namesByCount = names.stream()
				  .collect(Collectors.groupingBy(Function.identity(), 
						  						 Collectors.counting()));		
		System.out.println(namesByCount);	
		System.out.println();
		*/

	}

}
