package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Address;
import com.github.javafaker.PhoneNumber;

import testBase.BaseClassPageObject;

public class SignUpAccountInfoPage extends BaseClassPageObject {
	
	public SignUpAccountInfoPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='id_gender1']")
	private WebElement rdbtnTitleMr;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	private WebElement rdbtnTitleMrs;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement txtName;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement txtPassword;

	@FindBy(xpath="//select[@id='days']")
	private WebElement drpDobDay;
	
	@FindBy(xpath="//select[@id='months']")
	private WebElement drpDobMonth;
	
	@FindBy(xpath="//select[@id='years']")
	private WebElement drpDobYear;
	
	@FindBy(xpath="//input[@id='newsletter']")
	private WebElement chkNewsLetter;
	
	@FindBy(xpath="//input[@id='optin']")
	private WebElement chkoffers;
	
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='address1']")
	private WebElement txtAddress;
	
	@FindBy(xpath="//select[@id='country']")
	private WebElement drpCountry;
	
	@FindBy(xpath="//input[@id='state']")
	private WebElement txtState;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement txtCity;
	
	@FindBy(xpath="//input[@id='zipcode']")
	private WebElement txtZipCode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	private WebElement txtPhoneNumber;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	private WebElement btnCreateAccount;
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']")
	private WebElement msgConfirmMessage;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	private WebElement btnConfirmMessageContinue;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement btnLogout;
	
	
	public void enterAccountInfo(String password, String day, String month, String year, boolean newsletter, boolean offers)
	{
		rdbtnTitleMr.click();
		txtPassword.sendKeys(password);
		Select slDay = new Select(drpDobDay);
		slDay.selectByVisibleText(day);
		Select slmonth = new Select(drpDobMonth);
		slmonth.selectByVisibleText(month);
		Select slYear = new Select(drpDobYear);
		slYear.selectByVisibleText(year);
		if(newsletter==true)
		{
			chkNewsLetter.click();
		}
		if(offers==true)
		{
			chkoffers.click();
		}
		
	}
	
	public void enterAddressInfo(String firstname, String lastname, String address, String country,
			String state, String city, String zipcode, String mobnumber)
	{
		txtFirstName.sendKeys(firstname);
		txtLastName.sendKeys(lastname);
		txtAddress.sendKeys(address);
		Select slCountry = new Select(drpCountry);
		slCountry.selectByVisibleText(country);
		txtState.sendKeys(state);
		txtCity.sendKeys(city);
		txtZipCode.sendKeys(zipcode);
		txtPhoneNumber.sendKeys(mobnumber);
		
		
	}
	
	public void clickCreateAccountButton()
	{
		btnCreateAccount.click();
	}
	
	public String getAccountCreateSuccessMsg()
	{
		return msgConfirmMessage.getText();
	}
	
	public String valididateLogoutButtoVisibility()
	{
		btnConfirmMessageContinue.click();
		return btnLogout.getText();
		
	}


}
