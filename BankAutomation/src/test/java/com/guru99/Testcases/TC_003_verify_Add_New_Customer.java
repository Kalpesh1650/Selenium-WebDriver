package com.guru99.Testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//import com.guru99.Testcases.TS_001_Verify_Login_Credentials;
import com.guru99.Wrapup.TearDownDrivers;

import static com.guru99.ObjectRepository.NewCustomerPage.*;

public class TC_003_verify_Add_New_Customer {
	
	
	//TS_001_Verify_Login_Credentials user1 = new TS_001_Verify_Login_Credentials();
	private WebDriver driver;
	private Alert emailID_exists;
	private String registration_Status_msg = null;
	@Test
	public void add_New_Customer() throws InterruptedException, IOException
	{
		
		//Login to the application
		//driver = user1.checkValidUser();
		
		//Fill customer details form
		System.out.println("Login Sucessful");
		
		New_Customer_link(driver).click();
		
		
		WebElement Customer_Name = customer_name_txtBox(driver);
		Customer_Name.sendKeys("Kalpesh");
		
		Gender_radioBtn(driver).click();
		
		DOB_selector(driver).sendKeys("05/16/1991");
		
		address_TxtArea(driver).sendKeys("Dange Chowk");
		
		city_txtBox(driver).sendKeys("Pune");
		
		state_txtBox(driver).sendKeys("Maharashtra");
		
		pin_txtBox(driver).sendKeys("411033");
		
		Mobile_txtBox(driver).sendKeys("1234516789");
		
		Email_txtBox(driver).sendKeys("kalpesh2@gmail.com");
		
		Password_txtBox(driver).sendKeys("asdfghjkl@123");
		
		
		Submit_Btn(driver).click();		
		
		//If email id is already present then alert will generate
		emailID_exists = driver.switchTo().alert();
			//System.out.println(emailID_exists.getText());
		if(emailID_exists.getText().equalsIgnoreCase("Email Address Already Exist !!"))
		{
			emailID_exists.accept();
			registration_Status_msg = "Registration Unsuccessful : Email Id Already Exists";
			System.out.println(registration_Status_msg);
		}
		else
		{
			registration_Status_msg = registration_Sccessful_msg(driver).getText();
			if(registration_Status_msg.equalsIgnoreCase("Customer Registered Successfully!!!"))
			System.out.println(registration_Status_msg);
     	 }
		
		
						
		TearDownDrivers.tear_down(driver);
		
		
	}

}
