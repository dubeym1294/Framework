package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
		
	}
	
	
	@FindBy(how=How.ID,using="login")
	WebElement uname;
	@FindBy(how=How.NAME,using="password")
	WebElement pwd;
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	WebElement sub;
	
	public void loginToOdoo(String UNameForApplication, String PassForApplication) {
		uname.sendKeys(UNameForApplication);
		pwd.sendKeys(PassForApplication);
		sub.click();
		
	}
	
}
