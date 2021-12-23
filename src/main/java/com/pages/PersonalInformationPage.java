package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utill.TestUtill;

public class PersonalInformationPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	
	private By firstName = By.id("firstname");
	private By lastName = By.id("lastname");
	private By emailId = By.id("email");
	private By dobDay = By.id("days");
	private By dobMonth = By.id("months");
	private By dobYear = By.id("years");
	
	public PersonalInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> getPersonalInformation() {
		
		List<String> list = new ArrayList<String>();
		list.add(testUtill.getValuefromTextBox(testUtill.doFindElement(driver, firstName)));
		list.add(testUtill.getValuefromTextBox(testUtill.doFindElement(driver, lastName)));
		list.add(testUtill.getValuefromTextBox(testUtill.doFindElement(driver, emailId)));
		list.add(testUtill.getValueFromSelectDropdown(testUtill.doFindElement(driver, dobDay)));
		list.add(testUtill.getValueFromSelectDropdown(testUtill.doFindElement(driver, dobMonth)));
		list.add(testUtill.getValueFromSelectDropdown(testUtill.doFindElement(driver, dobYear)));
		
		return list;
		
	}

}
