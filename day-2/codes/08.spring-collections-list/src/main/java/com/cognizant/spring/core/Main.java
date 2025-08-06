package com.cognizant.spring.core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.Hospital;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hospital-beans.xml");
		
		Hospital hosp = (Hospital)context.getBean("apollo");
		
		System.out.println("Hospital Name = " + hosp.getHospitalName());
		
		System.out.println("------------ DEPARTMENTS ----------------");
		List<String> departments = hosp.getDeptNames();
		
		departments.stream().forEach(dept -> System.out.println("----> " + dept));
	}

}
