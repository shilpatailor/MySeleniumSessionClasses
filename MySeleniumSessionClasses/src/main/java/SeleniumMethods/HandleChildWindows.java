package SeleniumMethods;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleChildWindows {

	public static void main(String[] args) throws InterruptedException {

        //launch chrome driver
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// open main url
		driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

		// click New Window button
		driver.findElement(By.xpath("//button[text()='New Window']")).click();

//		// click new window message button
//		driver.findElement(By.xpath("//button[text()='New Window Message']")).click();

		Thread.sleep(2000);

		// store all windows and iterate
		Set<String> allHandler = driver.getWindowHandles();
		Iterator<String> it = allHandler.iterator();

		// find and print parent window id
		String parentWindow = it.next();
		System.out.println("Child wioindow id: " + parentWindow);

		// find and print child window id
		String childWindow = it.next();
		System.out.println("Child window id: " + childWindow);


		// switch to child window
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);

		// print child window page title
		System.out.println("Child window title: " + driver.getTitle());

		// close child window
		driver.close();


		// switch to parent window
		driver.switchTo().window(parentWindow);

		Thread.sleep(2000);

		// print parent window page title
		System.out.println("Parent window title: " + driver.getTitle());

		Thread.sleep(2000);

		// close parent window
		driver.close();

	}

}
