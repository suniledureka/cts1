package com.cognizant.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cognizant.utils.StringUtility;

class StringUtilityTest {
	static StringUtility strObj;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		strObj = new StringUtility();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		strObj = null;
	}

	@Test
	void testIsPalindrome() {
		String str = "madam";
		assertTrue(strObj.isPalindrome(str));
	}

	
	@Test
	void testIsPalindrome1() {
		String str = "java";
		assertFalse(strObj.isPalindrome(str));
	}	
}
