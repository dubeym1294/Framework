package com.test.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		File src = new File(System.getProperty("user.dir")+"/Config/config.properties");
		try {
			FileInputStream fs = new FileInputStream(src);
			pro = new Properties();
			pro.load(fs);
		} catch (Exception e) {
			System.out.println("Unable to read config file > " + e.getMessage());
		} 
		
	}

	public String getDataFromConfig(String keyToSearch) 
	{
	 return pro.getProperty(keyToSearch);	
	}
	
	public String getBrowser() 
	{
		return pro.getProperty("Browser");
	}
	
	public String getUrl() 
	{
		return pro.getProperty("TestURL");
	}
}
