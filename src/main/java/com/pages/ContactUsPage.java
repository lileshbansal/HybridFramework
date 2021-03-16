package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	
	private WebDriver driver;
/*
	private By subjectHeading = By.id("id_contact");
	private By email = By.id("email");
	private By orderRef = By.id("id_order");
	private By messageText = By.id("message");
	private By sendButton = By.id("submitMessage");
	private By successMessg = By.cssSelector("div#center_column p");*/
	
	@FindBy(id = "id_contact")
	WebElement subjectHeading;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "id_order")
	WebElement orderRef;
	
	@FindBy(id = "message")
	WebElement messageText;
	
	@FindBy(id = "id_contact")
	WebElement sendButton;
	
	@FindBy(css = "div#center_column p")
	WebElement successMessg;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {
		Select select = new Select(subjectHeading);
		select.selectByVisibleText(heading);
		email.sendKeys(emailId);
		orderRef.sendKeys(orderReference);
		messageText.sendKeys(message);
	}

	public void clickSend() {
		sendButton.click();
	}
	
	public String getSuccessMessg() {
		return successMessg.getText();
	}
	
	
	
	

}
