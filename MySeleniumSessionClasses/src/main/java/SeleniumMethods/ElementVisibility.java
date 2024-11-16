package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementVisibility {

	public static void main(String[] args) throws InterruptedException {
		// element visibility

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://paytm.com/");

		//1. isDisplayed method: *******************************

		boolean b1 = driver.findElement(By.xpath("//button[@id='flightSearch']")).isDisplayed();
		System.out.println("The button is visible in web page: " + b1);

		//driver.close();

		Thread.sleep(2000);

		//2. isEnabled method: *******************************

	    //driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_pushbutton_disabled2");
	    driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_pushbutton_disabled2");
	    //Thread.sleep(2000);

	    // switch to iframe
	   // driver.switchTo().frame(By.xpath("//iframe[@name='iframeResult']"));
	   WebElement frame = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
	   driver.switchTo().frame(frame);

	    //validated enabled element
	   WebElement myBtn = driver.findElement(By.xpath("//button[text()='My Button']"));
	   boolean b2 = myBtn.isEnabled();
	    //boolean b2 = driver.findElement(By.xpath("//button[text()='My Button']")).isEnabled();
	   System.out.println("The My Button is enabled: " + b2);

	    // validate button is disabled
	    WebElement tryItBtn = driver.findElement(By.xpath("//button[text()='Try it']"));
	    tryItBtn.click();
	    boolean b3 = myBtn.isEnabled();
	    System.out.println("The button is disabled: " + b3);

	    Thread.sleep(2000);



	    // 3. isSelected method: **********************************************

	    driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
	    driver.navigate().refresh();
	    Thread.sleep(2000);

	    // switch to frame
	    driver.switchTo().frame(frame);


	    //Select HTML radio button
	    WebElement htmlRadio = driver.findElement(By.xpath("//input[@id='html']"));
	    htmlRadio.click();
	    boolean b4 = htmlRadio.isSelected();
	    System.out.println("The radio button is selected: " + b4);

	    //click submit button
	    driver.findElement(By.xpath("//input[@type='submit']")).click();

	    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'HTML')]")).getText());





	}

}
