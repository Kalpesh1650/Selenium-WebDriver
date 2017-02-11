package com.testng.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
	
	TestSetup mainClass = new TestSetup();
	WebDriver driver;
	
	@Test
	public void JSExecutor() throws Exception
	{
		driver = mainClass.setUp();
		driver.get("E:/Education/Testing/Automation%20Testing/Java%20Script/Java%20Script.html");
		
		JavaScriptExecutor js = (JavaScriptExecutor)driver;
	
		driver.findElement(By.id("")).sendKeys(Keys.PAGE_DOWN);
		
	}

}
