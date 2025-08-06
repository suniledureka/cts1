package com.cognizant.spring.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.Hospital;

public class LauncherApp {

	public static void main(String[] args) throws InterruptedException {
		try(var context = new ClassPathXmlApplicationContext("hospital-beans.xml"))
		{
			Hospital hosp = (Hospital)context.getBean("apollo");
			
			System.out.println("Hospital Name: " + hosp.getHospitalName());
			System.out.println();
			
			Map<String, String> heads = hosp.getDeptsHeads();
			
			Set<Map.Entry<String, String>> entries = heads.entrySet();
			
			Iterator<Map.Entry<String, String>> it = entries.iterator();
			
			while(it.hasNext()) {
				Map.Entry<String, String> entry = it.next();
				String deptName = entry.getKey();
				String deptHead = entry.getValue();
				
				String output = String.format("%-10s ----> %s", deptName, deptHead);
				System.out.println(output);
				Thread.sleep(2000);
			}
			System.out.println();
			
			entries.forEach(entry -> System.out.println(entry.getKey() + " ----> " + entry.getValue()));
			System.out.println();
			
			heads.forEach((key, value) -> System.out.println(key + " ----> " + value));
		}
	}

}
