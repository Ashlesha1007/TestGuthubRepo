package com.demo.Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.demo.Locators.LoginLocators;
import com.demo.Util.GetProperties;

public class LoginAction extends BaseClass{

	LoginLocators l = new LoginLocators(driver);
	public void clickOnGmail()
	{
		
		GetProperties g = new GetProperties();
		//userClick(l.gmailURL);
		userClick(l.amazonURL);
		userType(l.userName, g.getProperties("userName"));
		userClick(l.ContinueBtn);
		userType(l.password, g.getProperties("password"));
		userClick(l.LoginBtn);
		//userType(l.gmailURL, "test");
	}
	
	public void MouseHovOnAccountandLists() throws InterruptedException
	{
		mouseHovering(l.NavigationArrow);
		Thread.sleep(4000);
		userClick(l.YourAccount);
	}
	
}
