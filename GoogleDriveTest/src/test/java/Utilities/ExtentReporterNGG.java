package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNGG {
	
	static ExtentReports extent;
	public static ExtentReports reportObject()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\Index.html";
		  ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		  reporter.config().setReportName("Web Automation Results");
		  reporter.config().setDocumentTitle("Test Results");
		  extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("Tester", "Vijesh");
		  return extent;
		
	}

}
