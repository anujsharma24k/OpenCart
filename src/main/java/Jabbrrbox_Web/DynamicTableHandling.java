package Jabbrrbox_Web;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jabbrrbox-adminqa.kiwi-internal.com/");
		driver.manage().window().maximize();

		WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
		Email.clear();
		Email.sendKeys("anujanuj12@yopmail.com");
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.clear();
		Password.sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@id='submitCall']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='User Management']")).click();

		String PaginationText = driver.findElement(By.xpath("//p[@class='pagination-text']")).getText();

		String SplitTexts[] = PaginationText.split(" ");
		int nosOfRecords = (Integer.parseInt(SplitTexts[3]));
		int nosOfPages = 0;
		if (nosOfRecords % 10 > 0) {
			nosOfPages = nosOfRecords / 10;
			nosOfPages = nosOfPages + 1;

			System.out.println(nosOfPages);
		} else {
			nosOfPages = nosOfRecords / 10;
		}

		for (int p = 1; p <= 5; p++) {

			if (p > 1) {

				driver.findElement(By.xpath("//div[@class='pagination']//a[text()=" + p + "]")).click();
				Thread.sleep(3000);
			}

			List<WebElement> nosOfRow = driver.findElements(By.xpath("//table//tbody//tr"));
			int nosOfRowCount = nosOfRow.size();

			for (int i = 1; i <= nosOfRowCount; i++) {
				String User = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//th[1]//strong")).getText();
				String UserEmail = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[2]")).getText();

				System.out.print(User + "   " + UserEmail);
				System.out.println();

			}

		}

		driver.close();
	}

}
