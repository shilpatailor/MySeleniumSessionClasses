package SeleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFileUploadPopup {

	public static void main(String[] args) {
		// Handle file upload popup or upload file using your local computer folder

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://html.com/input-type-file/");

		// handle upload file popup / window popup
		driver.findElement(By.xpath("//input[@name='fileupload']"))
		.sendKeys("/usr/local/google/home/shilpatailor/Downloads/Invoice.pdf");



	}

}
