package com.guru99.Reports;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGeneration {

	
		
		public void iTextPDF() throws Exception{
			String FILE = "D:\\Languages\\EclipseLunaWorkspace\\BankAutomation\\src\\test\\resources\\sampleiText.pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			document.add(new Paragraph("Hello iText"));
			document.add(new Paragraph("I will be printed in PDF with the help of iText"));
			document.add(new Paragraph("I will be printed in PDF with the help of iText"));
			document.close();
				
		}
		
		public static void main(String args[]){
			PDFGeneration get = new PDFGeneration();
			try {
				get.iTextPDF();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
