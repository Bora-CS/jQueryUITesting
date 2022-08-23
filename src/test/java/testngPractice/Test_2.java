package testngPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_2 {
	
	@BeforeMethod
	public void beforeMethodTest() {
		System.out.println("This is before method");
	}
	
	@Test
	public void test_1() {
		System.out.println("This is Test_2 1st test");
	}
	
	@Test
	public void test_2() {
		System.out.println("This is Test_2 2nd test");
	}
	
	@Test
	public void test_3() {
		System.out.println("This is Test_2 3rd test");
	}
	
	@AfterClass
	public void afterClasstest() {
		System.out.println("This is Test_2 after class");
	}
	
	@AfterSuite
	public void afterSuitetest() {
		System.out.println("This is Test_2 after suite");
	}
	
	

}
