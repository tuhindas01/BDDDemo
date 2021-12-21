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
	private By footerLinks = By.xpath("//section[@id='block_various_links_footer']");
	
	
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
	
	public List<String> getFooterLinkList(){
		List<String> footerLinksList = new ArrayList<>();
		List<WebElement> footerLinkElementList = testUtill.doGetListOfElements(driver, footerLinks);
		
		for(WebElement r : footerLinkElementList) {
			String footerLinkName = r.getText();
			footerLinksList.add(footerLinkName);
			System.out.println(footerLinkName);
		}
		
		return footerLinksList;
	}
	
	public MyAddressPage clickOnMyAddress() {
		List<WebElement> accountsSectionList = testUtill.doGetListOfElements(driver, accountSections);
		
		for(WebElement g : accountsSectionList) {
			if(g.getText().equals("MY ADDRESSES")) {
				g.click();
				break;
			}
		}
		
		return new MyAddressPage(driver);
	}

}
