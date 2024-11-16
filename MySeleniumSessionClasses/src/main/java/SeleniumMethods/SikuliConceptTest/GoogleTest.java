package SeleniumMethods.SikuliConceptTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	public static void main(String[] args) {
		// Google test through sikuli concept

//		Now, no need to take the headache of XPath, CSS, ID and Name.
//
//		+Sikuli is an image-based open source tool to automate the GUI and can be used on any platform like Windows/Linux/Mac/Mobile.
//
//		+Sikuli uses a technique called image recognition to identify and control GUI components.
//
//		====================================================
//		• Automate using images
//		• No API to launch Browser and URL – need to use selenium
//		• Can automate flash objects – YouTube video
//		• Desktop application automation

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");

	}

}
