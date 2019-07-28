package com.demo.Actions;

import com.demo.Util.GetProperties;
import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	
  public static WebDriver driver;
  public ExtentReports report;
  public static ExtentTest logger;
 
  
  @BeforeSuite
  public void initilizeReports() {
	  report = new ExtentReports(System.getProperty("user.dir")+"//Reports//cucmber-report.html", true);
  }
  
  @AfterSuite
  public void flushReports() {
	  report.flush();
  }
	
  @BeforeMethod
  @Parameters({"browserName","envName"})
  public void beforeMethod(String browserName, String envName, Method m) {
	  logger = report.startTest(m.getName());
	
	  initilizeProp initilize = new initilizeProp();
	  GetProperties prop = new GetProperties();
	  System.out.println(envName);
	  initilize.setEnvName(envName);
	  System.out.println(browserName);
	  instatiateBrowser(browserName);
	  
	  
	  driver.get(prop.getProperties("url"));
  }

  @AfterMethod
  public void afterMethod() {
	  report.endTest(logger);
	  driver.quit();
  }
  
  public void instatiateBrowser(String browserName)
  {
	  
	  switch(browserName)
	  {
	  case "chrome": 
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		  driver = new ChromeDriver();
		  break;
		  
	  case "firefox":
		  System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"//drivers//firefoxdriver.exe");
		  driver = new ChromeDriver();
		  break;
	  default:
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		  driver = new ChromeDriver();
		  break;
	  }
	

  }
  
  
  public void userClick(WebElement we) {
	  logger.log(LogStatus.INFO, "User is performing click "+ we);
	  try {
		  we.click();
	  }catch(Exception e) {
		  e.printStackTrace();
		  logger.log(LogStatus.FAIL, "Exception in clicking webelement "+ we);
		  Assert.assertTrue(false);
	  }
	  logger.log(LogStatus.INFO, "User is performed click successfully "+ we);
  }
  
  public void userType(WebElement we, String text) {
	  logger.log(LogStatus.INFO, "User is entring text "+ we);
	  try {
		  we.sendKeys(text);
	  }catch(Exception e) {
		  e.printStackTrace();
		  logger.log(LogStatus.FAIL, "Exception in entering text on webelement "+ we);
		  Assert.assertTrue(false);
	  }
	  logger.log(LogStatus.INFO, "User is entered text successfully "+ we);
  }

  public void mouseHovering(WebElement target)
  {
	  Actions action = new Actions(driver);
	  action.moveToElement(target).build().perform();
	  
  }
  
}

  
  


