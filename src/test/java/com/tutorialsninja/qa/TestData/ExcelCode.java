package com.tutorialsninja.qa.TestData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelCode {
	
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellType cellType;
	
	public static Object[][] readFromExcelSheet(String sheetName) throws Exception {
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsninja\\qa\\TestData\\ExcelData_TN.xlsx");
		workbook = new XSSFWorkbook(ip);
		sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] dataExcel =new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
			row = sheet.getRow(i+1);
			for (int j = 0; j< cols; j++) {
				cell = row.getCell(j);
				cellType = cell.getCellType();
				
				switch(cellType) {
				case STRING:
					dataExcel[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					dataExcel[i][j] =Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					dataExcel[i][j] = cell.getBooleanCellValue();
					break;
				default:
					break;
				}
			}
		}
		return dataExcel;
	}
	
	@DataProvider(name = "CheckoutTN")
	public Object[][] getCheckoutTNExcel() throws Exception {
		Object[][] data = ExcelCode.readFromExcelSheet("CheckoutTN");
		return data;
	}

}
