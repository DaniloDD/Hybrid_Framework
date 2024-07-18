package com.tutorialsninja.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountLogoutPage;
import com.tutorialsninja.qa.Pages.AccountPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.LoginPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class LogoutTest  extends TestBase {
	
	public LogoutTest() throws IOException {
		super();
	}
	
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public AccountLogoutPage accountlogoutpage;
	
	@BeforeMethod
	public void setup() {
		
		driver =  initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		accountpage = new AccountPage(driver);
		accountlogoutpage = new AccountLogoutPage(driver);
		homepage.clickOnMyAccountDropdown();
		homepage.clickOnLoginOption();
		loginpage.enterEmailInEmailTextBox(prop.getProperty("validEmail"));
		loginpage.enterPasswordInPasswordTextBox(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		Assert.assertTrue(accountpage.editAccountInfoLinkIsDisplayed());
	}

	@Test (priority = 1)
	public void verifyLogoutButtonIsAvailable() {
		homepage.clickOnMyAccountDropdown();
		Assert.assertTrue(homepage.logoutButtonIsDisplayed());
	}
	
	@Test (priority=3) 
	public void verifyLogoutFunctionality() {
		homepage.clickOnMyAccountDropdown();
		homepage.clickOnLogoutButton();
		
		Assert.assertTrue(accountlogoutpage.accountLogoutMessageIsDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
