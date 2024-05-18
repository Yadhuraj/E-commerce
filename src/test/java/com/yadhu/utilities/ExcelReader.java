 package com.yadhu.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static FileInputStream ip ;
	public static Workbook wb;
	
	
	public ExcelReader() throws EncryptedDocumentException, IOException {
		// TODO Auto-generated constructor stub
		ip = new FileInputStream("./TestData/ETestData.xlsx");
		wb = WorkbookFactory.create(ip);
		
	}
	
	public String stringCellValue(int row, int col , String sheetname) throws EncryptedDocumentException, IOException {
		Sheet sh = ExcelReader.wb.getSheet(sheetname);
		return sh.getRow(row).getCell(col).getStringCellValue();
		
	}
	public int numericCellValue(int row, int col , String sheetname) throws EncryptedDocumentException, IOException {
		Sheet sh = ExcelReader.wb.getSheet(sheetname);
		return (int)(sh.getRow(row).getCell(col).getNumericCellValue());
		
	}
	
	public int numrows(String sheetname)
	{
//		it includes the 0th row as well
		Sheet sh = ExcelReader.wb.getSheet(sheetname);
		return sh.getLastRowNum();
	}
	public int numcols(String sheetname)
	{
//		it includes the 0th row as well
		Sheet sh = ExcelReader.wb.getSheet(sheetname);
		return sh.getRow(0).getLastCellNum();
	}

	public String cellType(int row, int col,String sheetname) {
		Sheet sh = ExcelReader.wb.getSheet(sheetname);
		switch (sh.getRow(row).getCell(col).getCellType()) {
		case NUMERIC:
			return "NUMERIC";
		case STRING:
			return "STRING";
		default:
			return "";
		} 
	}
}
