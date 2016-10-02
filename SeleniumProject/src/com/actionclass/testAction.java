package com.actionclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

public class testAction {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File sr = new File("D:\\Languages\\EclipseLunaWorkspace\\SeleniumProject\\Configuration\\config.property");
		
		FileInputStream fis = new FileInputStream(sr);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Languages\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		Properties pr = new Properties();
		
		pr.load(fis);
		
		String URL = pr.getProperty("URL");
		
		System.out.println("URL");
		
		driver.get(pr.getProperty("URL"));
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Rio Olympics 2016");
		
		driver.quit();
		
		
	}

}
