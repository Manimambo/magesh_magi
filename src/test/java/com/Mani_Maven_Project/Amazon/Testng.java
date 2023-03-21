package com.Mani_Maven_Project.Amazon;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class Testng {
	
	@BeforeSuite
	private void setup() {
		System.out.println("B Suite");
	}
	@BeforeTest
	private void browserLaunch() {
		System.out.println("B Test");
	}
	@BeforeClass
	private void launchUrl() {
		System.out.println("B Class");
	}
	@BeforeMethod
	private void LogIn() {
		System.out.println("B Method");
	}
	
//	@Parameters("m")
	@Test(priority = -1,groups = "mani")
	private void searchMobile1() {
		System.out.println("Test 1");
	}
	@Test(priority = 0,timeOut = 1000,expectedExceptions = ThreadTimeoutException.class)
	private void searchLaptop2() throws InterruptedException  {
		System.out.println("hi");
		Thread.sleep(3000);
		System.out.println("Test 2");
	}
	@Test(priority = -2, dependsOnMethods = "searchLaptop2")
	private void searchLaptop3() throws InterruptedException{
		Thread.sleep(0);
		System.out.println("Test 3");
	}
	
	@Test(priority=2,dependsOnGroups = "mani")
	private void searchLaptop4() {
		System.out.println("Test 4");
	}
	
	String s;

	@Test(priority=3,groups = "kandan",expectedExceptions = NullPointerException.class)
	private void searchLaptop5() {
		System.out.println("Hi");
		System.out.println("Test5"+s.toUpperCase());
	}
	@Test(priority =4,groups = "kandan",invocationCount = 3 )
	private void searchLaptop6() {
		System.out.println("Test 6");
	}
	@AfterMethod
	private void verify() {
		System.out.println("A Method");
	}
	@AfterClass
	private void logOut() {
		System.out.println("A Class");
	}
	@AfterTest
	private void closeBrowser() {
		System.out.println("A Test");
	}@AfterSuite
	private void deleteCookies() {
		System.out.println("A Suite");
	}

}
