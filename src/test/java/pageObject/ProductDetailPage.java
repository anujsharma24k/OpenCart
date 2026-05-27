package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClassPageObject;

public class ProductDetailPage extends BaseClassPageObject {
	
	public ProductDetailPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement ViewDetaillink;
	
	@FindBy(xpath = "//h2[normalize-space()='Blue Top']")
	private WebElement ProductTitle;
	
	
	
	public String getProductTitle() throws InterruptedException {
		Thread.sleep(4000);
		ViewDetaillink.click();
		return ProductTitle.getText();
		
	}
	
	
}
