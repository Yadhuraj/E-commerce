package com.yadhu.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Sheet;

import com.yadhu.pages.BaseClass;
import com.yadhu.pages.ItemCheckout;
import com.yadhu.pages.LoginPage;

public class CheckoutPage extends BaseClass{
	
	@Test(dataProvider = "billingInfo")
	public void AddToCart(String Email,String Fname , String Lname , String Addr1 , String Country , String State , String Pin , String Phnum) throws EncryptedDocumentException, IOException, InterruptedException
	{
		ItemCheckout chk = new ItemCheckout(driver);
		LoginPage lp = new LoginPage(driver);
		lp.Onlylogin(excel.stringCellValue(1, 0, "Login"), excel.stringCellValue(1, 1, "Login"));
		chk.addtocart();
		try {
			chk.checkoutcart(Email, Fname, Lname, Addr1, Country, State, Pin, Phnum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}
		
		lp.OnlyLogOut();
		
	}
	
	
	@DataProvider(name="billingInfo")
	public String[][] billingInfo() throws EncryptedDocumentException, IOException
	{
		
		int row = excel.numrows("Billing");
//		System.out.println(row);
		int col = excel.numcols("Billing");
//		System.out.println(col);
		String[][] s = new String[row][col];
//		System.out.println(excel.stringCellValue(1, 0, "Billing"));
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				String celltype = excel.cellType(i, j, "Billing");
				switch (celltype) {
				case "NUMERIC":
					s[i-1][j]=excel.numericCellValue(i, j,"Billing" )+"";
//					System.out.println("["+i+"]["+j+"]: "+s[i-1][j]);
					break;
				
				case "STRING":
					s[i-1][j]=excel.stringCellValue(i, j,"Billing");
//					System.out.println("["+i+"]["+j+"]: "+s[i-1][j]);
					break;

				default:
					System.out.println("Unexpected Cell type");
					break;
				}
				
			}
		}
		
		return s;
	}
	
}
