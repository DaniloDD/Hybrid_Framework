package com.tutorialsninja.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.CheckoutPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.LoginPage;
import com.tutorialsninja.qa.Pages.OrderSuccessfulPage;
import com.tutorialsninja.qa.Pages.ProductDetailsPage;
import com.tutorialsninja.qa.Pages.ProductPage;
import com.tutorialsninja.qa.TestBase.TestBase;
import com.tutorialsninja.qa.TestData.ExcelCode;

public class CheckoutTest extends TestBase{
	
	public CheckoutTest() throws IOException {
		super();
	}
	
	public WebDriver driver;
	public HomePage homepage;
	public ProductPage productpage;
	public ProductDetailsPage productdetailspage;
	public LoginPage loginpage;
	public CheckoutPage checkoutpage;
	public OrderSuccessfulPage ordersuccessfulpage;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication("Chrome");
		homepage = new HomePage(driver);
		productpage = new ProductPage(driver);
		productdetailspage = new ProductDetailsPage(driver);
		loginpage = new LoginPage(driver);
		checkoutpage = new CheckoutPage(driver);
		ordersuccessfulpage = new OrderSuccessfulPage(driver);
	}
	
	@Test (priority = 1)
	public void verifyCheckoutButtonIsAvailable() {
		Assert.assertTrue(homepage.checkoutButtonIsDisplayed());
	}
	
	@Test (priority = 2, dataProvider = "CheckoutTN", dataProviderClass = ExcelCode.class)
	public void verifyCheckoutFunctionality(String username, String password) {
		homepage.clickOnMyAccountDropdown();
		homepage.clickOnLoginOption();
		loginpage.enterEmailInEmailTextBox(username);
		loginpage.enterPasswordInPasswordTextBox(password);
		loginpage.clickOnLoginButton();
		
		homepage.enterProductInTheSearchTextbox(dataProp.getProperty("validProduct"));
		homepage.clickOnSeachButton();
		productpage.clickOnAddToCartButton();
		productdetailspage.clickOnAddToCartButton();
		
		homepage.clickOnCheckoutButton();
		checkoutpage.clickOnPaymentAddressButton();
		checkoutpage.clickOnShippingAddressButton();
		checkoutpage.clickOnShippingMethodContinueButton();
		checkoutpage.clickOnTermsAndConditionsCheckbox();
		checkoutpage.clicOnPaymentMethodContiuneButton();
		checkoutpage.clickOnOrderConfirmationButton();
		
		Assert.assertTrue(ordersuccessfulpage.orderHasBeenPlacedMessageIdDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
