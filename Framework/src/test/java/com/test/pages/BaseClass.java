package com.test.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.utility.BrowserFactory;
import com.test.utility.ConfigDataProvider;
import com.test.utility.ExcelDataProvider;
import com.test.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void SetupSuite()
	{
		
		Reporter.log("Setting up reports and test is getting started", true);
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Odoo/"+Helper.getCurrentDateTime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 
		 Reporter.log("Setting up reports and test can be started", true);
		
	}
	@BeforeClass
	public void setup() {
		
		Reporter.log("Trying to start browser and Getting application Ready", true);
		driver =BrowserFactory.StartApplication(driver, config.getBrowser(), config.getUrl());
		Reporter.log("Browser and Application is up and running", true);
		}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethods(ITestResult result)
	{
		try {
			if(result.getStatus()==ITestResult.FAILURE)
			{
				
				
					logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
			}
				else if(result.getStatus()==ITestResult.SUCCESS) 
				{
					logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
				}
		} catch (IOException e) {
			
			System.out.println("Unable to add Screenshot > " + e.getMessage());
		}
		report.flush();
		
		Reporter.log("Test Completed >> Reports Generated ", true);
		}
	
		
	}


