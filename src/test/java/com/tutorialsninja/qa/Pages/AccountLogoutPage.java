package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogoutPage {
	
	public WebDriver driver;
	
	public AccountLogoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//h1[text()= 'Account Logout']")
	private WebElement accountLogoutMessage;
	
	public Boolean accountLogoutMessageIsDisplayed() {
		return accountLogoutMessage.isDisplayed();
	}

}
