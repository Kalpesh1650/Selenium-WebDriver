package com.guru99.Testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.apache.pdfbox.*;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
/*import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass*/
import org.testng.annotations.Test;
//import org.testng.asserts.*;


import com.guru99.DataRepository.BrowserFactory;
import com.guru99.utility.Constants;
import com.guru99.Wrapup.*;
import com.guru99.ObjectRepository.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class TC_002_verifyPDF_File {
	
	WebDriver ie_driver;
	
	
	/**
	 * To verify PDF content in the pdf document
	 */
	
	public void testVerifyPDFTextInBrowser() {
		
		ie_driver = BrowserFactory.startBrowser("chrome",Constants.URl_PDF);
		ie_driver.manage().window().maximize();
		//driver.get("http://www.princexml.com/samples/");
		WebDriverWait wait = new WebDriverWait(ie_driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='SQL Tutorial']")));
	
		PDF_Page.pdf_links(ie_driver).click();
		//Assert.assertTrue(verifyPDFContent(ie_driver.getCurrentUrl(), "This tutorial will give you quick start with SQL"));
		
		TearDownDrivers.tear_down(ie_driver);
	}

	/**
	 * To verify pdf in the URL 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	@Test
	public void testVerifyPDFInURL() throws InterruptedException, MalformedURLException, IOException {
		
		ie_driver = BrowserFactory.startBrowser("ie","https://www.tutorialspoint.com/sql");
		ie_driver.manage().window().maximize();
		
		//String parent_window_handle = ie_driver.getWindowHandle();
		//driver.get("http://www.princexml.com/samples/");
		WebDriverWait wait = new WebDriverWait(ie_driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='SQL Tutorial']")));
		
		
		PDF_Page.pdf_links(ie_driver).click();
		
		Thread.sleep(5000);
		
		//Alert alt = ie_driver.switchTo().alert();
		
		//alt.accept();
		
		List<String> child_window_Handle = new ArrayList<String> (ie_driver.getWindowHandles()); //{ //Gets the new window handle
	        System.out.println(child_window_Handle.size());
	        ie_driver.switchTo().window(child_window_Handle.get(1));
	        
	        Thread.sleep(2000);
		
		/*String getURL = ie_driver.getCurrentUrl();
		System.out.println(getURL);*/
		
	//	ie_driver = BrowserFactory.startBrowser("chrome",getURL);
		
		
		
		//Thread.sleep(2000);
		String getURL = ie_driver.getCurrentUrl();
		System.out.println(getURL);
		
		if(getURL.contains(".pdf"))
		{
			System.out.println("PDF file opened sucessfully");
		}
		else
		{
			System.out.println("PDF file not opened successfully");
		}
		
		
		verifyPDFContent(getURL,
				"SQL is a database computer language");
		
		ie_driver.close();
		
		ie_driver.switchTo().window(child_window_Handle.get(0));
		
		TearDownDrivers.tear_down(ie_driver);
	}

	
	public void verifyPDFContent(String strURL, String requiredText) throws MalformedURLException, IOException {
		
		PdfReader reader = new PdfReader(new URL(strURL).openStream());
        System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
        String page = PdfTextExtractor.getTextFromPage(reader, 1);
        System.out.println("Page Content:\n\n"+page+"\n\n");
        System.out.println("Is this document tampered: "+reader.isTampered());
        System.out.println("Is this document encrypted: "+reader.isEncrypted());
        
        if(page.contains(requiredText))
        {
        	System.out.println("PDF file has \" "+requiredText+"\" in it");
        }
        else
        {
        	System.out.println("PDF file not contains "+requiredText);
        }
	}
	
	
	
	}

