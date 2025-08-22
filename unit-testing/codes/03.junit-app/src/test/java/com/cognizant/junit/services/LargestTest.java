package com.cognizant.junit.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.function.Executable;

import com.cognizant.junit.services.Largest;


@DisplayName("TEST CASES TO FIND LARGEST")
//@TestMethodOrder(Alphanumeric.class)
@TestMethodOrder(value = org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
//@Disabled
class LargestTest {
	static Largest larObj = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		larObj = new Largest();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		larObj = null;
	}


	@Test
	@DisplayName(value = "FOR ALL +VE NUMBERS")
	@Order(1)
	void testFindLargest() {
		int[] data = {58,46,92,71,68,10};
		int expected = 92;
		int actual = larObj.findLargest(data);
		assertEquals(expected, actual);
	}

	@Test
	@Order(4)
	void testFindLargest1() {
		int[] data = {-58,46,-92,71,-68,10};
		int expected = 71;
		int actual = larObj.findLargest(data);
		assertEquals(expected, actual);
	}	
	
	@Test
	@Order(value = 3)
	@DisplayName("FOR ALL -VE NUMBERS")
	void testFindLargest2() {
		int[] data = {-58,-46,-92,-71,-68,-10};
		int expected = -10;
		int actual = larObj.findLargest(data);
		assertEquals(expected, actual);
	}
	
	@Test
	@Order(value = 2)
	//@Disabled
	void testFindLargest3() {
		int[] data = {};
		/*
		assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				larObj.findLargest(data);				
			}			
		});
		*/
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> larObj.findLargest(data));				
	}	
}
