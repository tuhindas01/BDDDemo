package com.utill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtill {
	
	public WebElement doFindElement(WebDriver driver,By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public void doSendKey(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void doClick(WebElement element) {
		element.click();
	}
	
	public boolean doCheckIsDisplayed(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}
	
	public String doGetTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

}
