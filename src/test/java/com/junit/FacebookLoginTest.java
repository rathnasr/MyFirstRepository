package com.junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTest {
	public static WebDriver driver;
	@BeforeClass
	public static void browserLaunch() {
		driver = new ChromeDriver();		
	}

	@Test
	public void login() {
		driver.get("https://www.facebook.com");
		WebElement we = driver.findElement(By.id("email"));
		String username ="siva@gmail.com";
		String password = "1234";
		
		//System.out.println(we.getText());
		WebElement elementUsername = driver.findElement(By.id("email"));
		WebElement elementpassword = driver.findElement(By.name("pass"));
		
		elementUsername.sendKeys(username);
		elementpassword.sendKeys(password);
		
		String actualusername = elementUsername.getAttribute("valu e");
		String actualpassword = elementpassword.getAttribute("value");
	
		Assert.assertEquals(username, actualusername);
		Assert.assertEquals(password,actualpassword);
		System.out.println("input data is correct");
		
	}
	
	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}
	
	
}
