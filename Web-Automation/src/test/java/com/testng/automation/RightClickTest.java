package com.testng.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class RightClickTest {
	
	TestSetup mainClass = new TestSetup();
	WebDriver driver;
	Actions act;
	
	@Test
	public void TestRightClick() throws Exception
	{
		driver = mainClass.setUp();
		act = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Shop"));
		
		act.moveToElement(element);
		
		act.contextClick(element).build().perform();
		
		
		

		
		
	}

}
