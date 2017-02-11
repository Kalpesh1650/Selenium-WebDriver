package com.testng.automation;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class POI_Excel  {
	
	TestSetup setup = new TestSetup();
	String exelFilePath = setup.getTestDataSheet();
	@Test
	public void getTestData() throws Exception
	{
	
	FileInputStream fis = new FileInputStream(new File(exelFilePath));
	
	XSSFWorkbook book1 = new XSSFWorkbook(fis);
	XSSFSheet firstSheet = book1.getSheetAt(0);
	
	System.out.println(firstSheet.getRow(1).getCell(0).getStringCellValue());
	
	System.out.println(firstSheet.getRow(1).getCell(1).getStringCellValue());
	
	System.out.println(firstSheet.getRow(2).getCell(0).getStringCellValue());
	
	System.out.println(firstSheet.getRow(2).getCell(1).getStringCellValue());
	
	book1.close();
	}
	
	
	
	

}
