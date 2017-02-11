package com.testng.automation;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;




public class Robot {
	
	java.awt.Robot robot;
	//Robot robot;
	WebDriver driver;
	@Test
	public void OpenNewTab() throws AWTException, InterruptedException
	{
		robot = new java.awt.Robot();
		System.setProperty("webdriver.chrome.driver","D:\\Languages\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.navigate().to("http://www.google.com");
	
	
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_T);
		Thread.sleep(5000);
		
	}

}
