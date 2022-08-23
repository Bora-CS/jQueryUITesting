package testngPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TestAnnatation_1 {
	
	
	
	
	
	@Test
	public void firsttest() {
		System.out.println("This is first test");
	}
	
	@Test
	public void secondTest() {
		System.out.println("This is second test");
	}
	
	@Test
	public void thirdTest() {
		System.out.println("This is third test");
	}
	
	@AfterTest
	public void afterTestPracice() {
		System.out.println("This is after Test");
	}
	
	//@AfterMethod
	public void afterMethodTest() {
		System.out.println("This is after method");
	}
	
	@AfterClass
	public void afterClassTest() {
		System.out.println("This is after class");
	}

}
