package com.testng.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;



public class AlertDemo {
	
TestSetup use = new TestSetup();
WebDriver driver;
Actions act;

@SuppressWarnings("deprecation")
@Test
public void AlertTest() throws Exception
{
	
	driver = use.setUp();
	

	Selenium sel = new WebDriverBackedSelenium(driver,driver.getCurrentUrl());
	
	//act.moveToElement(toElement)
	driver.findElement(By.linkText("Test Pages")).click();
	
	driver.findElement(By.linkText("JavaScript Alert,Confirm,Prompt Boxes")).click();
	driver.findElement(By.xpath("//button[@id='alert']")).click();
	
	if(sel.isAlertPresent())
	{
	
			Alert alt = driver.switchTo().alert();
			alt.accept();
	}
}


}
