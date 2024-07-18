package com.tutorialsninja.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.LoginPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class LoginTest extends TestBase{

	public LoginTest() throws IOException {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accoutpage;

	@BeforeMethod
	public void setup() {
		driver =  initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropdown();
		homepage.clickOnLoginOption();
		loginpage = new LoginPage(driver);
		accoutpage = new AccountPage(driver);
	}

	@Test(priority = 1)
	public void vefiryLoginWithValidCredentials() {
		loginpage.enterEmailInEmailTextBox(prop.getProperty("validEmail"));
		loginpage.enterPasswordInPasswordTextBox(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		Assert.assertTrue(accoutpage.editAccountInfoLinkIsDisplayed());
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginpage.enterEmailInEmailTextBox(dataProp.getProperty("invalidEmail"));
		loginpage.enterPasswordInPasswordTextBox(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String expectedWarningMessage = dataProp.getProperty("invalidEmailPasswordMismatchWarningMessage");
		String actualWarningMessage = loginpage.retrieveWarningEmailPasswordMismatch();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 3)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		loginpage.enterEmailInEmailTextBox(prop.getProperty("validEmail"));
		loginpage.enterPasswordInPasswordTextBox(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String expectedWarningMessage = dataProp.getProperty("invalidEmailPasswordMismatchWarningMessage");
		String actualWarningMessage = loginpage.retrieveWarningEmailPasswordMismatch();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 4)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginpage.enterEmailInEmailTextBox(dataProp.getProperty("invalidEmail"));
		loginpage.enterPasswordInPasswordTextBox(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		String expectedWarningMessage = dataProp.getProperty("invalidEmailPasswordMismatchWarningMessage");
		String actualWarningMessage = loginpage.retrieveWarningEmailPasswordMismatch();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 5)
	public void verifyLoginWithEmptyPasswordAndValidEmail() {
		loginpage.enterEmailInEmailTextBox(prop.getProperty("validEmail"));
		loginpage.clickOnLoginButton();
		String expectedWarningMessage = dataProp.getProperty("invalidEmailPasswordMismatchWarningMessage");
		String actualWarningMessage = loginpage.retrieveWarningEmailPasswordMismatch();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 6)
	public void verifyLoginWithEmptyEmailAndValidPassword() {
		loginpage.enterPasswordInPasswordTextBox(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		String expectedWarningMessage = dataProp.getProperty("invalidEmailPasswordMismatchWarningMessage");
		String actualWarningMessage = loginpage.retrieveWarningEmailPasswordMismatch();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 7)
	public void verifyLoginWithNoCredentials() {
		loginpage.clickOnLoginButton();
		String expectedWarningMessage = dataProp.getProperty("invalidEmailPasswordMismatchWarningMessage");
		String actualWarningMessage = loginpage.retrieveWarningEmailPasswordMismatch();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
