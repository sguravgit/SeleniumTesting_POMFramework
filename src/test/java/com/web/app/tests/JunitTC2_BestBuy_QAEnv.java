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
import com.web.app.pages.BestBuySigninPage;

/*
 * Created By Sachin Gurav 
 */

public class JunitTC2_BestBuy_QAEnv {
	static WebDriver driver;
	BestBuyHomePage appHome;
	BestBuySigninPage signin;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//appHome = new BestBuyHomePage();
		driver = BestBuyHomePage.initializeSetUp("qa");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BestBuyHomePage.tearDown(driver);

	}

	@Test
	public void testBestBuyHomePage() {
		appHome= new BestBuyHomePage(driver);
		Assert.assertTrue("Error:There are issue on Home page", appHome.checkHomePage());
	}
	
	@Test
	public void testInvalidLogin() {
		appHome= new BestBuyHomePage(driver);
		Assert.assertTrue("Error:There are issue on Home page", appHome.checkHomePage());
		signin = appHome.clickMyAccount_Signin();
		signin.clickSigninButton();
		Assert.assertTrue("", signin.isMandatoryErrorDisplayed());
	}

}
