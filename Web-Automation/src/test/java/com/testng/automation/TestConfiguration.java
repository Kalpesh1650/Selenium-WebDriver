package com.testng.automation;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Properties;

/*import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;*/

public class TestConfiguration {
	
	Properties pr = new Properties();
	public void readPropertyFile() throws Exception
	{
		
		File sr = new File("D:\\Languages\\EclipseLunaWorkspace\\Web-Automation\\src\\test\\resources\\config.property");
		
		FileInputStream fis = new FileInputStream(sr);
		
		pr.load(fis);
	}
	public String getURL() throws Exception
	{
		readPropertyFile();
		return pr.getProperty("URL");
	}
	
	public String getIEDriverEXEPath() throws Exception
	{
		readPropertyFile();
		return pr.getProperty("IEDriverServer");
	}
	
	
	
	
}
