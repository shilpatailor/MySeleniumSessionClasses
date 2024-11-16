package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		// Navigations command

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://google.com/");

		Thread.sleep(2000);

		driver.navigate().to("https://www.amazon.in/");

		driver.navigate().back();

		Thread.sleep(2000);

		driver.navigate().forward();

		Thread.sleep(2000);

		driver.navigate().back();

		driver.navigate().refresh();

	}


}
