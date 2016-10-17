package com.guru99.Testcases;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.guru99.DataRepository.BrowserFactory;
import com.guru99.Wrapup.TearDownDrivers;


public class TC_005_iText_PDF_reader {
	
	private WebDriver ie_driver;

	@Test
	public void read_PDF() throws IOException
	{
		
		ie_driver = BrowserFactory.startBrowser("ie","https://www.tutorialspoint.com/sql/pdf/index.pdf");
	ie_driver.manage().window().maximize();
	
		
		
		
		//PdfReader reader = new PdfReader("E:/Education/Testing/Automation Testing/Selenium/Maven tutorials/maven_tutorial.pdf");
		PdfReader reader = new PdfReader(new URL("https://www.tutorialspoint.com/sql/pdf/index.pdf").openStream());
        System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
        String page = PdfTextExtractor.getTextFromPage(reader, 2);
        System.out.println("Page Content:\n\n"+page+"\n\n");
        System.out.println("Is this document tampered: "+reader.isTampered());
        System.out.println("Is this document encrypted: "+reader.isEncrypted());
        
        TearDownDrivers.tear_down(ie_driver);
	}

}
