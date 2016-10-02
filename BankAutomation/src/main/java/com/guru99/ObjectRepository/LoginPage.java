package com.guru99.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static WebElement username_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@name='uid']"));
		return element;
	}

	public static WebElement password_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@name='password']"));
		return element;
	}
	
	public static WebElement LOGIN_button(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		return element;
	}
	
	public static WebElement RESET_button(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@name='btnReset']"));
		return element;
	}
}
