package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FindLargestTest {
	private static FindLargest larObj;
	
	@BeforeAll
	public static void initializeTests() {
		System.out.println("before all");
		larObj = new FindLargest();
	}
	
	@Test
	void testFindLargest() {
		//FindLargest larObj = new FindLargest();
		int[] nums = {12, 25, 10, 13, 5, 6};
		
		int expectedValue = 25;
		int actualValue = larObj.findLargest(nums);
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testFindLargest_01() {
		//FindLargest larObj = new FindLargest();
		int[] nums = {-12, -25, -10, -13, -5, -6};
		
		int expectedValue = -5;
		int actualValue = larObj.findLargest(nums);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	void testFindLargest_02() {
		//FindLargest larObj = new FindLargest();
		int[] nums = {};
				
		assertThrows(ArrayIndexOutOfBoundsException.class, ()-> larObj.findLargest(nums));
	}
	
	@AfterAll
	public static void afterAllTests() {
		larObj = null;
		System.out.println("after all test cases");
	}
	
}