package SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicTable {

	public static void main(String[] args) {
		// Handling dynamic table and print the values in console

//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://money.rediff.com/indices/bse/sensex");

		//print all companies name

		String companyNameLocator = "//table[@class='dataTable']//following-sibling::tbody/tr[i]//a";
		String beforeXpath = "//table[@class='dataTable']//following-sibling::tbody/tr[";

	    String afterXpath = "]//a";

	    for(int i=1; i<=30; i++)
	    {
	    	String company = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
	    	System.out.println(company);

	    }

	    for(int i=1; i<=30; i++)
	    {
	    	//String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
               if(companyNameLocator.contains("HCL Technologies Ltd.")) {

	    		driver.findElement(By.xpath("//table[@class='dataTable']//following-sibling::tbody/tr["+i+"]//a")).click();

	           System.out.println("HCL page title: " + driver.getTitle());
	    	}
	    }

	    //scroll to specific element
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0, 2000)");

	    WebElement hclInterest = driver.findElement(By.xpath("(//table[@class='dataTable']/thead/tr/th[2]/following::tbody/tr[3]/td[2])[1]"));
	    System.out.println("HCL interest is: " + hclInterest.getText());

	}

}
