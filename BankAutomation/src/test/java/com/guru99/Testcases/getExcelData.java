package com.guru99.Testcases;

import org.apache.poi.xssf.usermodel.*;
/*import org.apache.poi.XSSF.usermodel.XSSFRow;
import org.apache.poi.XSSF.usermodel.XSSFSheet;*/
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.guru99.Testcases.TC004_Multiple_Data_Set_From_Excel;

public class getExcelData extends TC004_Multiple_Data_Set_From_Excel {

    public static Object[][] LoginData;
    
    public static XSSFRow Row;
    public static XSSFCell cell;
    public static String FilePath = "D:\\Languages\\EclipseLunaWorkspace\\BankAutomation1\\src\\test\\resources\\resources\\TestDataSheet.xlsx";
    public static String SheetName1 = "Login";
    //public static String SheetName2 = "Shipment";
    public static XSSFSheet Sheet;

    @DataProvider
    public static Object[][] getLoginData() throws Exception{

        Sheet = DataSheet(FilePath, SheetName1);
        int rowCount = Sheet.getLastRowNum();
        System.out.println(rowCount);
        int colCount = Sheet.getRow(0).getLastCellNum();
        System.out.println(colCount);

        LoginData = new Object[rowCount][colCount];

        for (int rCnt=1; rCnt<=rowCount;rCnt++){
            for (int cCnt=0; cCnt<colCount;cCnt++){
                LoginData[rCnt-1][cCnt] = getCellData(SheetName1, rCnt, cCnt);
           //     System.out.println(LoginData[rCnt-1][cCnt]);
            }
        }

        return LoginData;
    }
        /*@DataProvider
        public static Object[][] getShipmentData() throws Exception{

            Sheet = DataSheet(FilePath, SheetName2);
            int rowCount = Sheet.getLastRowNum();
            System.out.println(rowCount);
            int colCount = Sheet.getRow(0).getLastCellNum();
            System.out.println(colCount);

            ShipmentData = new Object[rowCount][colCount];

            for (int rCnt=1; rCnt<=rowCount;rCnt++){
                for (int cCnt=0; cCnt<colCount;cCnt++){
                    ShipmentData[rCnt-1][cCnt] = getCellData(SheetName2, rCnt, cCnt);
                    System.out.println(ShipmentData[rCnt-1][cCnt]);
                }
            }

            return ShipmentData;        
    }*/

    public static String getCellData(String Sheet, int row, int col){

        try {

            int index = WBook.getSheetIndex(Sheet);


            WSheet = WBook.getSheetAt(index);
            Row = WSheet.getRow(row);
            if (Row == null)
            return "";

            cell = Row.getCell(col);
            if (cell == null)
            return "";

            switch (cell.getCellType())
            {
            case  Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();               

            case  Cell.CELL_TYPE_BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());          

            case  Cell.CELL_TYPE_BLANK:
            return "";      

            case  Cell.CELL_TYPE_ERROR:
            return cell.getStringCellValue();           

            case  Cell.CELL_TYPE_NUMERIC:
            return String.valueOf(cell.getNumericCellValue());          

            default:
            return "Cell not found";        

            }
        }
            catch (Exception e) {
            e.printStackTrace();
            return "row " + row + " or column " + col+ " does not exist in xls";
            }

    }

    @Test(dataProvider="getLoginData")
    public void TC01_Verify_Login_Valid_Cred(String User, String Pass){

    System.out.println("Username = " +User + " Password = " +Pass);    
    }

    /*@Test(dataProvider="getShipmentData")
    public void TC02_Verify_Shipment_Data(String TestID,String Weight, String Account,String DeclaredValue,String Execute,String Status){

    System.out.println(TestID+Weight+Account+DeclaredValue+Execute+Status); 
    }*/
}



