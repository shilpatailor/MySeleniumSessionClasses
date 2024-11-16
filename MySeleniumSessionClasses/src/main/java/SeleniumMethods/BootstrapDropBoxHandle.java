package SeleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropBoxHandle {

	public static void main(String[] args) throws InterruptedException {
		// Handle bootstarp drop boox // if the tag is select tag or it's button or div
		// tag then use this method

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");

		driver.findElement(By.xpath("//button[contains(@data-toggle,'dropdown')]")).click();

		List<WebElement> list = driver
				.findElements(By.xpath("//button[contains(@data-toggle,'dropdown')]//following-sibling::ul/li"));
		System.out.println(list.size());

		//select only one element
//		for (int i = 0; i <= list.size(); i++) {
//			System.out.println(list.get(i).getText());
//			if(list.get(i).getText().contains("Angular"))
//			{
//				list.get(i).click();
//				break;
//			}
//		}

		// select all the elements if already selected the un-select the already selected one
//		for(int i=0; i<list.size(); i++)
//		{
//			System.out.println(list.get(i).getText());
//			list.get(i).click();
//
//		}

		//select all the elements if already selected the ignore the selected elements
		for (WebElement element : list) {
			System.out.println(element.getText());
			//list.get(i).click();

			if(element.getAttribute("class").equalsIgnoreCase("active"))
			{
				System.out.println("Already active elements are: " + element.getText());
				Thread.sleep(500);
			}else
			{
				element.click();

			}


		}
	}

}
