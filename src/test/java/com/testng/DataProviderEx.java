package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
	
	@Test (dataProvider = "credential")
	public void loginvalidate(String username , String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys(username);
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(password);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		driver.close();
	}
	
	@DataProvider (name = "credential")
	public String[][] generate() {
		String[][] credentials = new String[3][2];
		
		for(int i=0; i<=2; i++) {
			for(int j=0; j <=1; j++) {
				credentials[i][j] = Excelutils.readCellData("Sheet1", i, j);
			}
		}
		
//		credentials[0][0] ="lavanya@gmail.com";
//		credentials[0][1] ="lavanya123";
//		
//		credentials[1][0] ="evanglin@gmail.com";
//		credentials[1][1] ="evanglin123";
//		
//		credentials[2][0] ="bharathi@gmail.com";
//		credentials[2][1] ="bharathi123";
		return credentials;
	}


}
