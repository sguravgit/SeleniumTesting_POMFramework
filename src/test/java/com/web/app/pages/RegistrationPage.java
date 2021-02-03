package com.web.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*
 * Created By Sachin Gurav 
 */

public class RegistrationPage extends BasicPage {
	WebDriver driver;
	
	private By firstName = By.xpath("//input[@ng-model='FirstName']");
	private By lastName = By.xpath("//input[@ng-model='LastName']");
	private By address = By.xpath("//textarea[@ng-model='Adress']");
	private By emailAddress = By.xpath("//input[@ng-model='EmailAdress']");
	private By phoneNumber = By.xpath("//input[@ng-model='Phone']");
	private By dropdownCountry = By.id("countries");
	
//	public RegistrationPage() {
//		
//	}
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setFirstName(String strFirstName) {
		driver.findElement(firstName).sendKeys(strFirstName);
	}
	
	public void setLastName(String strLastName) {
		driver.findElement(lastName).sendKeys(strLastName);
	}
	
	public void setAddress(String strAddress) {
		driver.findElement(address).sendKeys(strAddress);
	}
	
	public void setEmailAddress(String strEmailAddress) {
		driver.findElement(emailAddress).sendKeys(strEmailAddress);
	}
	
	public void selectCountry(String strCountry) {
		Select selCountry = new Select(driver.findElement(dropdownCountry));
		selCountry.selectByVisibleText(strCountry);
	}
	
	public void getSelectedCountry() {
		Select selCountry = new Select(driver.findElement(dropdownCountry));
		System.out.println("Selected Country = "+selCountry.getFirstSelectedOption().getText());
	}
	
	public boolean checkRegistrationPage() {
		selectCountry("India");
		getSelectedCountry();
		return driver.findElement(firstName).isDisplayed() && driver.findElement(lastName).isDisplayed() &&
			   driver.findElement(address).isDisplayed() && driver.findElement(emailAddress).isDisplayed();
	}

}
