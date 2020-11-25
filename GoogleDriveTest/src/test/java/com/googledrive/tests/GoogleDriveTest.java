package com.googledrive.tests;

import org.testng.annotations.Test;

import com.googledrive.pages.FileUpload;
import com.googledrive.pages.GDriveLogin;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class GoogleDriveTest {
	
	WebDriver driver;
  @Test(dataProvider = "DataFromExcel")
  public void GDriveTest(String username,String password) {
	  try {
	  driver.get("https://drive.google.com/");
	  driver.manage().window().maximize();
	  GDriveLogin oblogin = new GDriveLogin(driver);
	  String loggedinEmail = oblogin.GLogin(username,password);
	  Assert.assertEquals(username, loggedinEmail);
	  FileUpload objFile = new FileUpload(driver);
	  objFile.PerformFileUpload();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
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
  
  @DataProvider
  public Object[][] DataFromExcel() throws Exception {
		Utilities.ExcelUtilities oexcel = new Utilities.ExcelUtilities("E:\\Test\\TestData.xlsx", "credentials");
		return oexcel.exceldp();

}
}