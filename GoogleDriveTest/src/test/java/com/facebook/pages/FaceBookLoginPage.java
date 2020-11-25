package com.facebook.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookLoginPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//a[text()='Create New Account']")
	WebElement CreateNewBtn;
	@FindBy(xpath = "//a[@id=\"u_0_2\"]")
	WebElement CreateNewBtn1;
	
	@FindBy(xpath = "//div[text()='Sign Up']")
	WebElement SignUptxt;
	@FindBy(xpath = "//button[@name=\"websubmit\"]")
	WebElement submitBtn;
	@FindBy(xpath = "//input[@name=\"firstname\"]")
	WebElement firstname;
	JavascriptExecutor js;
	@FindBy(xpath = "//div[contains(.,\"What's your name?\") and @id=\"js_0\"]")
	WebElement fnameError;
	
	
	public FaceBookLoginPage(WebDriver driver)
	{
		js= (JavascriptExecutor)driver;
			
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean VerifyDisplaySignUp()
	{
	  wait.until(ExpectedConditions.elementToBeClickable(CreateNewBtn1)).click();
	  boolean signupAvailable = wait.until(ExpectedConditions.visibilityOf(SignUptxt)).isDisplayed();
	  return signupAvailable;
	}
	public String VerifyMandatoryFields()
	{
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
		String rgbval = driver.findElement(By.xpath("//input[@name=\"lastname\"]")).getCssValue("border-color");
		System.out.println("border color is  " + rgbval);
		//String valmsg = driver.findElement(By.xpath("//input[@name=\"firstname\"]")).getAttribute("validationMessage");
		//String valmsg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"firstname\"]"))).getAttribute("validationMessage");
		boolean isrequired = Boolean.parseBoolean(firstname.getAttribute("required"));
		System.out.println(isrequired);
		String valmsg = (String) js.executeScript("return arguments[0].validationMessage;", firstname);
		System.out.println("validation msg is " + valmsg);
		String txt =wait.until(ExpectedConditions.visibilityOf(fnameError)).getText();
		System.out.println("error mssg is : " + txt);
		return txt;
	}

	
}
