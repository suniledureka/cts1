package com.cognizant.boot.utils;

import java.util.Base64;

public class SecurityUtility {
	
	public SecurityUtility() {
		System.out.println("SecurityUtility :: Constructor");
	}

	public String encodeData(String data) {
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedData = encoder.encodeToString(data.getBytes());
		return encodedData;
	}	
	
	public void myInit() {
		System.out.println("SecurityUtility Initialization");
	}
	
	public void destroy() {
		System.out.println("SecurityUtility Destructor");
	}
}
