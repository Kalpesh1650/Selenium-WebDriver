package com.guru99.Testcases;

import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_PDF_Verify {
	
	PDFTextStripper pdfStripper = null;
	PDDocument pdDoc = null;
	COSDocument cosDoc = null;
	String parsedText = null;
	
	@Test
	public void verify_PDF_Content() throws IOException
	{
		
		URL TestURL = new URL("https://www.tutorialspoint.com/sql/pdf/index.pdf");
		RandomAccessRead TestFile = new RandomAccessBufferedFileInputStream(TestURL.openStream());
		//BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
		/*PDFParser parser = new PDFParser(TestFile);
		parser.parse();
		cosDoc = parser.getDocument();
		pdfStripper = new PDFTextStripper();
		pdfStripper.setStartPage(1);
		pdfStripper.setEndPage(1);
		System.out.println(pdfStripper);
		pdDoc = new PDDocument(cosDoc);
		System.out.println(pdDoc);
		parsedText = pdfStripper.getText(pdDoc);*/
		
		
		
		PDFParser TestPDF = new PDFParser(TestFile);
		TestPDF.parse();
		parsedText = new PDFTextStripper().getText(TestPDF.getPDDocument());
		
			
		System.out.println(parsedText);
		
		//PDFParser TestPDF = new PDFParser(TestFile);
		//TestPDF.parse();
		//String TestText = new PDFTextStripper().getText(TestPDF.getPDDocument());
		
		//Assert.assertTrue(TestText.contains("Open the setting.xml, you can see it is"));
	}

}
