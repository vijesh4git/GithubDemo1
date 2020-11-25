package com.googledrive.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "(//div[@class=\"Q5txwe\"])[1]")
	WebElement Xfolder;
	@FindBy(xpath = "(//button[@aria-label=\"New\"])[1]")
	WebElement NewBtn;
	@FindBy(xpath = "//span[text()='My Drive']")
	WebElement MyDrivebtn;
	JavascriptExecutor js;
	@FindBy(xpath = "(//div[@class = \"Q5txwe\" and text()='X'])[2]")
	WebElement XFile;
	@FindBy(xpath = "//div[@class = \"Q5txwe\" ]")
	WebElement XFilee;
	@FindBy(xpath = "//span[@class = \"a-s-T\" and text()='X']")
	WebElement XFolder;
	@FindBy(xpath = "//span[@class = \"a-s-T\" and text()='Y']")
	WebElement YFolder;
	@FindBy(xpath = "(//div[@class = \"Q5txwe\" and text()='SampleFile.txt'])[2]")
	WebElement FileFrmX;
	

	
		
	public FileUpload(WebDriver driver)
	{
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void PerformFileUpload()
	{
		try {
		Actions action = new Actions(driver);
		action.moveToElement(XFilee).doubleClick().build().perform();
		 
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(NewBtn)).click();
	
		Robot robot = new Robot();
		StringSelection strselect = new StringSelection("E:\\Test\\SampleFile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselect, null);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		action.moveToElement(MyDrivebtn).doubleClick().build().perform();
		//action.moveToElement(Xfolder).doubleClick().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(XFolder)).click();
		Boolean enabled = wait.until(ExpectedConditions.elementToBeClickable(FileFrmX)).isEnabled();
		if(enabled == true)
		{
		action.moveToElement(FileFrmX).dragAndDrop(FileFrmX,YFolder).build().perform();
		action.moveToElement(YFolder).doubleClick().build().perform();
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
	}
}
