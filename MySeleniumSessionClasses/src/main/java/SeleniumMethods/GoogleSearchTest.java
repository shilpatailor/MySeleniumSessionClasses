package SeleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		// auto suggestion handling

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");

		//click on search box
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");

		//find the length of all the suggestions list
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//descendant::div[@role='option']"));
		System.out.println("total number of suggestions in search box: " + list.size());

		//iterate all the suggestions and print text and click on the exact text
		for (WebElement element : list) {
			System.out.println(element.getText());
			Thread.sleep(2000);

//			if(list.get(i).getText().contains("selenium python"));
//			{
//				list.get(i).click();
//				break;
//			}

			if(element.getText().equalsIgnoreCase("selenium python"))
			{
				element.click();
				break;
			}
		}

		driver.close();

	}

}
