package SeleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	    driver.get("https://www.google.com/");

	    //all the links are represnted by 'a' html tag

	   List <WebElement> linkList = driver.findElements(By.tagName("a"));

	   //size of link list
	   System.out.println("Size of all links are avilable in the site: " + linkList.size());

	   //name of the all links available in web
	   for (WebElement element : linkList) {
		 String linkText =  element.getText();
		 System.out.println(linkText);
	   }

	   driver.quit();

	}

}
