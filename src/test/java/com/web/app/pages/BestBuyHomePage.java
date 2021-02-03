package com.web.app.pages;

import org.openqa.selenium.*;

/*
 * Created By Sachin Gurav 
 */

public class BestBuyHomePage extends BasicPage {
	WebDriver driver;

	public By searchField = By.xpath("//input[@id='gh-search-input']");
	public By MyAccountImage = By.xpath("//button[@data-lid='hdr_signin']");
	private By Popup_Close = By.xpath("//button[@class='c-close-icon  c-modal-close-icon']");
	public By AccountMenu_SignIn = By.xpath("//a[@data-lid='ubr_mby_signin_b']");

	public BestBuyHomePage() {
	    	
	}
	
	public BestBuyHomePage(WebDriver d) {
    	this.driver=d;
    }

	public boolean checkHomePage() {
		// check if search Field is displayed
		return driver.findElement(searchField).isDisplayed() && driver.findElement(searchField).isEnabled() &&
		// check if Account link is displayed
		driver.findElement(MyAccountImage).isDisplayed();
	}
	
	public void closePopupModalIfPresent() {
		if(driver.findElement(Popup_Close).isDisplayed()) {
			driver.findElement(Popup_Close).click();
		}
	}

	public void clickMyAccount() {
		closePopupModalIfPresent();
		if (driver.findElement(MyAccountImage).isDisplayed()) {
			driver.findElement(MyAccountImage).click();
		}
	}

	public boolean checkMyAccountMenu() {
		clickMyAccount();
		return driver.findElement(AccountMenu_SignIn).isDisplayed();
	}

	public BestBuySigninPage clickMyAccount_Signin() {
		System.out.println("clickMyAccount_Signin"); clickMyAccount();
		driver.findElement(AccountMenu_SignIn).click();
		System.out.println("After AccountMenu_SignIn click");
		return new BestBuySigninPage(driver);
	}

}
