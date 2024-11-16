package SeleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		// Mouse hover to any element

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//
//		// maximize the window
//		driver.manage().window().maximize();
//
//		//delete all cookies
//		driver.manage().deleteAllCookies();
//
//		//open url
//		driver.get("https://www.spicejet.com/");
//
//		// create actions class object
//		Actions action = new Actions(driver);
//
//		WebElement addOnElement = driver.findElement(By.xpath("//div[text()='Add-ons']"));
//
//		//perform mouse over action
//		action.moveToElement(addOnElement).build().perform();
//
//		// add some wait
//		Thread.sleep(3000);
//
//		//click on the spice max element
//		driver.findElement(By.xpath("//div[text()='SpiceMax']")).click();
//
//		//close browser
//		driver.quit();
//
//		Thread.sleep(3000);

//		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();

		// maximize the window
		driver1.manage().window().maximize();

		//delete all cookies
		driver1.manage().deleteAllCookies();

		// handle multiple mouse hover element
		driver1.get("https://www.geeksforgeeks.org");

		Thread.sleep(3000);

		Actions action1 = new Actions(driver1);

		//find elements
		WebElement tutorials = driver1.findElement(By.xpath("//div[text()='Tutorials']"));
		WebElement pythonTutorials = driver1.findElement(By.xpath("//ul[contains(@class,'megaDropDown')]//a[text()='Python Tutorial']"));
		WebElement pythonExercise = driver1.findElement(By.xpath("//ul[contains(@class,'megaDropDown')]//a[text()='Python Exercises']"));

	    action1.moveToElement(tutorials).moveToElement(pythonTutorials).moveToElement(pythonExercise).build().perform();

		// add some wait
		Thread.sleep(3000);

		driver1.findElement(By.xpath("//ul[contains(@class,'megaDropDown')]//a[text()='Python List Exercise']")).click();







	}

}
