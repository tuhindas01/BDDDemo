package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utill.ActionUtill;
import com.utill.TestUtill;
import com.utill.WaitUtill;

public class HomePage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	private ActionUtill actionUtill = new ActionUtill();
	private WaitUtill waitUtill = new WaitUtill();
	
	private By womenTab = By.xpath("//a[@title='Women']");
	private By tShirtLink = By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//a[@title='T-shirts']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnTshirtLink() {
		waitUtill.pageLoadWait(driver, 40);
		actionUtill.doMouseHover(driver, testUtill.doFindElement(driver, womenTab));
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, tShirtLink), 30);
	}

}
