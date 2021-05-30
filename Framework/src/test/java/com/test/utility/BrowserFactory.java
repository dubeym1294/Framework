package com.test.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

	
	public static WebDriver StartApplication(WebDriver driver,String browserName,String appURL) {
		
		String as = System.getProperty("os.name").toLowerCase();
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			if(as.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver");
			driver = new ChromeDriver();
			}
			else {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			
			if(as.contains("mac")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/Drivers/geckodriver");
				driver = new FirefoxDriver();
				}
				else {
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/Drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					
				}
			
		}
		else if (browserName.equalsIgnoreCase("Safari")) {
			
			  driver = new SafariDriver();
			
		}
		else{
			System.out.println("We do not support this browser");
	
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		
		driver.quit();
	}
}
