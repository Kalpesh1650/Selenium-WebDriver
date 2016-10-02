package com.guru99.Wrapup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TearDownDrivers {
	
	public static void tear_down(WebDriver driver)
	{
		try 
	    {
			if(driver != null)
	        driver.close();
			
			if(driver instanceof ChromeDriver)
	        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			
			if(driver instanceof InternetExplorerDriver)
		        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
	        

	    }
	    catch (Exception anException) 
	    {
	        anException.printStackTrace();
	    } 
	
	}
	
}
