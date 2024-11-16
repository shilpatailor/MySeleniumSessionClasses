package SeleniumMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args){
		// how to verify broken links from particular page

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//enter url
		driver.get("https://ui.cogmento.com/");

		//login to this site
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shilpa.tailor@globallogic.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//div[text()='Login']")).click();


		//1. get the list of all the links and images:
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Size of full links and images: " + linkList.size());

		//find only href links
		List<WebElement> activeLinkS = new ArrayList<>();

		//2 iterate LinkList: exclude all the links/images - doesn't have any href attribute
		for(int i=0; i<linkList.size(); i++)
		{
			if(activeLinkS.get(i).getAttribute("href")!= null)
			{
				activeLinkS.add(linkList.get(i));
			}
		}

		//get the size of active link list:
		System.out.println("Size of active links and images: " + activeLinkS.size());


	}

}
