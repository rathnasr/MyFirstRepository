package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoSelenium {
	public static void excelread() {
		File f1 = new File("C:\\Users\\murug\\eclipse-workspace2\\FirstMavenProject\\src\\test\\resources\\exfileresource\\excelfile.xlsx");
		try {
			FileInputStream fis = new FileInputStream(f1);
			Workbook wk = new XSSFWorkbook(fis);
			Sheet sheet = wk.getSheet("Sheet1");
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for(int i =0;i<physicalNumberOfRows;i++) {
				Row row = sheet.getRow(i);
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				for (int j = 0; j < physicalNumberOfCells; j++) {
					Cell cell = row.getCell(j);
					int cellType = cell.getCellType();
					if(cellType==1) {
						System.out.println(cellType);
					}else if(cellType==0) {
						if(DateUtil.isCellDateFormatted(cell)) {
							Date dateCellValue = cell.getDateCellValue();
							SimpleDateFormat sf = new SimpleDateFormat("dd-mm-yyyy");
							String format = sf.format(dateCellValue);
							System.out.println(format);
						}else {
							double numericCellValue = cell.getNumericCellValue();
							long number=(long)numericCellValue;
							System.out.println(number);
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void excelWriteReuse(String sheetname,int r ,int c,String celldata) {
		File fl = new File("C:\\Users\\murug\\eclipse-workspace2\\FirstMavenProject\\src\\test\\resources\\exfileresource\\excelfile.xlsx");
	    try {
			FileInputStream fis = new FileInputStream(fl);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetname);
			if (sheet == null) {
				sheet = wb.createSheet(sheetname);
			}
			//Sheet sheet = wb.createSheet(sheetname);
//			Row row = sheet.getRow(r);
//			if(row == null) {
//				row = sheet.createRow(r);
//			}
			Row row = sheet.createRow(r);
//			Cell cell = row.getCell(c);
//			if(cell==null) {
//				cell=row.createCell(c);
//			}
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
		excelread();
		excelWriteReuse("Evangelin", 3, 1, "Sindhuja");
		excelWriteReuse("Evangelin", 1, 1, "Apple");
	}
	
	
	
	
	
	// TODO Auto-generated method stub

		
		
		//		try {
//			FileInputStream fis = new FileInputStream(excelFile);
//			Workbook wbook = new XSSFWorkbook(fis);
//			Sheet sheet = wbook.getSheet(null)
//			//wbook.getSheet("Sheet1");
//			//Sheet sheet = wbook.getSheet("Sheet1");	
//			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
//			for(int i=0;i<physicalNumberOfRows;i++) {
//				XSSFRow row = sheet.getRow(physicalNumberOfRows);
//				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
//				for(int j=0;j<physicalNumberOfCells;j++) {
//					XSSFCell cell = row.getCell(physicalNumberOfCells);
//					int cellType = cell.getCellType();
//					if(cellType==1) {
//						System.out.println(cell);
//					}else if (cellType==0){
//						if(DateUtil)
//						
//					}
//				}
//			}
//		} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}


}
