package com.cognizant.junit.services;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Palidrome | EvenOrOdd | Tests")
//@SelectClasses({ LargestTest.class, PalindromeCheckTest.class })
@SelectPackages(value = {"com.cognizant.junit.services"})
public class AllTests {

}
