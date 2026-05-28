package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObject.HomePage;
import pageObject.SignUpAccountInfoPage;
import pageObject.SignUpPage;
import testBase.BaseClassTests;


public class TC01_UserRegistration extends BaseClassTests {
	
	Faker fr = new Faker();
	String FirstName;
	
	@Test(description = "successfulSignUp()",priority=1, groups = {"regression", "sanity"})
	public void successfulSignUp()
	{
		logger.info("**** SuccessfullSign Started******");
		
		HomePage hp = new HomePage(driver);
		hp.navigateToRegisterForm();
		/*
		RegisterFormPage rf = new RegisterFormPage(driver);
		rf.fillRegisterFormData("Aditya", "Singh", "aditya@yopmail.com", "Test@123");
		
		rf.checkNewsLetter();
		rf.checkPrivacyPolicy();
		rf.clickContinueButton();
		Assert.assertEquals(rf.validateConfirmationMessage(), "Your Account Has Been Created!");
		*/
		String email = property.getProperty("email");
		SignUpPage signup = new SignUpPage(driver);
		FirstName = fr.name().firstName();
		signup.fillRegisterFormData(FirstName, FirstName+RandomStringUtils.randomAlphanumeric(4)+"@yopmail.com");
		signup.clickSignUpButton();
		Assert.assertEquals(signup.getAccountInfoPageTitle().toLowerCase(), "ENTER ACCOUNT INFORMATION".toLowerCase());
		
		
	}
	
	@Test(priority=2, groups = {"regression"})
	public void addAccountInfoAndAccountCreation()
	{
		try {
		logger.info("**** addAccountInfoAndAccountCreation Started******");
		SignUpAccountInfoPage account = new SignUpAccountInfoPage(driver);
		account.enterAccountInfo(RandomStringUtils.randomAlphabetic(2).toUpperCase()+RandomStringUtils.randomAlphabetic(2).toLowerCase()+"@"+RandomStringUtils.randomNumeric(3), "15", "January", "1990", true, true);
		account.enterAddressInfo(FirstName, fr.name().lastName(), "23rd Street", "Canada", "UP", "Noida", "110101", RandomStringUtils.randomNumeric(10));//firstname, lastname, Address, country, state, city, zipcode, mobnumber
		
		account.clickCreateAccountButton();
		Assert.assertEquals(account.getAccountCreateSuccessMsg().toLowerCase(), "Account Created!".toLowerCase());
		}catch(Exception e)
		{
			logger.error("Text not matched", e);
			Assert.fail();
		}
	}
	
	@Test(priority=3, groups = {"regression"})
	public void navigateToDashboard()
	{
		logger.info("**** navigateToDashboard Started******");
		SignUpAccountInfoPage account = new SignUpAccountInfoPage(driver);
		Assert.assertEquals(account.valididateLogoutButtoVisibility().toLowerCase(), "Logout".toLowerCase());
	}
	
	

	
	

}
