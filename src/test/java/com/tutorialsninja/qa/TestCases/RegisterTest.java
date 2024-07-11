package com.tutorialsninja.qa.TestCases;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
	
	public Date date;
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		date = new Date();
		String currentDate = date.toString();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@Test (priority = 1)
	public void verifyRegisterWithMandatoryValidDetails() {
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Panda");
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda1zsa@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("342342342");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")).isDisplayed());
	}
	
	@Test (priority = 2)
	public void verifyRegisterWithNewsLetterSubscription() {
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Panda");
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda1zsa@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("342342342");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")).isDisplayed());
	}
	
	@Test (priority = 3)
	public void verifyRegisterWithExistingEmail() {
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Panda");
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("342342342");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String expectedMessage = "Warning: E-Mail Address is already registered!";
		String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test (priority = 4)
	public void verifyRegisterWithInvalidConfirmPassword() {
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium");
		driver.findElement(By.id("input-lastname")).sendKeys("Panda");
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda1zsaqa@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("342342342");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Sel");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		String expectedWarningMessage = "Password confirmation does not match password!";
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}
	
	@Test (priority = 5)
	public void verifyRegisterWithNoDetails() {
		
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

		String expectedPrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
		String actualPrivacyPolicyWarningMessage = driver.findElement(By.xpath("//div[contains(text(), 'Warning: You must agree to the Privacy Policy!')]")).getText();
		Assert.assertTrue(expectedPrivacyPolicyWarningMessage.equals(actualPrivacyPolicyWarningMessage));
		
		String expectedFirstNameWarningMessage = "First Name must be between 1 and 32 characters!";
		String actualFirstNameWarningMessage = driver.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertTrue(expectedFirstNameWarningMessage.equals(actualFirstNameWarningMessage));
		
		String expectedLastNameWarningMessage = "Last Name must be between 1 and 32 characters!";
		String actualLastNameWarningMessage = driver.findElement(By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertTrue(expectedLastNameWarningMessage.equals(actualLastNameWarningMessage));
		
		String expectedValidEmailWarningMessage = "E-Mail Address does not appear to be valid!";
		String actualValidEmailWarningMessage = driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")).getText();
		Assert.assertTrue(expectedValidEmailWarningMessage.equals(actualValidEmailWarningMessage));
		
		String expectedTelephoneWarningMessage = "Telephone must be between 3 and 32 characters!";
		String actualTelephoneWarningMessage = driver.findElement(By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")).getText();
		Assert.assertTrue(expectedTelephoneWarningMessage.equals(actualTelephoneWarningMessage));
		
		String expectedPasswordWarningMessage = "Password must be between 4 and 20 characters!";
		String actualPasswordWarningMessage = driver.findElement(By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]")).getText();
		Assert.assertTrue(expectedPasswordWarningMessage.equals(actualPasswordWarningMessage));	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
