package com.guru99.Testcases;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.guru99.DataRepository.BrowserFactory;
import com.guru99.DataRepository.TestData;
import com.guru99.pages.LoginPageObjects;

//import com.guru99.BrowserFactory;
//import com.guru99.TestData;
//import com.guru99.TestData;
//import com.guru99.pages.LoginPageObjects;
import org.openqa.selenium.Alert;

public class TS_001_Verify_Login_Credentials {
	
	WebDriver chrome_driver;
	TestData user_credentials = new TestData();
	
	
	@Test(priority=0)
	public WebDriver checkValidUser() throws InterruptedException, IOException
	{
		
		chrome_driver = BrowserFactory.startBrowser("chrome","http://www.demo.guru99.com/V4/");
			
		LoginPageObjects login_page = PageFactory.initElements(chrome_driver, LoginPageObjects.class);
		
		login_page.login_guru99(user_credentials.get_User_Name(),user_credentials.get_password());
				
			
				
			Thread.sleep(4000);	
			
			System.out.println(chrome_driver.getTitle());
			
			if(chrome_driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
			return chrome_driver;
	}
	
	@Test(priority=1)
	public void check_Invalid_User() throws InterruptedException, IOException
	{
		chrome_driver = BrowserFactory.startBrowser("chrome","http://www.demo.guru99.com/V4/");
		
		LoginPageObjects login_page = PageFactory.initElements(chrome_driver, LoginPageObjects.class);
		
		login_page.login_guru99(user_credentials.get_Invalid_User_Name(),user_credentials.get_Invalid_password());
				
						
			Thread.sleep(4000);	
			
			//if(new TS_001_Verify_Login_Credentials().isAlertPresent())
			{
				Alert alt = chrome_driver.switchTo().alert();
				System.out.println(alt.getText());
				alt.accept();
			}
			
			
	}
	
	/*public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        chrome_driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // 
*/
	@AfterSuite
	public void Tear_down()
	{
		try 
	    {
	        chrome_driver.close();
	        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");

	    }
	    catch (Exception anException) 
	    {
	        anException.printStackTrace();
	    } 
	    
	    /*try {
		    String line;
		    
		    Process p = Runtime.getRuntime().exec
		    	    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
		    BufferedReader input =
		            new BufferedReader(new InputStreamReader(p.getInputStream()));
		    while ((line = input.readLine()) != null) {
		    	if(line.equalsIgnoreCase("chromedriver.exe"))
		    	{
		    		chrome_driver.quit();
		    		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		    	}
		        //System.out.println(line); //<-- Parse data here.
		    }
		    input.close();
		} catch (Exception err) {
		    err.printStackTrace();
		}*/

	}

}


