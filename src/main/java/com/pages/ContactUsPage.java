package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utill.JsExecutorUtill;
import com.utill.TestUtill;
import com.utill.WaitUtill;

public class ContactUsPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	private WaitUtill waitUtill = new WaitUtill();
	
	private By subjectHeading = By.id("id_contact");
	private By emailAddress = By.id("email");
	private By orderReference = By.xpath("//select[@name='id_order']");
	private By messageBox = By.id("message");
	private By sendBtn = By.id("submitMessage");
	private By successMessage = By.xpath("//p[@class='alert alert-success']");
	private By errorMessage = By.xpath("//p[@class='alert alert-danger]");
	private By productSection = By.xpath("//select[@name='id_product']");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillContactUsForm(String heading, String emailId, String orderReferenceId, String message) {
		testUtill.doSelectDropdownByText(testUtill.doFindElement(driver, subjectHeading), heading);
		testUtill.doClear(testUtill.doFindElement(driver, emailAddress));
		testUtill.doSendKey(testUtill.doFindElement(driver, emailAddress), emailId);
		JsExecutorUtill.scrollPageDown(driver);
		testUtill.doSelectDropdownByText(testUtill.doFindElement(driver, orderReference), orderReferenceId);
		testUtill.doSendKey(testUtill.doFindElement(driver, messageBox), message);
		
		List<WebElement> productSectionList = testUtill.doGetListOfElements(driver, productSection);
		
		for(int i=0;i<productSectionList.size();i++) {
			if(productSectionList.get(i).isDisplayed() == true) {
				testUtill.doSelectDropdown(productSectionList.get(i), "1");
				break;
			}
		}
	}
	
	public void clikOnSendMessageButton() {
		testUtill.doClick(testUtill.doFindElement(driver, sendBtn));
	}
	
	public String getMessageResponse() {
		return testUtill.getTextFromElement(testUtill.doFindElement(driver, successMessage));
	}

}
