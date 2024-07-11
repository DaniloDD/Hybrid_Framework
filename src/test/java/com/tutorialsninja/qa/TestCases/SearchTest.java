package com.tutorialsninja.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
	}
	
	@Test (priority=1)
	public void verifySearchBarIsAvilable() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@class='form-control input-lg']")).isDisplayed() 
				&& driver.findElement(By.xpath("//input[@class='form-control input-lg']")).isEnabled());
	}
	
	@Test (priority = 2)
	public void verifySearchButtonIsFunctional() {
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'Products meeting the search criteria')]")).isDisplayed());
	}
	
	@Test (priority=3)
	public void verifySearchWithValidProduct() {
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys("HP");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test (priority= 4)
	public void verifySearchWithInvalidProduct() {
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys("DELL");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
