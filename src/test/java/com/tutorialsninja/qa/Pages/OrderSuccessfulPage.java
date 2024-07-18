package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessfulPage {
	
	public WebDriver driver;
	
	public OrderSuccessfulPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//h1[text()= \"Your order has been placed!\"]")
	private WebElement orderHasBeenPlacedMessage;
	
	public Boolean orderHasBeenPlacedMessageIdDisplayed() {
		return orderHasBeenPlacedMessage.isDisplayed();
	}

}
