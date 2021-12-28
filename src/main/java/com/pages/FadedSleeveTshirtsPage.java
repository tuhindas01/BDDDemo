package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FadedSleeveTshirtsPage {
	
	private WebDriver driver;
	
	private By addToCartBtn = By.xpath("//p[@id='add_to_cart']//button[@name='Submit']");
	private By proceedToCheckOut = By.xpath("//a[@title='Proceed to checkout']");
	
	public FadedSleeveTshirtsPage(WebDriver driver) {
		this.driver = driver;
	}


}
