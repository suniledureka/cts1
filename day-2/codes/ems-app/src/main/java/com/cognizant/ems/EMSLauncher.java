package com.cognizant.ems;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.ems.models.Employee;
import com.cognizant.ems.services.EmployeeServices;

public class EMSLauncher {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ems-beans.xml");
		
		EmployeeServices empService = (EmployeeServices) context.getBean("emp-service");
		
		while(true) {
			System.out.println("1. Add Employee");
			System.out.println("2. List Employees");
			System.out.println("3. Exit");
			System.out.print("enter your option: ");
			
			int opt = sc.nextInt();
			
			switch(opt) {
			case 1:
				System.out.print("enter employee id: ");
				int eid = sc.nextInt();
				sc.nextLine();
				System.out.print("enter employee name: ");
				String name = sc.nextLine();
				empService.addEmployee(new Employee(eid, name));
				break;
			case 2:
				empService.listEmployees();
				break;
			case 3:
				System.out.println("Application designed & developed by CTS");
				System.exit(0);
				break;
			default:
				System.err.println("Invalid Option ... Try Again");
			}//switch
			System.out.println("-".repeat(100));
		}//while
		
	}

}
