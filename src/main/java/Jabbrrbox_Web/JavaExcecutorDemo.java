package Jabbrrbox_Web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaExcecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement  nameField = driver.findElement(By.xpath("//input[@id='name']"));
		
		WebElement  maleRadio = driver.findElement(By.xpath("//input[@id='male']"));
		
		JavascriptExecutor JE =(JavascriptExecutor) driver;
		
		 /* JE.executeScript("arguments[0].setAttribute('value','Aman')", nameField);
		  
		  JE.executeScript("arguments[0].click()", maleRadio);
		  */
		 
		
		//JE.executeScript("window.scrollBy(0,500)"); // Scroll to particular pixel
		JE.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // Scroll to end of the page
		Thread.sleep(3000);
		JE.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		//JE.executeScript("arguments[0].scrollIntoView()", maleRadio); // Scroll to particular Element
		//JE.executeScript("document.body.style.zoom='50%'"); // Zoom out
		//Thread.sleep(3000);
		//JE.executeScript("document.body.style.zoom='100%'"); // Zoom in
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
