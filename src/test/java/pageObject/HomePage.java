package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClassPageObject;

public class HomePage extends BaseClassPageObject {
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	/*
	@FindBy(xpath = "//span[contains(text(), 'My Account')]")
	private WebElement drpMyAccount;
	
	@FindBy(xpath="//a[contains(text(), 'Register')]")
	private WebElement opRegister;
	
	
	public void navigateToRegisterForm()
	{
		drpMyAccount.click();
		opRegister.click();
	}
	*/
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	private WebElement lnkSignup;
	
	@FindBy(xpath="//li[10]//b")
	private WebElement txtLoggedInUserName;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement linkLogout;
	
	
	public void navigateToRegisterForm()
	{
		lnkSignup.click();
	}
	
	public void navigateToLoginPage()
	{
		lnkSignup.click();
	}
	
	public String getLoggedInUserName()
	{
		return txtLoggedInUserName.getText();
	}
	
	public void logoutUser()
	{
		linkLogout.click();
	}
	
	public boolean isUserLoggedOut()
	{
		return lnkSignup.isDisplayed();
	}
	
	public boolean isUserLoggedIn()
	{
		return txtLoggedInUserName.isDisplayed();
	}

}
