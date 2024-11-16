package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTable {

	public static void main(String[] args) {
		// handling dynamic table - print the row value

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://money.rediff.com/index.html");

		System.out
				.println("Title of sectoral 1 row: " + driver.findElement(By.xpath("//div[@id='power']/b")).getText());

		WebElement h5Ele = driver.findElement(By.xpath("//div[@id='power']/b/following-sibling::h5"));
		String h5Value = h5Ele.getText();

		System.out.println("Power value h5: " + h5Value);

		WebElement h6Ele = driver.findElement(By.xpath("//div[@id='power']/b/following-sibling::h6"));
		String h6Value = h6Ele.getText();

		System.out.println("Power value h6: " + h6Value);

		// check the new value of h5 is match with old value or not
		if (h5Value.contains("8299.30")) {
			System.out.println("The h5 value is match with new value");
		} else {
			System.out.println("The h5 new value is not match with old value");
		}

		// check the new value of h6 is match with old value or not
		if (h6Value.contains("+0.22%")) {
			System.out.println("The h6 value is match with new value");
		} else {
			System.out.println("The h6 new value is not match with old value");

		}

		driver.close();
	}

}
