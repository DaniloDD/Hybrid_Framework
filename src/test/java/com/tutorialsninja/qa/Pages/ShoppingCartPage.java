package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//*[@id='content']/h1")
	private WebElement shoppingCartHeader;
	
	@FindBy (linkText = "HP LP3065")
	private WebElement validProduct;
	
	public Boolean shoppingCartHeaderIsDisplayed() {
		return shoppingCartHeader.isDisplayed();
	}
	
	public Boolean validProductIsDisplayed() {
		return validProduct.isDisplayed();
	}	
}
