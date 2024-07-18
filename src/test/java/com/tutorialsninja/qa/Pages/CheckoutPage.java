package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "button-payment-address")
	private WebElement paymentContinueAddressButton;
	
	@FindBy (id = "button-shipping-address")
	private WebElement shippingContinueAddressButton;
	
	@FindBy (id = "button-shipping-method")
	private WebElement shippingMethodContinueButton;
	
	@FindBy (id = "button-payment-method")
	private WebElement paymentMethodContiuneButton;
	
	@FindBy (xpath = "//input[@name=\"agree\"]")
	private WebElement termsAndConditionsCheckbox;
	
	@FindBy (id = "button-confirm")
	private WebElement orderConfirmationButton;
	
	public void clickOnPaymentAddressButton() {
		paymentContinueAddressButton.click();
	}
	
	public void clickOnShippingAddressButton() {
		shippingContinueAddressButton.click();
	}
	
	public void clickOnShippingMethodContinueButton() {
		shippingMethodContinueButton.click();
	}
	
	public void clickOnTermsAndConditionsCheckbox() {
		termsAndConditionsCheckbox.click();
	}
	
	public void clicOnPaymentMethodContiuneButton() {
		paymentMethodContiuneButton.click();
	}
	
	public void clickOnOrderConfirmationButton() {
		orderConfirmationButton.click();
	}

}
