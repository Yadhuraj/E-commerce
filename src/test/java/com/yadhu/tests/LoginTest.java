package com.yadhu.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yadhu.pages.BaseClass;
import com.yadhu.pages.LoginPage;
import com.yadhu.utilities.TakeScreenshot;

public class LoginTest extends BaseClass {
	@Test(priority = 1, dataProvider = "logindata")
	public void loginTest(String username, String password) throws IOException, InterruptedException {

		try {
			LoginPage lp = new LoginPage(driver);
				
			lp.logintest(username, password);
		} catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.captureSC(driver, "loginTest");
			AssertJUnit.fail(e.toString());
		}
		Thread.sleep(3000);
	}

	@DataProvider(name = "logindata")
	public String[][] loginData() throws EncryptedDocumentException, IOException {
		String[][] data;
		int rows = excel.numrows("Login");
//		System.out.println("row: " + rows);
		int cols = excel.numcols("Login");
//		System.out.println("cols: " + cols);
		data = new String[rows][cols];
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {

//				System.out.println("data[" + (i - 1) + "][" + j + "]" + excel.stringCellValue(i, j, "Login"));
				data[i - 1][j] = excel.stringCellValue(i, j, "Login");

			}
		}

		return data;

	}

}
