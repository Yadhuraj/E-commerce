package com.yadhu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		/*
		 * 1.searchContext The driver that will be used to look up the elements 2.page
		 * The object with WebElement and List<WebElement> fields that should beproxied.
		 */
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#email")
	public WebElement email;

	@FindBy(css = "input#password")
	public WebElement password;

	@FindBy(css = "button#customerloginForm")
	public WebElement signinButton;

	@FindBy(xpath = "//div[@id ='navbarText']//ul//li[2]//button")
	public WebElement logoutbutton;

	@FindBy(xpath = "//a[text() = 'Logout']")
	public WebElement logoutdropdown;

	public void logintest(String username, String pass) {
		System.out.println("Inside logintest");
		HomePage hm = new HomePage(driver);
		BaseClass.wait.until(ExpectedConditions.visibilityOf(hm.loginButton)).click();
		email.sendKeys(username);
		password.sendKeys(pass);
		signinButton.click();
		BaseClass.wait.until(ExpectedConditions.visibilityOf(logoutbutton)).click();
		BaseClass.wait.until(ExpectedConditions.visibilityOf(logoutdropdown)).click();

	}

	public void Onlylogin(String username, String pass) {
		HomePage hm = new HomePage(driver);
		hm.loginButton.click();
		email.sendKeys(username);
		password.sendKeys(pass);
		signinButton.click();

	}

	public void OnlyLogOut() {
		BaseClass.wait.until(ExpectedConditions.visibilityOf(logoutbutton)).click();
		BaseClass.wait.until(ExpectedConditions.visibilityOf(logoutdropdown)).click();

	}

}
