package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDateByJS {

	public static void main(String[] args) {


//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");

		driver.findElement(By.xpath("https://www.spicejet.com/"));

		//click on date picker
		WebElement date = driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 css-bfa6kz r-homxoj r-ubezar')]//preceding::div[@data-testid='departure-date-dropdown-label-test-id']"));
		date.click();

		String dateValue = "Sun, 8 Sep 2024";

		selectDateByJS(driver, date, dateValue);


	}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAtrribute('value', '"+dateValue+"');", element);
	}

}
