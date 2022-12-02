package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	private static void writeData() throws IOException {
		File f = new File(".\\Excel\\Maven Trial.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		wb.createSheet("Data").createRow(0).createCell(0).setCellValue("Username");
		wb.getSheet("Data").getRow(0).createCell(1).setCellValue("Password");
		wb.getSheet("Data").createRow(1).createCell(0).setCellValue("Sathish");
		wb.getSheet("Data").getRow(1).createCell(1).setCellValue("Sathish123");
		wb.getSheet("Data").createRow(2).createCell(0).setCellValue("Salam");
		wb.getSheet("Data").getRow(2).createCell(1).setCellValue("Salam456");

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		System.out.println("Success");
		wb.close();

	}

	public static void main(String[] args) throws IOException {
		writeData();
	}
}
