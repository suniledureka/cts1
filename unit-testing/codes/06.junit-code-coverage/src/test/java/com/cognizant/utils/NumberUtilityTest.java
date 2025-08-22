package com.cognizant.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cognizant.utils.NumberUtility;

class NumberUtilityTest {
	static NumberUtility numObj ;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		numObj = new NumberUtility();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		numObj = null;
	}

	@Test
	void testCheckEvenOrOdd() {
		int num = 12;
		String expected = "EVEN";
		String actual = numObj.checkEvenOrOdd(num);
		assertEquals(expected, actual);
	}

	@Test
	void testCheckEvenOrOdd_01() {
		int num = 11;
		String expected = "ODD";
		String actual = numObj.checkEvenOrOdd(num);
		assertEquals(expected, actual);
	}	

}
