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
import com.tutorialsninja.qa.Pages.ShoppingCartPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class ShoppingCartTest extends TestBase {

	public ShoppingCartTest() throws IOException {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public ProductPage productpage;
	public ProductDetailsPage productdetailspage;
	public ShoppingCartPage shoppingcartpage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		shoppingcartpage = new ShoppingCartPage(driver);
		productpage = new ProductPage(driver);
		productdetailspage = new ProductDetailsPage(driver);
	}

	@Test(priority = 1)
	public void verifyShoppingCartButtonIsAvilable() {
		Assert.assertTrue(homepage.shoppingCartButtonIsDisplayed());
	}

	@Test(priority = 2)
	public void verifyEmptyShoppingCartSearch() {
		homepage.clickOnShoppingCartButton();
		Assert.assertTrue(shoppingcartpage.shoppingCartHeaderIsDisplayed());
	}

	@Test(priority = 3)
	public void verifyAddToCartFunctionalityFromItemButton() {
		homepage.enterProductInTheSearchTextbox(dataProp.getProperty("validProduct"));
		homepage.clickOnSeachButton();
		productpage.clickOnAddToCartButton();
		productdetailspage.clickOnAddToCartButton();
		homepage.clickOnItemsButton();
		Assert.assertTrue(productpage.validProductIsDisplayed());
	}
	
	@Test(priority = 3)
	public void verifyAddToCartFunctionalityFromShoppingCartPage() {
		homepage.enterProductInTheSearchTextbox(dataProp.getProperty("validProduct"));
		homepage.clickOnSeachButton();
		productpage.clickOnAddToCartButton();
		productdetailspage.clickOnAddToCartButton();
		homepage.clickOnItemsButton();
		homepage.clickOnViewCartButton();
		Assert.assertTrue(shoppingcartpage.validProductIsDisplayed());
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
