package Jabbrrbox_Web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaticTablehandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		WebElement Onboarding = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select From = new Select(Onboarding);
		From.selectByVisibleText("Paris");

		WebElement Departure = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select To = new Select(Departure);
		To.selectByVisibleText("London");

		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		List<WebElement> Flight_Price = driver.findElements(By.xpath("//tbody//tr"));

		//System.out.println(Flight_Price.size());

		Double prices[] = new Double[Flight_Price.size()];

		for (int i = 1; i <= Flight_Price.size(); i++) {

			WebElement Flight_Price1 = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[6]"));

			String Price = Flight_Price1.getText().replace("$", " ").trim();
			
			//System.out.println(Price);

			prices[i-1] = Double.parseDouble(Price);
		}

		Arrays.sort(prices);
		double MinPrice = prices[0];
		
		//List<WebElement> PriceList = driver.findElements(By.xpath("//tbody//tr//td[6]"));
		
		for(int j = 1; j<=Flight_Price.size();j++ ) {
			WebElement ListPrice = driver.findElement(By.xpath("//tbody//tr["+j+"]//td[6]"));
			
			if(MinPrice==Double.parseDouble(ListPrice.getText().replace("$", "").trim())){
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//tbody//tr["+j+"]//td[1]//input")).click();
				
				System.out.println("Minimum Price flight"+ ListPrice.getText()+ "booked");
			}
		}
		

		//driver.close();

	}

}
