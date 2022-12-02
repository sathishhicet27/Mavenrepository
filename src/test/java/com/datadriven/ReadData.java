package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void readexcel() throws IOException {

		File f = new File(".\\Excel\\Maven Trial.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(1);
		Cell cell = row.getCell(0);
		CellType cellType = cell.getCellType();
		int lr = sheetAt.getLastRowNum();
		System.out.println(lr);
		int lc = sheetAt.getRow(0).getLastCellNum();
		System.out.println(lc);
		if (cellType.equals(CellType.STRING)) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int a = (int) numericCellValue;
			System.out.println(a);
		}
		wb.close();
	}

	public static void main(String[] args) throws IOException {
		readexcel();
//		ReadData a = new ReadData();
//		a.readexcel();

	}

}