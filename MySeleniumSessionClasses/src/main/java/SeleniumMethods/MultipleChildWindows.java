package SeleniumMethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleChildWindows {

	public static void main(String[] args) {
		// handle multiple child windows   - this program is not working

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/browser-windows");

		//open all the windows
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();

		//handle main window
		String mainWindow = driver.getWindowHandle();
		System.out.println("This is a main window: " + mainWindow);

		//handle the all windows
		Set<String> allWindowsHandler = driver.getWindowHandles();
		System.out.println("Child windows are: " + allWindowsHandler);



		//handle child windows and switch to child window

		for (String childWindow : allWindowsHandler) {
			if(!mainWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.close();
				System.out.println("Title of the child windows: " + driver.getTitle());
			}
		}

		//switch to the parent window
		driver.switchTo().window(mainWindow);
	}

}
