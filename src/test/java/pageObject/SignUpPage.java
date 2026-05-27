package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClassPageObject;

public class SignUpPage extends BaseClassPageObject {
	
	public SignUpPage(WebDriver driver)
	{
		super(driver);
	}
	
    /*
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-newsletter']")
	private WebElement rbttonNewsLetter;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement rbuttonPrivacyPolicy;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	private WebElement buttonContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement confirmationMessage;
	
	
	
	
	public void fillRegisterFormData(String firstName, String lastName, String email, String password)
	{
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
	}
	
	
	public void checkNewsLetter()
	{
		rbttonNewsLetter.click();
	}
	
	public void checkPrivacyPolicy()
	{
		rbuttonPrivacyPolicy.click();
	}
	
	public void clickContinueButton()
	{
		buttonContinue.click();
	}
	
	public String validateConfirmationMessage()
	{
		return confirmationMessage.getText();
	}
	*/
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement txtName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	private WebElement btnSignup;
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	private WebElement lblAccountInfo;
	
	public void fillRegisterFormData(String firstName, String email)
	{
		txtName.sendKeys(firstName);
		txtEmail.sendKeys(email);
	}
	
	public void clickSignUpButton()
	{
		btnSignup.click();
	}
	
	public String getAccountInfoPageTitle()
	{
		return lblAccountInfo.getText();
	}
	
}
