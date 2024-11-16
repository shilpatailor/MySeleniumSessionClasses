package SeleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {
		// Drag and drop concept

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://jqueryui.com/droppable/");

		//handle frame
		driver.switchTo().frame(0); //index 0

		//create actions class object
		Actions action = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement srcElement = driver.findElement(By.xpath("//div[@id='droppable']"));

		//handle drag and drop option
		action.clickAndHold(targetElement).moveToElement(srcElement).release().build().perform();

		Thread.sleep(3000);

		driver.quit();





	}

}
