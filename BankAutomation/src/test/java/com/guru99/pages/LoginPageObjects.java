package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects {
	
	
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
	
		this.driver = driver;
	}
		
	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@name='btnLogin']")
	WebElement login_button;
	
	public void login_guru99(String uid,String pass)
	{
		username.sendKeys(uid);
		password.sendKeys(pass);
		login_button.click();
		
	}
		
}


