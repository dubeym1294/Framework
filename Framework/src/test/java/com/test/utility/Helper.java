package com.test.utility;



import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	public static String captureScreenShots(WebDriver driver)
	{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath =System.getProperty("user.dir")+"/Screenshots/Odoo_"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src, new File(screenShotPath));
			
			System.out.println("ScreenShot Captured");
		} catch (IOException e) {
			System.out.println("Unable to Capture ScreenShot " + e.getMessage());
		}
		return screenShotPath;
		
		
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat Customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date Currentdate = new Date();
		
		return Customformat.format(Currentdate);
		
		
	}
}
