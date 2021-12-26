package com.utill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtill {
	
	public void doMouseHover(WebDriver driver, WebElement element) {
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(element).build().perform();
	}

}
 