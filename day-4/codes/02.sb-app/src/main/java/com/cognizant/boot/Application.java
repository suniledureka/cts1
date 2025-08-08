package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.boot.beans.Car;
import com.cognizant.boot.beans.configs.AppConfig;
import com.cognizant.boot.beans.controllers.VehicleController;
import com.cognizant.boot.utils.SecurityUtility;

@SpringBootApplication
public class Application {

    private final VehicleController vehicleController;

    private final AppConfig appConfig;

    Application(AppConfig appConfig, VehicleController vehicleController) {
        this.appConfig = appConfig;
        this.vehicleController = vehicleController;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("=".repeat(100)+"\n");
		
		System.out.println("no of beans = " + context.getBeanDefinitionCount());
		System.out.println("=".repeat(100)+"\n");
		
		//-- get the Car type bean from IoC/ spring container
		//Car carRef = context.getBean(Car.class);
		//Car carRef = (Car)context.getBean("car");
		//Car carRef = context.getBean("car", Car.class);
		Car carRef = (Car)context.getBean("mycar");
		
		carRef.startJourney();
		System.out.println("=".repeat(100)+"\n");
		
		//SecurityUtility secUtil = context.getBean(SecurityUtility.class);
		//SecurityUtility secUtil = (SecurityUtility) context.getBean("securityGenerator");
		//SecurityUtility secUtil = (SecurityUtility) context.getBean("security");
		SecurityUtility secUtil = (SecurityUtility) context.getBean("encoder");
		
		String pass = "mypassword123#";
		String encodedPass = secUtil.encodeData(pass);
		System.out.println(encodedPass);
		
		SecurityUtility secUtil1 = (SecurityUtility) context.getBean("encoder");
		
		System.out.println("=".repeat(100)+"\n");
		context.close();
	}

}
