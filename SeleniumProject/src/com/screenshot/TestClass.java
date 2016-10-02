package com.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Kalpesh");
		System.setProperty("webdriver.ie.driver", "E:\\Education\\Testing\\Automation Testing\\Selenium\\IEDriverServer_x64_2.43.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.navigate().to("http://www.facebook.com");
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("D:\\Languages\\EclipseLunaWorkspace\\SeleniumProject\\Screenshot"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
