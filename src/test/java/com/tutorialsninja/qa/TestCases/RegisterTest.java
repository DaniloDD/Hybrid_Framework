package com.tutorialsninja.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountCreatedPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.RegisterPage;
import com.tutorialsninja.qa.TestBase.TestBase;
import com.tutorialsninja.qa.Utilities.Utils;

public class RegisterTest extends TestBase{
	
	public RegisterTest() throws IOException {
		super();
	}
	
	public WebDriver driver;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountCreatedPage accountsuccesspage;
	
	
	@BeforeMethod
	public void setup() {
		driver =  initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropdown();
		homepage.clickOnRegisterButton();
		registerpage = new RegisterPage(driver);
		accountsuccesspage = new AccountCreatedPage(driver);
		
	}
	
	@Test (priority = 1)
	public void verifyRegisterWithMandatoryValidDetails() {
		registerpage.enterFirstname(dataProp.getProperty("firstName"));
		registerpage.enterLastname(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Utils.emailWithDateStamp());
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(dataProp.getProperty("validPassword"));
		registerpage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerpage.clickOnPrivacyPolicyCheckbox();
		registerpage.clickOnContinueRegisterButton();

		Assert.assertTrue(accountsuccesspage.congratualationMessageIsDisplayed());
		Assert.assertTrue(accountsuccesspage.yourAccountHasBeenCreatedMainMessageIsDisplayed());
	}
	
	@Test (priority = 2)
	public void verifyRegisterWithNewsLetterSubscription() {
		
		registerpage.enterFirstname(dataProp.getProperty("firstName"));
		registerpage.enterLastname(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Utils.emailWithDateStamp());
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(dataProp.getProperty("validPassword"));
		registerpage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerpage.clickOnPrivacyPolicyCheckbox();
		registerpage.clickOnNewsletterSubscriptionCheckbox();
		registerpage.clickOnContinueRegisterButton();
		
		Assert.assertTrue(accountsuccesspage.congratualationMessageIsDisplayed());
		Assert.assertTrue(accountsuccesspage.yourAccountHasBeenCreatedMainMessageIsDisplayed());
	}
	
	@Test (priority = 3)
	public void verifyRegisterWithExistingEmail() {
		
		registerpage.enterFirstname(dataProp.getProperty("firstName"));
		registerpage.enterLastname(dataProp.getProperty("lastName"));
		registerpage.enterEmail(prop.getProperty("validEmail"));
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(dataProp.getProperty("validPassword"));
		registerpage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerpage.clickOnPrivacyPolicyCheckbox();
		registerpage.clickOnContinueRegisterButton();
		
		String expectedMessage = dataProp.getProperty("emailAlreadyExistWarningMessage");
		String actualMessage = registerpage.emailAlreadyExistWarningMessageGetText();
		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test (priority = 4)
	public void verifyRegisterWithInvalidConfirmPassword() {
			
		registerpage.enterFirstname(dataProp.getProperty("firstName"));
		registerpage.enterLastname(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Utils.emailWithDateStamp());
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(dataProp.getProperty("validPassword"));
		registerpage.enterConfirmPassword(dataProp.getProperty("invalidConfirm"));
		registerpage.clickOnPrivacyPolicyCheckbox();
		registerpage.clickOnContinueRegisterButton();
		
		String actualWarningMessage = registerpage.passwordConfirmDoesNotMatchWarningMessageGetText();
		String expectedWarningMessage = dataProp.getProperty("passwordConfirmDoesNotMatchWarningMessage");
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}
	
	@Test (priority = 5)
	public void verifyRegisterWithNoDetails() {
		
		registerpage.clickOnContinueRegisterButton();

		String expectedPrivacyPolicyWarningMessage = dataProp.getProperty("expectedPrivacyPolicyWarningMessage");
		String actualPrivacyPolicyWarningMessage = registerpage.actualPrivacyPolicyWarningMessageGetText();
		Assert.assertTrue(expectedPrivacyPolicyWarningMessage.equals(actualPrivacyPolicyWarningMessage));
		
		String expectedFirstNameWarningMessage = dataProp.getProperty("expectedFirstNameWarningMessage");
		String actualFirstNameWarningMessage = registerpage.actualFirstNameWarningMessageGetText();
		Assert.assertTrue(expectedFirstNameWarningMessage.equals(actualFirstNameWarningMessage));
		
		String expectedLastNameWarningMessage = dataProp.getProperty("expectedLastNameWarningMessage");
		String actualLastNameWarningMessage = registerpage.actualLastNameWarningMessageGetText();
		Assert.assertTrue(expectedLastNameWarningMessage.equals(actualLastNameWarningMessage));
		
		String expectedValidEmailWarningMessage = dataProp.getProperty("expectedValidEmailWarningMessage");
		String actualValidEmailWarningMessage = registerpage.actualValidEmailWarningMessageGetText();
		Assert.assertTrue(expectedValidEmailWarningMessage.equals(actualValidEmailWarningMessage));
		
		String expectedTelephoneWarningMessage = dataProp.getProperty("expectedTelephoneWarningMessage");
		String actualTelephoneWarningMessage = registerpage.actualTelephoneWarningMessageGetText();
		Assert.assertTrue(expectedTelephoneWarningMessage.equals(actualTelephoneWarningMessage));
		
		String expectedPasswordWarningMessage = dataProp.getProperty("expectedPasswordWarningMessage");
		String actualPasswordWarningMessage = registerpage.actualPasswordWarningMessageGetText();
		Assert.assertTrue(expectedPasswordWarningMessage.equals(actualPasswordWarningMessage));	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
