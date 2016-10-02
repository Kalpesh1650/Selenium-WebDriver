package com.guru99.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.guru99.DataRepository.BrowserFactory;
import com.guru99.DataRepository.TestData;
import com.guru99.ObjectRepository.LoginPage;
import com.guru99.Wrapup.TearDownDrivers;
import com.guru99.utility.*;


public class TC_001_Verify_Login_Credentials {
	
	WebDriver chrome_driver=null;
	WebDriver ie_driver=null;
	TestData user_credentials = new TestData();
	
	@Test(priority=0)
	public void check_valid_login() throws IOException
	{
		
		chrome_driver = BrowserFactory.startBrowser("chrome",Constants.URL);
		
		//userId text box
		LoginPage.username_txtBox(chrome_driver).sendKeys(user_credentials.get_User_Name());
		
		//Password box
		LoginPage.password_txtBox(chrome_driver).sendKeys(user_credentials.get_password());
		
		//Login Button
		LoginPage.LOGIN_button(chrome_driver).click();
		
		//Verify Successful login
		if(chrome_driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		TearDownDrivers.tear_down(chrome_driver);
			
	}
	
	@Test(priority=1)
	public void WindowsHandleTest()
	{
		System.out.println(chrome_driver.getWindowHandle());
	}
	
	@Test(priority=2)
	public void OpenNewTab() throws InterruptedException, AWTException
	{
		ie_driver = BrowserFactory.startBrowser("ie",Constants.URL);
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_T);
		Thread.sleep(5000);
	}
	
	//teardown code
	
}
