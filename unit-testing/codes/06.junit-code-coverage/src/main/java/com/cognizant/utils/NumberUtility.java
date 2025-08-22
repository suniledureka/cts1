package com.cognizant.utils;

public class NumberUtility {
	
	public String checkEvenOrOdd(int num)
	{
		int rem = num % 2;
		if(rem == 0) {
			return "EVEN";
		}
		else {
			return "ODD";
		}
	}
}
