package com.demo.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators{
	
	WebDriver driver;
	
	public LoginLocators(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*@FindBy(xpath="//a[text()='Gmail']")
	public WebElement gmailURL;*/
	
	@FindBy(xpath="//span[contains(text(), 'Account & Lists') and @class='nav-line-2']")
	public WebElement amazonURL;
	
	@FindBy(xpath="//span[contains(text(), 'Sign in') and @class='nav-line-3']")
	public WebElement signIn;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement userName;
	
	@FindBy(xpath="//span[@id='continue']")
	public WebElement ContinueBtn;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public WebElement LoginBtn;
	
	@FindBy(xpath="//span[@class='nav-icon nav-arrow']//parent::span[contains(text() , 'Account')]/span")
	public WebElement NavigationArrow;
	@FindBy(xpath="//a[@href= '/gp/css/homepage.html?ie=UTF8&ref_=nav_youraccount_ya']")
	public WebElement YourAccount;
	
	
	

}
