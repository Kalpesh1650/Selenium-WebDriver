package com.guru99.Reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
	
	
	@Test
	public void verifyBlogTitle()
	{
		
		reports = new ExtentReports("C:\\Users\\Kalp35h\\.git\\BankAutomation\\Reports\\TestReport.html");
		logger = reports.startTest("Test1-verifyBlogTitle");
		
		driver = new FirefoxDriver();
		
		logger.log(LogStatus.INFO, "Browser Started");
		driver.get("https://www.google.com");
		
		logger.log(LogStatus.INFO, "Application is up and running");
		String title = driver.getTitle();
		
		Assert.assertTrue(title.equalsIgnoreCase("Google"));
		
		logger.log(LogStatus.PASS,"Title Verified");
	}
	
	@AfterTest
	public void tearDown()
	{
		
		//driver.quit();
		reports.endTest(logger);
		reports.flush();
		
		driver.get("C:\\Users\\Kalp35h\\.git\\BankAutomation\\Reports\\TestReport.html");
		
		
			
	}

}
