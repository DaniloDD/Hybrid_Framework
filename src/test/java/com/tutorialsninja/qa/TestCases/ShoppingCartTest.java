package com.tutorialsninja.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@Test (priority=1)
	public void verifyShoppingCartButtonIsAvilable() {
		Assert.assertTrue(driver.findElement(By.xpath("//span[text() = 'Shopping Cart']")).isDisplayed());
	}
	
	@Test (priority=2)
	public void verifyShoppingCartButtonIsFunctional() {
		driver.findElement(By.xpath("//span[text() = 'Shopping Cart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/h1")).isDisplayed());
	}
	
	@Test (priority= 3)
	public void verifyAddToCartButtonFunctionalOfAnAvailableAndValidProduct() {
		driver.findElement(By.name("search")).sendKeys("iPhone");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		driver.findElement(By.xpath("//span[text() = 'Add to Cart']")).click();
		
		String expectedSuccessfulAddedToCartMessage = "Success: You have added iPhone to your shopping cart!";
		String actualSuccessfulAddedToCartMessage = driver.findElement(By.xpath("//*[@id='product-search']/div")).getText();
		System.out.println("---------------------------");
		System.out.println("The message is " + actualSuccessfulAddedToCartMessage);
		System.out.println("---------------------------");
		Assert.assertTrue(expectedSuccessfulAddedToCartMessage.equals(actualSuccessfulAddedToCartMessage));
	}

}
