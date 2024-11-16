package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	public static void main(String[] args) {
		// explicit wait concept

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/login");
		//clickOn(driver, driver.findElement(By.xpath("//button[@id='loginbutton']")), 20);

	}

	// create method for explicit wait
//	public static void clickOn(WebDriver driver, WebElement locator, int timeout)
//
//	{
//		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
//		.until(ExpectedConditions.elementToBeClickable(locator));
//		locator.click();
//	}

}
