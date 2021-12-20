package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utill.TestUtill;

public class AccountsPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	
	private By accountSections = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountsPageTitle() {
		return testUtill.doGetTitle(driver);
	}
	
	public int getAccountSectionCount() {
		List<WebElement> accountsSectionCnt = testUtill.doGetListOfElements(driver, accountSections);
		return accountsSectionCnt.size()-1;
	}
	
	public List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountsSectionList = testUtill.doGetListOfElements(driver, accountSections);
		
		for(WebElement e : accountsSectionList) {
			String listElementName = e.getText();
			accountList.add(listElementName);
			System.out.println(listElementName);
		}
		
		return accountList;
	}
	

}
