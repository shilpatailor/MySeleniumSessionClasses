package SeleniumMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTestSearch {

	public static void main(String[] args) throws InterruptedException {


	 WebDriver driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	 driver.manage().window().maximize();

	 driver.get("http://google.com/");

	 //click on search icon and enter keys
	WebElement search = driver.findElement(By.xpath("//textarea[@title='Search']"));

	search.click();
	search.sendKeys("facebook");

	//capture list of all suggestions
	List<WebElement> lists = driver.findElements(By.xpath
			("//ul[@role='listbox']//li//descendant::div[@class='wM6W7d']"));

	System.out.println("all suggestions: " + lists.size());

	for (WebElement list : lists) {

		System.out.println(list.getText());

	}



	Thread.sleep(2000);

	driver.close();

	}

}
