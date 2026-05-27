package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClassTests {
	
public static WebDriver driver;
public Logger logger;
public Properties property;
	
	@BeforeClass(groups= {"sanity","regression"})
	@Parameters({"browser"})
	public void setUp(String br)
	{
		property = new Properties();
		try {
		FileInputStream File = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		property.load(File);
		}catch(Exception e) {
			e.getMessage();
		}
		logger = LogManager.getLogger(this.getClass());
		
		  switch(br.toLowerCase()) { 
		  case "edge":
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
		  break;
		  
		  case "chrome":
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver(); 
		  break;
		  
		  case "firefox":
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  break;
		  
		  default: throw new RuntimeException("Invalid browser: " + br); }
		 
		//WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://demo.opencart.com/");
		driver.get(property.getProperty("base_URL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"sanity","regression"})
	public void closeDriver()
	{
		driver.quit();
	}
	
	
	public String captureScreenshot(String testName) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot sc =(TakesScreenshot) driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		String targetFileLocation = System.getProperty("user.dir")+"\\Screenshots\\"+testName+"-"+timeStamp+".png";
		File filelocation = new File(targetFileLocation);
		//File filelocation = new File(".//Screenshots");
		FileUtils.copyFile(source, filelocation);
		return targetFileLocation;
		
	}

}