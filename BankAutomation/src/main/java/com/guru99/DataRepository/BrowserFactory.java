package com.guru99.DataRepository;

import org.openqa.selenium.WebDriver;

import com.guru99.utility.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName,String url)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver",Constants.Chrome_Driver_Exe_Path);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.navigate().to(url);
		}
		
		if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",Constants.IE_Driver_Exe_Path);
			driver = new InternetExplorerDriver();
			driver.navigate().to(url);
		}
		
		
		return driver;
	}
	

}
