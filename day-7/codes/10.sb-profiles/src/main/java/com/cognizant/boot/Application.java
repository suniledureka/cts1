package com.cognizant.boot;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.boot.beans.DBConnection;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		DBConnection dbcon = context.getBean(DBConnection.class);
		System.out.println(dbcon);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Add a New Book");
			System.out.println("2. Get All Books");
			System.out.println("3. Search for a Book By ID");
			System.out.println("4. Exit");
			
			System.out.print("what to do? ");
			int toDo = sc.nextInt();
			
			switch(toDo) {
			case 4: 
				System.exit(0);
			}
		}
	}
}