package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "input-firstname")
	private WebElement firstnameTextbox;
	
	@FindBy (id = "input-lastname")
	private WebElement lastnameTextbox;
	
	@FindBy (id = "input-email")
	private WebElement emailTextbox;
	
	@FindBy (id = "input-telephone")
	private WebElement telephoneTextbox;
	
	@FindBy (id = "input-password")
	private WebElement passwordTextbox;
	
	@FindBy (id = "input-confirm")
	private WebElement confirmPasswordTextbox;
	
	@FindBy (xpath = "//input[@name='agree']")
	private WebElement policyCheckBox;
	
	@FindBy (css = "input.btn.btn-primary")
	private WebElement continueRegisterButton;
	
	@FindBy (xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement newsletterSubscriptionCheckbox;
	
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAlreadyExistWarningMessage;
	
	@FindBy (xpath = "//div[@class='text-danger']")
	private WebElement passwordConfirmDoesNotMatchWarningMessage;
	
	@FindBy (xpath = "//div[contains(text(), 'Warning: You must agree to the Privacy Policy!')]")
	private WebElement actualPrivacyPolicyWarningMessage;
	
	@FindBy (xpath = "//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")
	private WebElement actualFirstNameWarningMessage;
	
	@FindBy (xpath = "//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")
	private WebElement actualLastNameWarningMessage;
	
	@FindBy (xpath = "//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")
	private WebElement actualValidEmailWarningMessage;
	
	@FindBy (xpath = "//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")
	private WebElement actualTelephoneWarningMessage;
	
	@FindBy (xpath = "//div[contains(text(), 'Password must be between 4 and 20 characters!')]")
	private WebElement actualPasswordWarningMessage;
	
	public void enterFirstname(String firstname) {
		firstnameTextbox.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		lastnameTextbox.sendKeys(lastname);
	}
	public void enterEmail(String email) {
		emailTextbox.sendKeys(email);
	}
	public void enterTelephone(String telephone) {
		telephoneTextbox.sendKeys(telephone);
	}
	public void enterPassword(String password) {
		passwordTextbox.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTextbox.sendKeys(confirmPassword);
	}
	public void clickOnPrivacyPolicyCheckbox() {
		policyCheckBox.click();;
	}
	public void clickOnContinueRegisterButton() {
		continueRegisterButton.click();;
	}
	
	public void clickOnNewsletterSubscriptionCheckbox () {
		newsletterSubscriptionCheckbox.click();
	}
	
	public String emailAlreadyExistWarningMessageGetText() {
		return emailAlreadyExistWarningMessage.getText();
	}
	
	public String passwordConfirmDoesNotMatchWarningMessageGetText() {
		return passwordConfirmDoesNotMatchWarningMessage.getText();
	}
	
	public String actualPasswordWarningMessageGetText() {
		return actualPasswordWarningMessage.getText();
	}
	
	public String actualTelephoneWarningMessageGetText() {
		return actualTelephoneWarningMessage.getText();
	}
	
	public String actualValidEmailWarningMessageGetText() {
		return actualValidEmailWarningMessage.getText();
	}
	
	public String actualLastNameWarningMessageGetText() {
		return actualLastNameWarningMessage.getText();
	}
	
	public String actualFirstNameWarningMessageGetText() {
		return actualFirstNameWarningMessage.getText();
	}
	
	public String actualPrivacyPolicyWarningMessageGetText() {
		return actualPrivacyPolicyWarningMessage.getText();
	}

}
