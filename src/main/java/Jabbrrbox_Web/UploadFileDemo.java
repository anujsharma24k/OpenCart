package Jabbrrbox_Web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class UploadFileDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		/*
		 * WebElement singleUpload =
		 * driver.findElement(By.xpath("//input[@id='singleFileInput']"));
		 * 
		 * WebElement multiUpload =
		 * driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		 * 
		 * String file1 = "D:\\Jabbrrbox_Automation\\Jabbrrbox_Web\\chicken.jpeg";
		 * String file2 = "C:\\Users\\Anuj\\Downloads\\download.jpg";
		 * 
		 * singleUpload.sendKeys(file1);
		 * 
		 * multiUpload.sendKeys(file1+"\n"+file2);
		 */
		
		ChromeOptions op = new ChromeOptions();
		String bname = op.getBrowserName();
		System.out.println(bname);
		op.setAcceptInsecureCerts(true);
		
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
