package com.cognizant;

import java.lang.reflect.Field;

import com.cognizant.models.Product;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Product prod = new Product();
		System.out.println(prod);
		
		Class<?> prodClass = Class.forName("com.cognizant.models.Product");
		
		Field prodNameField = prodClass.getDeclaredField("productName");
		prodNameField.setAccessible(true);
		
		prodNameField.set(prod, "Mobile Phone");
		System.out.println(prod);
	}
}
