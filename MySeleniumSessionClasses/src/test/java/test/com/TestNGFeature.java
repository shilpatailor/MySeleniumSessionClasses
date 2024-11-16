package test.com;

import org.testng.annotations.Test;

public class TestNGFeature {

	@Test
	public void loginPage()
	{
		System.out.println("login page test");
		int i=9/0;
	}

	@Test(dependsOnMethods = "loginPage")
	public void searchPage()
	{
		System.out.println("search page test");
	}

	@Test(dependsOnMethods = "loginPage")
	public void homePage()
	{
		System.out.println("home page test");
	}
}
