package com.web.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Created By Sachin Gurav 
 */

public class BestBuySigninPage extends BasicPage{
	WebDriver driver;
	
	public By emailTextField = By.id("fld-e");
	public By passwordTextField = By.id("fld-p1");
	public By signinButton = By.xpath("//button[@data-track='Sign In']");
	public By mandatoryErrorEmail = By.xpath("//span[@id='fld-e-text']");
	
	
	public BestBuySigninPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setEmail(String emailID) {
		driver.findElement(emailTextField).sendKeys(emailID);
	}
	
	public void setPassword(String password) {
		driver.findElement(emailTextField).sendKeys(password);
	}
	
	public void clickSigninButton() {
		WebElement btnSignIn = driver.findElement(signinButton);
		if(btnSignIn.isDisplayed()) {
			btnSignIn.click();
		}
	}
	
	public boolean isMandatoryErrorDisplayed() {
		System.out.println("isMandatoryErrorDisplayed..");
		return driver.findElement(mandatoryErrorEmail).isDisplayed();
	}

}
