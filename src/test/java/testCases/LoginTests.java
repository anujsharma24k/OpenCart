package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClassTests;
import utilities.DataProviders;

public class LoginTests extends BaseClassTests {

	@Test (priority= 4, groups = {"sanity", "regression"})
	public void validateLogin() {

		HomePage hp = new HomePage(driver);

		try {

			hp.navigateToLoginPage();

			LoginPage signin = new LoginPage(driver);
			signin.enterLoginCreds(property.getProperty("email"), property.getProperty("password"));

			signin.clickLoginButton();

			String actualUserName = hp.getLoggedInUserName();
			String expectedUserName = property.getProperty("firstName");

			Assert.assertEquals(actualUserName, expectedUserName, "Login validation failed");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} 
	}
	/*
	 * @Test(dataProvider = "userlogin", dataProviderClass = DataProviders.class)
	 * public void validateLoginwithDDT(String email, String password, String type)
	 * {
	 * 
	 * HomePage hp = new HomePage(driver);
	 * 
	 * try { hp.navigateToLoginPage(); LoginPage signin = new LoginPage(driver);
	 * signin.enterLoginCreds(email, password); signin.clickLoginButton();
	 * 
	 * if (type.equalsIgnoreCase("valid")) { if (hp.isUserLoggedIn() == true) {
	 * hp.logoutUser();
	 * 
	 * Assert.assertTrue(true, "User Logged in successfully"); } else {
	 * Assert.fail("User failed to login"); } }
	 * 
	 * if (type.equalsIgnoreCase("invalid")) { if (hp.isUserLoggedIn() == false) {
	 * Assert.assertTrue(true, "User not logged in with invalid data"); } else {
	 * hp.logoutUser(); Assert.fail("User logged in with invalid data"); } }
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * Assert.fail("Test failed due to exception: " + e.getMessage());
	 * 
	 * } }
	 */
}
