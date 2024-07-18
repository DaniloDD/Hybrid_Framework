package com.tutorialsninja.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.TestBase.TestBase;

public class HomepageTest extends TestBase {
	
	public HomepageTest() throws IOException {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver =  initializeBrowserAndOpenApplication(prop.getProperty("browser"));
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
