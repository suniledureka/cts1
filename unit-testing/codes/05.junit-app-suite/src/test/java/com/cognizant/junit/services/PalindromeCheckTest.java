package com.cognizant.junit.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.InputMismatchException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.capgemni.junit.services.PalindromeCheck;

class PalindromeCheckTest {

	@Test
	//@RepeatedTest(value = 2)
	@DisplayName(value = "Palindrome")
	@RepeatedTest(value = 2, name = "{displayName} --> {currentRepetition} of {totalRepetitions}")
	@Tag(value = "prod")
	void testIsPalindrome() {
		String str = "eye";
		PalindromeCheck palObj = new PalindromeCheck();
		assertTrue(palObj.isPalindrome(str));
	}

	@Test
	void testIsPalindrome_01() {
		String str = "java";
		PalindromeCheck palObj = new PalindromeCheck();
		assertFalse(palObj.isPalindrome(str));
	}	
	
	@Test
	void testIsPalindrome_02() {
		String str = null;
		PalindromeCheck palObj = new PalindromeCheck();
		assertThrows(NullPointerException.class, () -> palObj.isPalindrome(str));
	}	
	
	@Test
	void testIsPalindrome_03() {
		String str = "";
		PalindromeCheck palObj = new PalindromeCheck();
		assertThrows(InputMismatchException.class, () -> palObj.isPalindrome(str));
	}	
	
	@Test
	@DisplayName("testMethod")
	void testMethodInformation(TestInfo testInfo) {
		System.out.println("test class name = " + testInfo.getTestClass().get().getName());
		System.out.println("test method name = " + testInfo.getTestMethod().get().getName()+"()");
		System.out.println("display name = " + testInfo.getDisplayName());
		assertTrue(true);
	}
}
