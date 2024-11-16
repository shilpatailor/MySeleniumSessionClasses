package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// Open make my trip url and close login popup and add from and to destination

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// open url
		driver.get("https://www.makemytrip.com/");

		//close login popup
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

		Thread.sleep(3000);

		//click on the From destination field and select mumbai
		WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
		from.click();

		//click on the from textbox
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mumbai");

		//click on visible text
        driver.findElement(By.xpath("//span[text()='Mumbai']")).click();

		//click To destination field and select banglore
		WebElement to = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
		to.click();
		to.sendKeys("Bengaluru");
		driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();

		//select the date through date picker using javascript executor

		WebElement date = driver.findElement(By.xpath("//label[@for='departure']"));
		String dateValue = "Monday, 11 Mar 2024";
//		WebElement selectdate = driver.findElement(By.xpath("//div[@aria-label='"+dateValue+"']"));

		selectDateByJS(driver, date, dateValue);


	}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAtrribute('value', '"+dateValue+"');", element);

		driver.findElement(By.xpath("//*[@aria-label="+dateValue+"]"));
	}

}
