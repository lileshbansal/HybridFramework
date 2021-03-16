package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	// 1. By Locators: OR
/*	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?111");*/
	
	@FindBy(id = "email")
	WebElement emailId;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInButton;
	
	@FindBy(id = "Forgot your password?")
	WebElement forgotPwdLink;

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}

	public boolean isForgotPwdLinkExist() {
		return forgotPwdLink.isDisplayed();
	}

	public void enterUserName(String username) {
		emailId.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickOnLogin() {
		signInButton.click();
	}

	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		signInButton.click();
		return new AccountsPage(driver);
	}

}
