package com.tutorialsninja.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReporter() throws FileNotFoundException {
		ExtentReports extentReport = new ExtentReports();

		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreporterTN.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Test Ninja Test Cases");
		sparkReporter.config().setDocumentTitle("Test Ninja: Suite Test");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");

		extentReport.attachReporter(sparkReporter);

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\ConfigData\\config.properties");
		try {
			prop.load(ip);
			extentReport.setSystemInfo("application url", prop.getProperty("url"));
			extentReport.setSystemInfo("browser name", prop.getProperty("browser"));
			extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
			extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
			extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
			extentReport.setSystemInfo("SDET Name", prop.getProperty("user.name"));
			extentReport.setSystemInfo("Java Version", prop.getProperty("java.version"));
			extentReport.setSystemInfo("SDET CountryName", prop.getProperty("user.country"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return extentReport;

	}
}
