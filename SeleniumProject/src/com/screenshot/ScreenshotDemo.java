package com.screenshot;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class ScreenshotDemo
{
	static WebDriver driver;
	
	@Test
	public static void main(String[] args)
	{
		//System.setProperty("webdriver.ie.driver", "E:\\Education\\Testing\\Automation Testing\\Selenium\\IEDriverServer_x64_2.43.0\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Languages\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.facebook.com");
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("D:\\Languages\\EclipseLunaWorkspace\\SeleniumProject\\Screenshot\\FacebookScreenshot.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated c atch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
