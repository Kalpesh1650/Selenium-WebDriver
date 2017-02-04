package com.guru99.Testcases;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import com.guru99.DataRepository.BrowserFactory;
import com.guru99.utility.Constants;
public class TC_007_verify_File_Download {

	private WebDriver chrome_driver;

	@Test
	public void verify_Download() throws Exception {
	
	chrome_driver = BrowserFactory.startBrowser("chrome",Constants.FILE_DOWNLOAD_URL);
	
	//Thread.sleep(3000);
	
	chrome_driver.manage().window().maximize();

	WebElement downloadButton = chrome_driver.findElement(By.id("download-btn"));
	String sourceLocation = downloadButton.getAttribute("href");
	String wget_command = "cmd /D wget -P D: " + sourceLocation;

	try {

		Process exec = Runtime.getRuntime().exec(wget_command);

		int exitVal = exec.waitFor();

		System.out.println("Exit value: " + exitVal);

		} catch (Exception ex) {

			System.out.println(ex.toString());

}

		chrome_driver.quit();

		}

		}
