package com.web.app.tests;

import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.web.app.pages.BestBuyHomePage;
import com.web.app.pages.RegistrationPage;

/*
 * Created By Sachin Gurav 
 */

public class JunitTC1 {
	static WebDriver driver;
	static RegistrationPage registration;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = RegistrationPage.initializeSetUp("staging");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		RegistrationPage.tearDown(driver);

	}

	@Test
	public void testRegistrationPageUI() {
		registration= new RegistrationPage(driver);
		Assert.assertTrue("Error:There are issues on registration page", registration.checkRegistrationPage());
	}
	
//	@Test
//	public void testInvalidLogin() {
//		appHome= new AppHomePage_COPY(driver);
//		Assert.assertTrue("Error:There are issue on Home page", appHome.checkHomePage());
//		signin = appHome.clickMyAccount_Signin();
//		signin.clickSigninButton();
//		Assert.assertTrue("", signin.isMandatoryErrorDisplayed());
//	}

}
