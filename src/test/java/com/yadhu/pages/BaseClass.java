package com.yadhu.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.yadhu.utilities.BrowserFactory;
import com.yadhu.utilities.ExcelReader;

public class BaseClass {
	public WebDriver driver;
	public static Properties prop;
	public static ExcelReader excel;
	public static WebDriverWait wait;

	@BeforeClass
	public void beforeTestSetup() throws IOException {
		FileInputStream ip = new FileInputStream("./ConfigurationFiles/config.properties");

		prop = new Properties();
		prop.load(ip);
		excel = new ExcelReader();
		String browser = prop.getProperty("browser");
		driver = BrowserFactory.setupbrowser(driver, browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		
	}
	
//	@BeforeMethod
//	public void beforeMethodSetup() throws IOException {
//		System.out.println("Before Method");
//		
//	}
	
	

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
