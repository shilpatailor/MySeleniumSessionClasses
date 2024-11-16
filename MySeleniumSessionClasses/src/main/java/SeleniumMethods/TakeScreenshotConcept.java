package SeleniumMethods;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotConcept {

	public static void main(String[] args) throws IOException {
		// take screenshot  concept

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://google.com/");

		//Take screenshot and store as file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		//now copy the screenshot to desired location using copyFile/method
		FileUtils.copyFile(src, new File("/usr/local/google/home/shilpatailor/google.jpg"));
	}

}
