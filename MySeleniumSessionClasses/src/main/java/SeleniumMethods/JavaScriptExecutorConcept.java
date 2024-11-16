package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {
		// JavaScript executor concept
		// 1. click method, 2. how to write a text value without using sendKeys method

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.scientecheasy.com/");

		WebElement searchEle = driver.findElement(By.xpath("//div[@class='ct-panel-content']//form[@role='search']"));
		WebElement clickElement = driver.findElement(By.xpath("//div[@class='ct-panel-content']//button[@type='submit']"));

		//click on the element with using JavaScript executor method
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()", clickElement);
		js.executeScript("arguments[0].value = 'Selenium', arguments[1].click()", searchEle, clickElement);

		//write input text
		//js.executeScript("arguments[0].value = 'Selenium", searchEle);

		Thread.sleep(2000);

		//click on search button
		//js.executeScript("arguments[0].click()", clickElement);

		//Thread.sleep(2000);

		//scroll top to down 1000 px
		js.executeScript("window.scrollBy(0, 1000)");

		//scroll to specific element
		WebElement isDispalyedEle = driver.findElement(By.xpath("//a[contains(text(), 'isDisplayed')]"));
		js.executeScript("arguments[0].scrollInToViiew", args);

	}

}
