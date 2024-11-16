package SeleniumMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropertiesFiles {

	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// Read the properties file

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/usr/local/google/home/shilpatailor/eclipse-workspace/MySeleniumSessionClasses/src/main/java/SeleniumMethods/config.properties");

		prop.load(ip);


		String browseName = prop.getProperty("browser");
		if(browseName.equals("chrome")) {
//		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}else if(browseName.equals("FF")) {
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("URL"));

		System.out.println("Before search, title: " + driver.getTitle());

		WebElement search = driver.findElement(By.xpath(prop.getProperty("search_Xpath")));
		        search.click();
				search.sendKeys(prop.getProperty("searchKeyword"));
				search.sendKeys(Keys.ENTER);


	   Thread.sleep(2000);

	   System.out.println("After search, title: " + driver.getTitle());

	   driver.close();





	}

}
