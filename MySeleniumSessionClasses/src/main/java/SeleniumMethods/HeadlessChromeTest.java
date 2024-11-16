package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeTest {

	public static void main(String[] args) {


//		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");

		System.out.println("Title of the google page: " + driver.getTitle());

		driver.findElement(By.xpath("//a[@aria-label='Gmail ']")).click();

		System.out.println("Title of the gmail page: " + driver.getTitle());


	}

}
