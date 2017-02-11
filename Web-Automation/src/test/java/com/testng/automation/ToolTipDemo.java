package com.testng.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ToolTipDemo {
	
	
	private WebDriver driver;
	@Test
	public void verifyToolTipText() throws Exception
	{
		driver = new TestSetup().setUp();
		driver.navigate().to("http://www.seleniumhq.org/");
		
		WebElement link = driver.findElement(By.xpath("//a[@href='/projects/']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(link);
		act.build().perform();
		
		String Tooltiptext = link.getAttribute("title");
		
		if(Tooltiptext.equalsIgnoreCase("Selenium Projects"))
		{
			System.out.println("Test Passed");
		}
	
	}
		@AfterTest
		public void tearDown()
		{
					
			try 
		    {
		        driver.close();
		        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");

		    }
		    catch (Exception anException) 
		    {
		        anException.printStackTrace();
		    }
		}
	}
	


