package com.tutorialsninja.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}

	@Test(priority = 1)
	public void vefiryLoginWithValidCredentials() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpandaa@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Seleniumm@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 3)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("sele");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 4)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpandaaa@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 5)
	public void verifyLoginWithEmptyPassword() {
		driver.findElement(By.id("input-email")).sendKeys("seleniumpandaaa@gmail.com");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 6)
	public void verifyLoginWithEmptyEmail() {
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@Test(priority = 7)
	public void verifyLoginWithNoCredentials() {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(expectedWarningMessage.equals(actualWarningMessage));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
