package SeleniumMethods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException{
		// how to verify broken links and images

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//enter url
		driver.get("https://makemysushi.com/");

//		//login to this site
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shilpa.tailor@globallogic.com");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
//		driver.findElement(By.xpath("//div[text()='Login']")).click();
//
	    Thread.sleep(2000);

		//1. find the all the links and images
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.add(driver.findElement(By.tagName("img")));

		System.out.println("Size of all the links and images: " + linkList.size());

		//2. Find only href tag links and images
		List<WebElement> activeLinks = new ArrayList<>();

		//iterate link list: exclude all the links and images -- does not have nay href attribute
		for(int i=0; i<linkList.size(); i++)
		{
			System.out.println(linkList.get(i).getAttribute("href"));
			if(linkList.get(i).getAttribute("href") != null && (!linkList.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(linkList.get(i));
			}
		}

		//print all the active links and images
		System.out.println("Size of all the active links and images: " + activeLinks.size());

		//3. check the href url, with httpconnection api
		for (WebElement activeLink : activeLinks) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLink.getAttribute("href")).openConnection();

			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();

			System.out.println(activeLink.getAttribute("href") + "-->" + response);

		}


		driver.close();

	}

}
