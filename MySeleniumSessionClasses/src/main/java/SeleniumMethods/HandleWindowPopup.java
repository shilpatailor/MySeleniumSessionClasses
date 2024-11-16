package SeleniumMethods;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		// How to handle window based pop ups

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/browser-windows");

		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		//driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();

		Thread.sleep(2000);

		Set<String> handler = driver.getWindowHandles();

		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("Parent window id: " + parentWindowId);

		String firstChildWindowId = it.next();
		System.out.println("Child Window id: " +firstChildWindowId);

//		String secondChildWindowId = it.next();
//		System.out.println("Child Window id: " +secondChildWindowId);

		driver.switchTo().window(firstChildWindowId);
		System.out.println(driver.switchTo().window(firstChildWindowId).getTitle());
		System.out.println("first child Window title: " + driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

		Thread.sleep(2000);

		driver.close();

//		Thread.sleep(2000);
//
//		driver.switchTo().window(secondChildWindowId);
//		System.out.println("second child Window title: " + driver.switchTo().window(secondChildWindowId).getTitle());
//
//		Thread.sleep(2000);
//
//		driver.close();
//
//		Thread.sleep(2000);

		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title: " + driver.getTitle());

		Thread.sleep(2000);

		driver.close();

	}

}
