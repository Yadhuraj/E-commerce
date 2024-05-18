package com.yadhu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItemCheckout {
	WebDriver driver;

	public ItemCheckout(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement HomePage;
	
	@FindBy(xpath = "//h3[contains(text(),'Watches  Products')]")
	WebElement watchespage;

	@FindBy(xpath = "//button[text()='+']")
	WebElement addQunatity;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath = "//a[contains(@href,'cart')]")
	WebElement cart;

	@FindBy(xpath = "//a[contains(text(),'Checkout')]")
	WebElement checkoutbutton;

	// Billing info
	@FindBy(id = "shipEmail")
	WebElement shippingEmail;

	@FindBy(id = "shipFirstname")
	WebElement shippingFName;
	
	@FindBy(id = "shipLastname")
	WebElement shippingLName;
	
	@FindBy(id = "shipAddr1")
	WebElement shippingAddr1;
	
	@FindBy(id = "shipCountry")
	WebElement shippingCountry;
	
	@FindBy(id = "shipState")
	WebElement shippingState; 
	
	@FindBy(id = "shipPostcode")
	WebElement shippingPin; 
	
	@FindBy(id = "shipPostcode")
	WebElement shippingPhoneNum;
	
	@FindBy(id = "checkoutInformation")
	WebElement shippingContinueButton;
	
	public void addtocart()
	{
		HomePage.click();
		watchespage.click();
		addQunatity.click();
		addToCart.click();
	}
	
	public void checkoutcart(String Email,String Fname , String Lname , String Addr1 , String Country , String State , String Pin , String Phnum) throws InterruptedException
	{
		cart.click();
		checkoutbutton.click();
		shippingEmail.clear();
		shippingEmail.sendKeys(Email);
		
		shippingFName.clear();
		shippingFName.sendKeys(Fname);
		
		shippingLName.clear();
		shippingLName.sendKeys(Lname);
		
		shippingAddr1.clear();
		shippingAddr1.sendKeys(Addr1);
		
		
		Select s = new Select(shippingCountry);
		s.selectByValue(Country);
		
		shippingState.clear();
		shippingState.sendKeys(State);
		
		shippingPin.clear();
		shippingPin.sendKeys(String.valueOf(Pin));
		
		shippingPhoneNum.clear();
		shippingPhoneNum.sendKeys(Phnum+"");
		
		
		shippingContinueButton.click();
		
		Thread.sleep(5000);
		
	}
	
	
	
	

}
