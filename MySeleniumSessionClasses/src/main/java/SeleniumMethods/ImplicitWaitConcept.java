package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {

	public static void main(String[] args) throws InterruptedException {
		// Handle implicit wait

		//Launch Chrome browser
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//Maximize window and delete all cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		//open URL
		driver.get("https://www.ebay.com/");

		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//click on the search button
		driver.findElement(By.xpath("//input[@value='Search']")).click();

		Thread.sleep(3000);

		driver.quit();







	}

}
