package SeleniumMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		// test

		WebDriver driver = new ChromeDriver();

		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.25.0");

		System.out.println(driver.getTitle());

		Thread.sleep(1000);

		driver.navigate().to("https://www.programiz.com/java-programming/online-compiler/");

		System.out.println(driver.getTitle());

		Thread.sleep(1000);

		driver.navigate().back();
	}

}
