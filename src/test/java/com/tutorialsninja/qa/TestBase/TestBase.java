package com.tutorialsninja.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.Utilities.Utils;

public class TestBase {

	public Properties prop;
	public Properties dataProp;
	public WebDriver driver;
	public FileInputStream ip1;
	public FileInputStream ip2;

	public TestBase() throws IOException {
		prop = new Properties();
		try {
			ip1 = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\ConfigData\\config.properties");
			prop.load(ip1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			;
		}
		
		dataProp = new Properties();
		try {
		ip2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsninja\\qa\\TestData\\dataProp.properties");
		dataProp.load(ip2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if (browserName.equals("Chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.setPageLoadStrategy(PageLoadStrategy.EAGER);
			op.addArguments("--start-maximized");
			op.addArguments(Arrays.asList("--headless", "--no-sandbox"));
			op.addArguments("--incognito");
			op.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
			driver = new ChromeDriver(op);
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("Safari")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Browser name is not correct.");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGELOAD_TIMEOUT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utils.SCRIPT_TIMEOUT));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
