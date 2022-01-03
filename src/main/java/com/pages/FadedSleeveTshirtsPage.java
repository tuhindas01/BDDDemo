package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utill.TestUtill;
import com.utill.WaitUtill;

public class FadedSleeveTshirtsPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	private WaitUtill waitUtill = new WaitUtill();
	
	private By addToCartBtn = By.xpath("//p[@id='add_to_cart']//button[@name='Submit']");
	private By proceedToCheckOut = By.xpath("//a[@title='Proceed to checkout']");
	private By displayPrice = By.id("our_price_display");
	private By quantityBox = By.id("quantity_wanted");
	private By sizeDropDown = By.id("group_1");
	

	public FadedSleeveTshirtsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductPrice() {
		return testUtill.doFindElement(driver, displayPrice).getText();
	}
	
	public void selectProductSpec(String quatity, String size, String color) {
		testUtill.doClear(testUtill.doFindElement(driver, quantityBox));
		testUtill.doSendKey(testUtill.doFindElement(driver, quantityBox), quatity);
		testUtill.doSelectDropdownByText(testUtill.doFindElement(driver, sizeDropDown), size);
		testUtill.doClick(testUtill.doFindElement(driver, By.xpath("//a[@name='"+color+"']")));
	}
	
	public void clickOnAddtoCart() {
		testUtill.doClick(testUtill.doFindElement(driver, addToCartBtn));
	}
	
	public CartPage clickOnProceedToCheckout() {
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, proceedToCheckOut), 30);
		
		return new CartPage(driver);
	}

}
