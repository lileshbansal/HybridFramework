package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	private WebDriver driver;

	//private By accountSections = By.cssSelector("div#center_column span");
	
	@FindBy(css = "div#center_column span")
	List<WebElement> accountSections;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public int getAccountsSectionCount() {
		return accountSections.size();
	}

	public List<String> getAccountsSectionsList() {

		List<String> accountsList = new ArrayList<>();
		//List<WebElement> accountsHeaderList = accountSections;

		for (WebElement e : accountSections) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}

		return accountsList;

	}

}
