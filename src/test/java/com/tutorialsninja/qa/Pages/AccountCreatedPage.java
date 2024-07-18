package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
	
	public WebDriver driver;
	
	public AccountCreatedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@id='content']/h1")
	private WebElement yourAccountHasBeenCreatedMainMessage;
	
	@FindBy (xpath = "//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")
	private WebElement congratualationMessage;
	
	public Boolean yourAccountHasBeenCreatedMainMessageIsDisplayed() {
		return yourAccountHasBeenCreatedMainMessage.isDisplayed();
	}
	
	public Boolean congratualationMessageIsDisplayed() {
		return congratualationMessage.isDisplayed();
	}

}
