package com.tutorialsninja.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.ProductDetailsPage;
import com.tutorialsninja.qa.Pages.ProductPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class SearchTest extends TestBase {
	
	public SearchTest() throws IOException {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public ProductPage productpage;
	public ProductDetailsPage productdetailspage;
	
	@BeforeMethod
	public void setup() {
		driver =  initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		productpage = new ProductPage(driver);
	}
	
	@Test (priority=1)
	public void verifySearchBarIsAvailable() {
		Assert.assertTrue(homepage.searchTextboxIsDisplayedAndEnabled());
	}
	
	@Test (priority = 2)
	public void verifySearchButtonIsFunctional() {
		homepage.clickOnSeachButton();
		Assert.assertTrue(productpage.emptySearchResultMessageIsDisplayed());
	}
	
	@Test (priority=3)
	public void verifySearchWithValidProduct() {
		homepage.enterProductInTheSearchTextbox(dataProp.getProperty("validProduct"));
		homepage.clickOnSeachButton();
		Assert.assertTrue(productpage.validProductIsDisplayed());
	}
	
	@Test (priority= 4)
	public void verifySearchWithInvalidProduct() {
		homepage.enterProductInTheSearchTextbox(dataProp.getProperty("invalidProduct"));
		homepage.clickOnSeachButton();
		Assert.assertTrue(productpage.invalidProductWarningMessageIsDisplayed());
	}
	
	@Test (priority=5)
	public void enterValidProductDetailsPage() {
		homepage.enterProductInTheSearchTextbox(dataProp.getProperty("validProduct"));
		homepage.clickOnSeachButton();
		productpage.clickOnValidProductDetails();
		productdetailspage = new ProductDetailsPage(driver);
		Assert.assertTrue(productdetailspage.descriptionProductDetailsIsDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
