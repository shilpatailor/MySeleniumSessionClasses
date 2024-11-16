package test.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {


	WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}

	@Test(priority = 1, groups = "Title Group")
	public void pageTitle()
	{
		String title = driver.getTitle();
		System.out.println("Title of the page: " + title);
		Assert.assertEquals(title, "Google1", "title not match");
	}

	@Test(priority = 2, groups = "Logo Group")
	public void googleLogoDisplayed()
	{
		boolean logo = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		System.out.println("Logo of the page: " + logo);
		Assert.assertTrue(logo);
	}

	@Test(priority = 3, groups = "Link Group")
	public void gmailLinkDisplayed()
	{
		boolean gmailLink = driver.findElement(By.xpath("//a[@aria-label='Gmail ']")).isDisplayed();
		System.out.println("Text of the gmail link: " + gmailLink);
	}

	@Test(priority = 4, groups = "Test Group")
	public void test1()
	{
		System.out.println("Test method1");
	}

	@Test(priority = 5, groups = "Test Group")
	public void test2()
	{
		System.out.println("Test method2");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
