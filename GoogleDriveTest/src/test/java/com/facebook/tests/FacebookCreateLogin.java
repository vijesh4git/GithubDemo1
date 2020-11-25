package com.facebook.tests;

import org.testng.annotations.Test;

import com.facebook.pages.FaceBookLoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FacebookCreateLogin {
	
	WebDriver driver;
	FaceBookLoginPage fbp;
  @Test(priority = 1)
  public void VerifySignUpFormVisibility() throws Exception
  {
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();  
	  fbp = new FaceBookLoginPage(driver);
	  fbp.VerifyDisplaySignUp();
	  boolean formAvailable = true;
	  Assert.assertEquals(fbp.VerifyDisplaySignUp(), formAvailable);
  }
  
  @Test(priority = 2)
  public void VerifyFields()
  {
   String errMsg = fbp.VerifyMandatoryFields();
   Assert.assertEquals(errMsg, "What's your name?");
   
  }
  @BeforeTest
  public void beforeTest() {
	  
	    System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
  }

  @AfterTest
  public void afterTest() {
  }

}
