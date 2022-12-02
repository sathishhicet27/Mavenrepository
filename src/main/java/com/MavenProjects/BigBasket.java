package com.MavenProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasket {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		WebElement findElement = driver.findElement(By.id("input"));
		findElement.sendKeys("rice");
		WebElement findElement2 = driver.findElement(By.xpath("//a[text()='dosa rice']"));
		findElement2.click();
		driver.close();

	}
}
