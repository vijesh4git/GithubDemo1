package com.sqldb.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBConnectionUtility {
 WebDriver driver;
	@Test
	public void TestDB() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver"); 
	driver.get("https://demostore.x-cart.com/");
	String url = "jdbc:mysql://localhost:3306/qadbt";     
	String host = "localhost";
	String port = "3306";
	Connection conObj = null;
	conObj = DriverManager.getConnection(url,"mysql123","avenger123" );
	Statement stmt = conObj.createStatement();
	String sqlquery = "select * from EmployeeInfo";
	ResultSet rs = stmt.executeQuery(sqlquery);
	while(rs.next())
	{
		
		System.out.println(rs.getString("name"));
		
	}
}
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
}
