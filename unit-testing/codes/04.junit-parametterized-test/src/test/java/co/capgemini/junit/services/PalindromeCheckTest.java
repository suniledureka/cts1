package co.capgemini.junit.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.capgemni.junit.services.PalindromeCheck;

class PalindromeCheckTest {
	static PalindromeCheck palObj;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		palObj = new PalindromeCheck();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		palObj = null;
	}


	@ParameterizedTest
	@ValueSource(strings = {"eye", "malayalam", "racecar", "Radar", "liril", "madam"})
	void testIsPalindrome(String str) {
		System.out.println(str);
		boolean actual = palObj.isPalindrome(str);
		assertTrue(actual);
	}
}
