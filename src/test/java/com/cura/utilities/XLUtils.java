package com.cura.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream file;
	public static FileOutputStream file1;
	public static XSSFWorkbook workbook ;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static void setExcelFile(String xfile, String xlsheet) throws IOException {
		file = new FileInputStream(xfile);
		 workbook = new XSSFWorkbook(file);
		 sheet = workbook.getSheet(xlsheet);
	}
	
	
	public static int getRowCount() {
		int rownum = sheet.getLastRowNum();
		
		return rownum;
		
	}
	
	public static int getCellCount() {
		int colnum = sheet.getRow(0).getLastCellNum();
		return colnum;
	}
	
	public static String getCellData(int i, int j) {
		cell = sheet.getRow(i).getCell(j);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		return data;
	}
	
	public static void setCellData(String path1,String sheetname, int k, int l, String text) throws IOException {
		
		
		file =new FileInputStream(path1);
		workbook =new XSSFWorkbook(file);
		sheet =workbook.getSheet(sheetname);
		row=sheet.getRow(k);
		cell=row.createCell(l);
		cell.setCellValue(text);
		file1 =new FileOutputStream(path1);
		workbook.write(file1);		
		workbook.close();
		file.close();
		file1.close();
	}


}
