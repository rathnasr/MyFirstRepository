package com.testng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicReportCode {

	public static void main(String[] args) {
		//creates blank html
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/basicreport.html");
		
		//creates actual report
		ExtentReports ExtentReport = new ExtentReports();
		
		//attach report in the html
		ExtentReport.attachReporter(reporter);
		
		//create a test1
		ExtentTest test1 = ExtentReport.createTest("Basic report generation");
		//condidering test as passed. giving message to be printed when passed
		test1.pass("Test Passed");
		//write the report to the disk
		
		//create a test1
		ExtentTest test2 = ExtentReport.createTest("screenshot test");
		test2.fail("testcase failed", MediaEntityBuilder.createScreenCaptureFromPath("Screenshot 2025-06-08 212502.png").build());
		
		ExtentReport.flush();
	}

}
