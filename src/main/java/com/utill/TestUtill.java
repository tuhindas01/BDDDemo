package com.utill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestUtill {
	
	public void doSendKey(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void doClick(WebElement element) {
		element.click();
	}

}
