package com.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	public static String readCellData(String sht,int r,int c) {
		File fl = new File("C:\\Users\\murug\\eclipse-workspace2\\FirstMavenProject\\src\\test\\resources\\exfileresource\\dataproviderExcel.xlsx");
		String celldata ="";
		try {
			FileInputStream fis = new FileInputStream(fl);
			Workbook wk = new XSSFWorkbook(fis);
			Sheet sheet = wk.getSheet(sht);
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);
			if(cell.getCellType()==0) {
				double numericCellValue = cell.getNumericCellValue();
				Long number = (long)numericCellValue;
				celldata = Long.toString(number);
			}else {
				celldata = cell.toString();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return celldata;
	}

	public static void writeCellData(String sheetname,int r ,int c,String celldata) {
		File fl = new File("C:\\Users\\murug\\eclipse-workspace2\\AdactinhotelBookingPgm\\src\\test\\resources\\AdactinHotelLoginDetails.xlsx");
	    try {
			FileInputStream fis = new FileInputStream(fl);
			Workbook wb = new XSSFWorkbook(fis);
			//Sheet sheet = wb.createSheet(sheetname);
			Sheet sheet = wb.getSheet(sheetname);
			if (sheet == null) {
				sheet = wb.createSheet(sheetname);
			}
			Row row = sheet.createRow(r);
			Cell cell = row.createCell(c);
			cell.setCellValue(celldata);
			FileOutputStream fos = new FileOutputStream(fl);
			wb.write(fos);
			wb.close();
			System.out.println("SuccessFully Executed");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
