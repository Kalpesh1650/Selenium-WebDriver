package com.guru99.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerPage {
	
	
	public static WebElement New_Customer_link(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.linkText("New Customer"));
		return element;
	}
	
	public static WebElement customer_name_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@name='name']"));
		return element;
	}
	
	public static WebElement Gender_radioBtn(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@name='rad1'][@value='m']"));
		return element;
	}
	
	public static WebElement DOB_selector(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='date'][@name='dob']"));
		return element;
	}
	
	public static WebElement address_TxtArea(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//td/textarea[@name='addr']"));
		return element;
	}
	
	public static WebElement city_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='text'][@name='city']"));
		return element;
	}
	
	public static WebElement state_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='text'][@name='state']"));
		return element;
	}
	
	public static WebElement pin_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='text'][@name='pinno']"));
		return element;
	}
	
	public static WebElement Mobile_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='text'][@name='telephoneno']"));
		return element;
	}
	
	public static WebElement Email_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='text'][@name='emailid']"));
		return element;
	}
	
	public static WebElement Password_txtBox(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
		return element;
	}
	
	public static WebElement Submit_Btn(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@type='submit'][@value='Submit']"));
		return element;
	}
	
	public static WebElement registration_Sccessful_msg(WebDriver driver)
	{
		WebElement element = null;
		element = driver.findElement(By.xpath("//td/p[@class='heading3']"));
		return element;
	}
	

}
