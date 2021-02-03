package com.web.app.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Created By Sachin Gurav 
 */

public class DriverProvider {
	static WebDriver driver;
	static FileInputStream fs;
	static Properties prop = new Properties();
	static HashMap <Object, Object> testContext = new HashMap<Object, Object>();
	
	public static WebDriver initializeSetUp(String env) {
		testContext.put("Env",env);
		String testEnv = testContext.get("Env")==null ? "staging" : testContext.get("Env").toString();
		System.out.println("testEnv = "+testEnv);
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/ConfigProperties/config-"+testEnv+"-env.properties");
			prop.load(fs);
			String appURL= prop.getProperty("application_url");
			String browswerType= prop.getProperty("browserType");
			
			System.out.println("appURL = "+appURL);
			System.out.println("browser = "+browswerType);
			
			  
			if(browswerType.equalsIgnoreCase("Chrome")) {
				System.out.println("browser = "+browswerType);
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/IOSDrivers/chromedriver");
				driver = new ChromeDriver();
				driver.navigate().to(appURL);
		        //Maximize the browser  
		        driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				
			} else if( browswerType.equalsIgnoreCase("Firefox")) {
				System.out.println("browser = "+browswerType);
				System.out.println("Work in Progress");
			}

			} catch(Exception e) {
				System.out.println("exceptionn =" + e);
			}
		return driver;
	}
	
	public static void tearDown(WebDriver driver) throws IOException {
		prop.clear();
		fs.close();
		driver.close();
	}
	

}
