package com.utill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtill {
	
	public void waitClickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		
	}
	
	public void waitSendKeys(WebDriver driver, WebElement locator, String text, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeSelected(locator));
		locator.sendKeys(text);
		
	}
	
	public void waitPresenceOfElement(WebDriver driver, By locator, int timeout) {
		 new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public void pageLoadWait(WebDriver driver, int timeout) {
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}
	

}