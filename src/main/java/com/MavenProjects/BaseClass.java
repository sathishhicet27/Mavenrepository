package com.MavenProjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static String value;
	

	public static WebDriver browserLaunch(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (type.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.manage().window().maximize();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;
	}

	public static WebDriver close() {
		driver.close();
		return driver;
	}

	public static WebDriver quit() {
		driver.quit();
		return driver;
	}

	public static void inputvalueElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clickonElement(WebElement element) {
		element.click();

	}

	public static void dropDown(String type, WebElement element, String value) {
		Select a = new Select(element);
		if (type.equalsIgnoreCase("selectByValue")) {
			a.selectByValue(type);
		} else if (type.equalsIgnoreCase("selectByIndex")) {
			int data = Integer.parseInt(value);
			a.selectByIndex(data);
		} else if (type.equalsIgnoreCase("selectByVisibleText")) {
			a.selectByVisibleText(type);

		}
	}
public static String readData(String path,int sheetIndex,int sheetRow,int sheetCell) throws IOException {
	File f = new File(path);
	FileInputStream fis=new FileInputStream(f);
	Workbook wb=new XSSFWorkbook(fis);
	Sheet sheetAt = wb.getSheetAt(sheetIndex);
	Row row = sheetAt.getRow(sheetRow);
	Cell cell = row.getCell(sheetCell);
	CellType cellType = cell.getCellType();
	if (cellType.equals(CellType.STRING)) {
		value=cell.getStringCellValue();
		
	}
	else if (cellType.equals(CellType.NUMERIC)) {
	double numericCellValue = cell.getNumericCellValue();
	int data=(int) numericCellValue;
	value=String.valueOf(data);
		
	}
	wb.close();
return value;
		

}	
}
