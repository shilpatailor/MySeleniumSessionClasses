package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	//Pre conditions annotations -- starting with @Before
	@BeforeSuite
	public void setUp()
	{
		System.out.println("setup system property for chrome!");
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("Launch chrome browser!");
	}
	
	@BeforeMethod
	public void enterUrl()
	{
		System.out.println("Enter google url!");
	}
	
	@BeforeTest
	public void login()
	{
		System.out.println("login method!");
	}
	
  //test cases -- staring with @Test
  @Test
  public void googleTitleTest() 
  {
	  System.out.println("Google title test!");
  }
  
  // Post conditions -- starting with @After
  @AfterMethod
  public void logout()
  {
	  System.out.println("Logout from app!");
  }
  
  @AfterTest
  public void deleteAllCookies()
  {
	  System.out.println("deleteALlCookies");
  }
  
  @AfterClass
  public void closeBrowser()
  {
	  System.out.println("Close browser!");
  }
  
  @AfterSuite
  public void generateTestReport()
  {
	  System.out.println("Generate test report!");
  }
}
