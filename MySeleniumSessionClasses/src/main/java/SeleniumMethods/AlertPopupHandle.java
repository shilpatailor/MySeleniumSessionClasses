package SeleniumMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		// Handle alert popup using ALert class object reference

		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//Launch Rediff email login page
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		//Click on Signin button
		driver.findElement(By.xpath("//input[@name='proceed']")).click();

		// add some static wait
		Thread.sleep(5000);

		//Switch to the alert window
		Alert alert = driver.switchTo().alert();

		// Print alert text
		System.out.println(alert.getText());

		// Validate alert message is correct or not
		String text = alert.getText();

		if(text.equals("Please enter a valid user name"))
		{
			System.out.println("alert message is correct!");
		}else {
			System.out.println("alert message is in-correct!");
		}

		alert.accept(); // click on Ok button

	//	alert.dismiss(); // If cancle button is there - click on Cancle button

		driver.close();




	}

}
