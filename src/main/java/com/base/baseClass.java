package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath = System.getProperty("user.dir");
	
	@BeforeTest
	public void readProperty() throws IOException {
		
		FileInputStream file = new FileInputStream(projectPath+"/config/config.properties");
		prop = new Properties();
		prop.load(file);
	}
	
	
	public void loadApplication() {
		
		String browser =  (String) prop.get("browser");
		
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
		
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
			
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;
		
		}
	}
		

}
