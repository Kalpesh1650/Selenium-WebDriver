package com.guru99.Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.guru99.DataRepository.BrowserFactory;
import com.guru99.utility.Constants;
import com.guru99.ObjectRepository.FileUploadPage;
import com.guru99.Wrapup.TearDownDrivers;


public class TC_006_verify_File_Upload_and_Download {
	
	private WebDriver chrome_driver;

	@Test
	public void verify_file_upload_Autoit() throws InterruptedException, IOException
	{
		chrome_driver = BrowserFactory.startBrowser("chrome",Constants.FILE_UPLOAD_URL);
				
		Thread.sleep(3000);
		
		chrome_driver.manage().window().maximize();
		
		FileUploadPage.Select_file_link(chrome_driver).click();
		
		//FileUploadPage.Click_here_link(chrome_driver).click();
		
		/*Set<String> windows_list = chrome_driver.getWindowHandles();
		Iterator<String> itr = windows_list.iterator();
	//	for(int i=0; i<windows_list.size();i++)
		
			if(itr.hasNext())
			{
				chrome_driver.switchTo().window(itr.next());
				if(chrome_driver.getCurrentUrl().contains("survey"))
				{
					chrome_driver.close();
				}
				
			}
		
				
		FileUploadPage.Drag_drop_link(chrome_driver).click();
		*/
		
		Runtime.getRuntime().exec("C:\\Users\\Kalp35h\\.git\\BankAutomation\\src\\test\\resources\\AutoIT Scripts\\FileUploadDialog.exe");
		
		Thread.sleep(3000);
		
		TearDownDrivers.tear_down(chrome_driver);
		
				
		
	}

}
