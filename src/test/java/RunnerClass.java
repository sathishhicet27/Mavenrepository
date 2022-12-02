import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.MavenProjects.BaseClass;

public class RunnerClass extends BaseClass {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		driver = browserLaunch("chrome");
		driver = getUrl("https://adactinhotelapp.com/index.php");
		WebElement username = driver.findElement(By.id("username"));
		String usernamevalue = readData(".\\Excel\\Maven Trial.xlsx", 0, 1, 0);
		inputvalueElement(username, usernamevalue);
		WebElement password = driver.findElement(By.id("password"));
		String passwordvalue = readData(".\\Excel\\Maven Trial.xlsx", 0, 1, 1);
		inputvalueElement(password, passwordvalue);
		WebElement login = driver.findElement(By.id("login"));
		clickonElement(login);
		WebElement location = driver.findElement(By.id("location"));
		dropDown("selectbyindex", location, "2");
		WebElement hotels = driver.findElement(By.id("hotels"));
		dropDown("selectbyindex", hotels, "2");
		WebElement roomtype = driver.findElement(By.id("room_type"));
		dropDown("selectbyindex", roomtype, "2");
		WebElement roomnos = driver.findElement(By.id("room_nos"));
		dropDown("selectbyindex", roomnos, "3");
		WebElement datepickin = driver.findElement(By.id("datepick_in"));
		inputvalueElement(datepickin, "13/11/2022");
		WebElement datepickout = driver.findElement(By.id("datepick_out"));
		inputvalueElement(datepickout, "15/11/2022");
		WebElement adult = driver.findElement(By.id("adult_room"));
		dropDown("selectbyindex", adult, "3");
		WebElement childroom = driver.findElement(By.id("child_room"));
		dropDown("selectbyindex", childroom, "2");
		WebElement submit = driver.findElement(By.id("Submit"));
		clickonElement(submit);

		driver.close();

	}
}
