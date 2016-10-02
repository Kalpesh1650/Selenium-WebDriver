package com.guru99.DataRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	
	String exelFilePath = "D:\\Languages\\EclipseLunaWorkspace\\BankAutomation\\src\\test\\resources\\TestDataSheet.xlsx";
	String user_name;
	String password;
	
	
	File f;
	FileInputStream fis;
	
	XSSFWorkbook book1 ;
	XSSFSheet firstSheet ;
	
//Valid User name	
	public String get_User_Name() throws IOException 
	{
		f = new File(exelFilePath);
		fis = new FileInputStream(f);
		book1 = new XSSFWorkbook(fis);
		firstSheet = book1.getSheetAt(0);
	
	user_name = firstSheet.getRow(1).getCell(0).getStringCellValue();
	book1.close();
	return user_name;
	
	}
	
	//valid password
	public String get_password() throws IOException
	{
	
		f = new File(exelFilePath);
		fis = new FileInputStream(f);
		book1 = new XSSFWorkbook(fis);
		firstSheet = book1.getSheetAt(0);
		password = firstSheet.getRow(1).getCell(1).getStringCellValue();
		book1.close();
		return password;
	}

	//invalid user name
	public String get_Invalid_User_Name() throws IOException 
	{
		f = new File(exelFilePath);
		fis = new FileInputStream(f);
		book1 = new XSSFWorkbook(fis);
		firstSheet = book1.getSheetAt(0);
	
	user_name = firstSheet.getRow(2).getCell(0).getStringCellValue();
	book1.close();
	return user_name;
	
	}
	
	//invalid password
	public String get_Invalid_password() throws IOException
	{
	
		f = new File(exelFilePath);
		fis = new FileInputStream(f);
		book1 = new XSSFWorkbook(fis);
		firstSheet = book1.getSheetAt(0);
		password = firstSheet.getRow(2).getCell(1).getStringCellValue();
		book1.close();
		return password;
	}

		
	}
	


