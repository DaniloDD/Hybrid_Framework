package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "input-email")
	private WebElement emailTextbox;
	
	@FindBy (id = "input-password")
	private WebElement passwordTextbox;
	
	@FindBy (css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy (xpath = "//*[@id='account-login']/div[1]")
	private WebElement invalidEmailPasswordWarning;
	
	public void enterEmailInEmailTextBox(String emailText) {
		emailTextbox.sendKeys(emailText);
	}
	
	public void enterPasswordInPasswordTextBox(String passwordText) {
		passwordTextbox.sendKeys(passwordText);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public String retrieveWarningEmailPasswordMismatch() {
		return invalidEmailPasswordWarning.getText();
	}

}
