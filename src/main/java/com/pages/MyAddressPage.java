package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utill.JsExecutorUtill;
import com.utill.TestUtill;

public class MyAddressPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	
	private By addNewAddress = By.xpath("//a[@title='Add an address']");
	private By firstName = By.id("firstname");
	private By lastName = By.id("lastname");
	private By addressLine1 = By.id("address1");
	private By cityName = By.id("city");
	private By stateDropDown = By.id("id_state");
	private By zipCode = By.id("postcode");
	private By countryDropDown = By.id("id_country");
	private By homePhone = By.id("phone");
	private By mobliePhone = By.id("phone_mobile");
	private By addressType = By.id("alias");
	private By saveButton = By.id("submitAddress");
	private By newAddressDlt = By.xpath("//ul[@class='last_item alternate_item box']//a[@title='Delete']");
	//*[@id="center_column"]/div[1]/div/div[2]/ul/li[9]/a[2]/span
	
	public MyAddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnAddNewAddress() {
		testUtill.doClick(testUtill.doFindElement(driver, addNewAddress));
	}
	
	String[] addressArr = new String[10];
	public void enterAddressDetails(String[] addressArr) {
		testUtill.doClear(testUtill.doFindElement(driver, firstName));
		testUtill.doClear(testUtill.doFindElement(driver, lastName));
		testUtill.doClear(testUtill.doFindElement(driver, addressType));
		
		testUtill.doSendKey(testUtill.doFindElement(driver, firstName), addressArr[0]);
		testUtill.doSendKey(testUtill.doFindElement(driver, lastName), addressArr[1]);
		testUtill.doSendKey(testUtill.doFindElement(driver, addressLine1), addressArr[2]);
		testUtill.doSendKey(testUtill.doFindElement(driver, cityName), addressArr[3]);
		testUtill.doSelectDropdown(testUtill.doFindElement(driver, stateDropDown), addressArr[4]);
		testUtill.doSendKey(testUtill.doFindElement(driver, zipCode), addressArr[5]);
		testUtill.doSelectDropdown(testUtill.doFindElement(driver, countryDropDown), addressArr[6]);
		testUtill.doSendKey(testUtill.doFindElement(driver, homePhone), addressArr[7]);
		testUtill.doSendKey(testUtill.doFindElement(driver, mobliePhone), addressArr[8]);
		testUtill.doSendKey(testUtill.doFindElement(driver, addressType), addressArr[9]);
	}
	
	public void addressSave() {
		testUtill.doClick(testUtill.doFindElement(driver, saveButton));
	}
	
	public String getNewAddressSectionHeader(String header) {
		WebElement newAddressEle =  testUtill.doFindElement(driver, By.xpath("//h3[@class='page-subheading' and contains(text(),'"+header+"')]"));
		System.out.println("Actual Header: " +newAddressEle.getText());
		return newAddressEle.getText();
	}
	
	public void deleteNewAddress() {
		testUtill.doClick(testUtill.doFindElement(driver, newAddressDlt));
		driver.switchTo().alert().accept();
	}

}
