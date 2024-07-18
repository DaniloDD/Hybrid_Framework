package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;										// initialize the object - constructor 
		PageFactory.initElements(driver, this);						// (in our case we have PageFactory that takes care of the intialization of all the objects at once)
	}
	
	
	@FindBy(linkText = "My Account")								// identify the objects - My Account, Login, Searchbutton, ... 
	private WebElement myAccountDropdown;							// (we identify them using @FindBy(...))
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerButton;
	
	@FindBy(name = "search")
	private WebElement searchTextbox;
	
	@FindBy (css= "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	@FindBy (xpath = "//span[text() = 'Shopping Cart']")
	private WebElement shoppingCartButton;
	
	@FindBy (id = "cart-total")
	private WebElement itemsButton;
	
	@FindBy (linkText= "View Cart")
	private WebElement viewCartButton;
	
	@FindBy (linkText = "Checkout")
	private WebElement checkoutButton;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutButton;
	
	
	public void clickOnMyAccountDropdown() {						// action items defined for the objects - 
		myAccountDropdown.click();
	}
	
	public void clickOnLoginOption() {
		loginOption.click();
	}
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}
	
	public Boolean searchTextboxIsDisplayedAndEnabled() {
		return (searchTextbox.isDisplayed() && searchTextbox.isEnabled());
	}
	
	public void clickOnSeachButton() {
		searchButton.click();
	}
	
	public void enterProductInTheSearchTextbox(String product) {
		searchTextbox.sendKeys(product);
	}
	
	public Boolean shoppingCartButtonIsDisplayed() {
		return shoppingCartButton.isDisplayed();
	}
	
	public void clickOnShoppingCartButton() {
		shoppingCartButton.click();
	}
	
	public void clickOnItemsButton() {
		itemsButton.click();
	}
	
	public void clickOnViewCartButton() {
		viewCartButton.click();
	}
	
	public Boolean checkoutButtonIsDisplayed() {
		return checkoutButton.isDisplayed();
	}
	
	public void clickOnCheckoutButton() {
		checkoutButton.click();
	}
	
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	
	public Boolean logoutButtonIsDisplayed() {
		return logoutButton.isDisplayed();
	}

}
