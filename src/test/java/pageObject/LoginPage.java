package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClassPageObject;

public class LoginPage extends BaseClassPageObject {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	
	public void enterLoginCreds(String email, String password)
	{
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
	}
	
	public void  clickLoginButton()
	{
		btnLogin.click();
	}


}
