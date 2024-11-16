package SeleniumMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyPageSource {

	WebDriver driver;

	    @BeforeSuite
	    public void setUp()
	    {
	    	driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			driver.get("https://www.saucedemo.com/v1");
	    }


	    @Test
	    public void verifyPage()
	    {
	    	Assert.assertEquals(driver.getPageSource().contains("404") || driver.getTitle().contains("404"), false);
	    }







}
