package Jabbrrbox_Web;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TakeScreenshotAndChromeOptions {

	public static void main(String[] args) {
		
		ChromeOptions options= new ChromeOptions();
		//options.addArguments("--headless");
		//options.setAcceptInsecureCerts(true);
		//options.addArguments("--incognito");
		
        WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		System.out.println("Run in headless mode");
		/*
		 * TakesScreenshot TS =(TakesScreenshot) driver; File sourceFile =
		 * TS.getScreenshotAs(OutputType.FILE); File newLoction = new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\screenshot1.jpg");
		 * sourceFile.renameTo(newLoction);
		 */
		/*
		 * WebElement userTable = driver.findElement(By.xpath("//div[@id='HTML1']"));
		 * File sourceFile = userTable.getScreenshotAs(OutputType.FILE); File
		 * newLocation = new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\Element.jpg");
		 * sourceFile.renameTo(newLocation);
		 */
		
		
		
		driver.quit();
	}

}
