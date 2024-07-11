package com.tutorialsninja.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@Test (priority =1) 
	public void verifyTitlePage() {
		String expectedTitle = "Your Store";
		String actualTitle = driver.getTitle();
		Assert.assertTrue(expectedTitle.equals(actualTitle));
	}
	
	@Test (priority =2) 
	public void verifyCurrentURL() {
		String expectedURL = "https://tutorialsninja.com/demo/";
		String actualURL = driver.getCurrentUrl();
		Assert.assertTrue(expectedURL.equals(actualURL));
	}
	
	@Test(priority =3) 
	public void vefifyLogoLink() {
		Assert.assertTrue(driver.findElement(By.linkText("Qafox.com")).isDisplayed());
	}
	
	@Test (priority=4)
	public void verifyFeaturedSectionIsAvailable() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/h3")).isDisplayed());
	}
	
	@Test (priority=5)
	public void FooterIsAvailable() {
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/footer")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
