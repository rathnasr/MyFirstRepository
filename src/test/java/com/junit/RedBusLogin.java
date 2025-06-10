package com.junit;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusLogin {
	public static WebDriver driver;
	@BeforeClass
	public static void browserLaunch() {
		driver = new ChromeDriver();		
	}
	@Test
	public void login() {
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement account = driver.findElement(By.cssSelector("div[class='rightSection___0d9d17'] div:nth-child(3)"));
		account.click();
		WebElement signin = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
		signin.click();
		String username ="9876543210";
		WebElement elementUsername = driver.findElement(By.cssSelector("input[type='text']"));
		elementUsername.sendKeys(username);
		String actualusername = elementUsername.getAttribute("value");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		Alert popup = wait.until(ExpectedConditions.alertIsPresent());
//		driver.switchTo().alert();
//		popup.sendKeys(username);

		
//		WebElement elementUsername = driver.findElement(By.cssSelector("input[type=\"number\"]"));
//		elementUsername.sendKeys(username);
//		String actualusername = elementUsername.getAttribute("value");
	
		Assert.assertEquals(username, actualusername);
		System.out.println("username is correct");
		
	}
	
//	@AfterClass
//	public static void closeBrowser() {
//		driver.close();
//	}
//	
	
}
