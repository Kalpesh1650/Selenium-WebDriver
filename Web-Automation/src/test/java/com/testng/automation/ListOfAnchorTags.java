package com.testng.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ListOfAnchorTags {

	TestSetup mainClass = new TestSetup();
	WebDriver driver;
	
	
	@Test
	public void TestListOfAnchorTags() throws Exception
	{
		driver = mainClass.setUp();
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		System.out.println(elements.size());
		
		for(WebElement e : elements)
		{
			System.out.println(e.getText());
		}
		
		mainClass.tearDown();
		
				
		
	}

	
	
}
