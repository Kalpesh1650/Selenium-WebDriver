package com.testng.automation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FramesHandling {
	
	private WebDriver driver;
	TestSetup use = new TestSetup();
	@Test
	public void Frames_Handling() throws Exception
	{
		driver = use.setUp();
		
		driver.get("http://www.guru99.com/handling-iframes-selenium.html");
		
		driver.manage().window().maximize();
		
		//JavaScriptExecutor js = (JavaScriptExecutor)driver;
		List<WebElement> list_of_iframes = driver.findElements(By.tagName("iframe"));
		
		System.out.println(list_of_iframes.size());
		
		for(int i=0;i<list_of_iframes.size();i++)
		{
		
		
		
		
			driver.switchTo().frame(i);
			
			System.out.println("Frame "+i+"'s title - " + driver.getTitle());
			
		
					
			//Thread.sleep(5000);
		
		
		}
		driver.switchTo().defaultContent();
		
		System.out.println("Main winidows Title - "+driver.getTitle());
		
		/*for(WebElement element : list_of_iframes)
		{
			System.out.println(element.getText());
		}
		
*/	}
	
	@AfterTest
	public void TearDown() throws IOException
	{
		if(driver!=null)
		{
			driver.close();
			
		}
		if(driver instanceof ChromeDriver)
	        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
	}

}
