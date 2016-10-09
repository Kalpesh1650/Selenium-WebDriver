package com.guru99.Testcases;

	import java.io.File;
	import java.io.FileInputStream;

	import org.apache.poi.xssf.usermodel.*;
	

	public class TC004_Multiple_Data_Set_From_Excel 
	{
	    public static XSSFWorkbook WBook = null;
	    public static XSSFSheet WSheet= null;

	    public static XSSFSheet DataSheet(String FilePath, String SheetName)
	    {
	        File file = new File(FilePath);
	        try {
	            FileInputStream fis = new FileInputStream(file);
	            WBook = new XSSFWorkbook(fis);
	            WSheet = WBook.getSheet(SheetName);         
	        } catch (Exception e) {         
	            e.printStackTrace();
	        }
	        return WSheet;      
	}
}

	


	

	
