package com.test.testcases;


import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


import com.test.pages.BaseClass;
import com.test.pages.LoginPage;


public class LoginToOdoo extends BaseClass {
	
	
	@Test
	public void launching() {
		
	logger=report.createTest("Logging to Odoo");
	
	LoginPage Lpage= PageFactory.initElements(driver, LoginPage.class);
	logger.info("Starting the Application");
	Lpage.loginToOdoo(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
	logger.pass("Login done Successfully");
		}
	


}
