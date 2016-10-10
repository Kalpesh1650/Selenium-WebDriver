package com.guru99.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {
	
	public static WebElement Select_file_link(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//div[@class='dz-message needsclick']"));
		return element;
	}
	
	public static WebElement Click_here_link(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.linkText("Click here"));
		return element;
	}
	
	public static WebElement Drag_drop_link(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//div[@class='internal']"));
		return element;
	}
	
	

}
