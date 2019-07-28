package com.demo.Steps;

import org.testng.annotations.Test;

import com.demo.Actions.BaseClass;
import com.demo.Actions.LoginAction;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class LoginStep extends BaseClass {
	
  @Test(priority=0)
  public void logingmail() throws InterruptedException {
	 LoginAction la = new LoginAction();
	// logger.log(LogStatus.INFO, "user clicking on gmail btn");
	 la.clickOnGmail();
	 //logger.log(LogStatus.INFO, "user clicked on gmail btn");
	 //verifyTest(true, "");
	 
	 if(true) {
		 logger.log(LogStatus.PASS, "matched");
		 Assert.assertTrue(true);
	 }else {
		 logger.log(LogStatus.FAIL, "not matched");
		 Assert.assertTrue(false);
	 }
	 la.MouseHovOnAccountandLists();
	 logger.log(LogStatus.INFO, "test@123");
  }
  
 /* @Test
  public void logingmail1() {
	 LoginAction la = new LoginAction();
	 logger.log(LogStatus.INFO, "user clicking on gmail btn");
	 la.clickOnGmail();
	 logger.log(LogStatus.INFO, "user clicked on gmail btn");
	  
  }*/
}
