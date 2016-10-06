package com.guru99.Testcases;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.apache.pdfbox.*;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDrive*/
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
/*import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass*/
import org.testng.annotations.Test;
//import org.testng.asserts.*;

import com.guru99.DataRepository.BrowserFactory;
import com.guru99.utility.Constants;
import com.guru99.Wrapup.*;
import com.guru99.ObjectRepository.*;

public class TC_002_verifyPDF_File {
	
	WebDriver ie_driver;
	
	
	/**
	 * To verify PDF content in the pdf document
	 */
	@Test
	public void testVerifyPDFTextInBrowser() {
		
		ie_driver = BrowserFactory.startBrowser("chrome",Constants.URl_PDF);
		ie_driver.manage().window().maximize();
		//driver.get("http://www.princexml.com/samples/");
		WebDriverWait wait = new WebDriverWait(ie_driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='SQL Tutorial']")));
	
		PDF_Page.pdf_links(ie_driver).click();
		Assert.assertTrue(verifyPDFContent(ie_driver.getCurrentUrl(), "This tutorial will give you quick start with SQL"));
		
		TearDownDrivers.tear_down(ie_driver);
	}

	/**
	 * To verify pdf in the URL 
	 * @throws InterruptedException 
	 */
	@Test
	public void testVerifyPDFInURL() throws InterruptedException {
		
		ie_driver = BrowserFactory.startBrowser("ie",Constants.URl_PDF);
		ie_driver.manage().window().maximize();
		
		//String parent_window_handle = ie_driver.getWindowHandle();
		//driver.get("http://www.princexml.com/samples/");
		WebDriverWait wait = new WebDriverWait(ie_driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='SQL Tutorial']")));
		
		
		PDF_Page.pdf_links(ie_driver).click();
		
		Thread.sleep(5000);
		
		//Alert alt = ie_driver.switchTo().alert();
		
		//alt.accept();
		
		List<String> child_window_Handle = new ArrayList<String> (ie_driver.getWindowHandles()); //{ //Gets the new window handle
	        System.out.println(child_window_Handle.size());
	        ie_driver.switchTo().window(child_window_Handle.get(1));
	        
	        Thread.sleep(2000);
		
		String getURL = ie_driver.getCurrentUrl();
		System.out.println(getURL);
		
	//	ie_driver = BrowserFactory.startBrowser("chrome",getURL);
		
		getURL = ie_driver.getCurrentUrl();
		System.out.println(getURL);
		//String parent_window = ie_driver.getWindowHandle();
		
		//for(String pdf_window : new_windows)
			//	ie_driver.switchTo().window(new_windows);
		//WebDriverWait wait1 = new WebDriverWait(ie_driver, 5);
		//wait1.until(ExpectedConditions.titleContains(".pdf"));
		//System.out.println(ie_driver.getCurrentUrl());
		Assert.assertTrue(getURL.contains(".pdf"));
		
		TearDownDrivers.tear_down(ie_driver);
	}

	
	public boolean verifyPDFContent(String strURL, String reqTextInPDF) {
		
		boolean flag = false;
		
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;

		try {
			URL url = new URL(strURL);
			RandomAccessRead file = (RandomAccessRead) new BufferedInputStream(url.openStream());
			PDFParser parser = new PDFParser(file);
			
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(1);
			
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (MalformedURLException e2) {
			System.err.println("URL string could not be parsed "+e2.getMessage());
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
		
		System.out.println("+++++++++++++++++");
		System.out.println(parsedText);
		System.out.println("+++++++++++++++++");

		if(parsedText.contains(reqTextInPDF)) {
			flag=true;
		}
		
		return flag;
	}
	
	
	
	}

