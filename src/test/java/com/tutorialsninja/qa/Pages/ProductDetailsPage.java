package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	public WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Description")
	private WebElement descriptionProductDetails;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-lg btn-block']")
	private WebElement addToCartButton;
	
	public Boolean descriptionProductDetailsIsDisplayed() {
		return descriptionProductDetails.isDisplayed();
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

}
