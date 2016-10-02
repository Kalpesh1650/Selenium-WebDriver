package com.guru99.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDF_Page {
	
	public static WebElement pdf_links(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//a[@title='SQL Tutorial']"));
		return element;
	}

}
