package com.googledrive.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GDriveLogin {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "(//a[contains(text(),'Go to Drive')])[2]")
	WebElement Grivebtn;
	@FindBy(css = "input[type='email']")
	WebElement userid;
	@FindBy(css = "input[type='password']")
	WebElement pswd;
	@FindBy(xpath = "//span[text()='Next']//following-sibling::div")
	WebElement nxtbtn;
	@FindBy(xpath = "//a/img[@class='gb_Ia gbii']")
	WebElement acntbtn;
	@FindBy(xpath="(//a[text()='Manage your Google Account']//preceding-sibling::div)[2]")
	WebElement loginid;
	
	public GDriveLogin(WebDriver driver)
	{
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String GLogin(String username,String password)
	{
		//System.out.println(username+" " +password);
		String loggedEmail = "";
		String mainwindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOf(Grivebtn)).click();
		
		//driver.getCurrentUrl();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String>it = ids.iterator();
		while(it.hasNext())
		{
			String childwindow = it.next();
			if(!mainwindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				wait.until(ExpectedConditions.visibilityOf(userid)).sendKeys(username);
				wait.until(ExpectedConditions.visibilityOf(nxtbtn)).click();
				wait.until(ExpectedConditions.visibilityOf(pswd)).sendKeys(password);
				wait.until(ExpectedConditions.visibilityOf(nxtbtn)).click();
				wait.until(ExpectedConditions.visibilityOf(acntbtn)).click();
				loggedEmail = wait.until(ExpectedConditions.visibilityOf(loginid)).getText();
				
				
			}
		}
	 
		return loggedEmail;
	
		
	}
	
	
}
