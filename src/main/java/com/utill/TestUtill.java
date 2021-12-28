package com.utill;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestUtill {
	
	public WebElement doFindElement(WebDriver driver,By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public List<WebElement> doGetListOfElements(WebDriver driver,By locator){
		List<WebElement> list = driver.findElements(locator);
		return list;
	}
	
	public void doSendKey(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void doClick(WebElement element) {
		element.click();
	}
	
	public void doClear(WebElement element) {
		element.clear();
	}
	
	
	public boolean doCheckIsDisplayed(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}
	
	public String doGetTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}
	
	public void doSelectDropdown(WebElement element,String value) {
		Select selectByValue = new Select(element);
		selectByValue.selectByValue(value);
	}
	
	public void doSelectDropdownByText(WebElement element,String text) {
		Select selectByText= new Select(element);
		selectByText.selectByVisibleText(text);
	}
	
	public String getValuefromTextBox(WebElement element) {
		return element.getAttribute("value");
	}
	
	public String getValueFromSelectDropdown(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getAttribute("value");
	}

}
