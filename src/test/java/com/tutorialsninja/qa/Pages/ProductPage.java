package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy (xpath = "//h2[contains(text(), 'Products meeting the search criteria')]")
	private WebElement emptySearchResultMessage;
	
	@FindBy (xpath = "//p[text() = 'There is no product that matches the search criteria.']")
	private WebElement invalidProductWarningMessage;

	@FindBy (xpath = "//button[@onclick=\"cart.add('47', '1');\"]")
	private WebElement addToCartButton;
	
	public Boolean validProductIsDisplayed() {
		return validProduct.isDisplayed();
	}
	
	public void clickOnValidProductDetails() {
		validProduct.click();
	}
	
	public Boolean emptySearchResultMessageIsDisplayed() {
		return emptySearchResultMessage.isDisplayed();
	}
	
	public Boolean invalidProductWarningMessageIsDisplayed() {
		return invalidProductWarningMessage.isDisplayed();
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	

}
