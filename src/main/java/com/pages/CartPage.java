package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utill.JsExecutorUtill;
import com.utill.TestUtill;
import com.utill.WaitUtill;

public class CartPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	private WaitUtill waitUtill = new WaitUtill();
	
	private By productTableLocator = By.xpath("//*[@id='cart_summary']/tbody");
	private By continueShopping = By.xpath("//a[@title='Continue shopping']");
	private By proceedToChkOutBtn = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
	private By proceedToChkOutAddressBtn = By.xpath("//button[@name='processAddress']");
	private By iAgreeCheckBx = By.xpath("//input[@id='cgv']");
	private By proceedToChkOutCarrierBtn = By.xpath("//button[@name='processCarrier']");
	private By payByCheckLink = By.xpath("//a[@title='Pay by check.']");
	private By confirmOrderBtn = By.xpath("//button[@class='button btn btn-default button-medium']");
	private By orderConfirmationBox = By.xpath("//div[@class='box order-confirmation']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> getProductDetailsFromTable() {
		WebElement productTable = testUtill.doFindElement(driver, productTableLocator);
		
		List<WebElement> productRows = productTable.findElements(By.tagName("tr"));
		List<String> list = new ArrayList<String>();
		
		for(int i=0;i<productRows.size();i++) {
			List<WebElement> productCols = productRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<productCols.size();j++) {
				String cellText = productCols.get(j).getText();	
				System.out.println(productCols.get(j).getText());
				list.add(cellText);
			}
		}
		
		return list;
	}
	
	public FadedSleeveTshirtsPage clickOnContinueShoppingButton() {
		testUtill.doClick(testUtill.doFindElement(driver, continueShopping));
		
		return new FadedSleeveTshirtsPage(driver);
	}
	
	public void purchaseOrder() {
		JsExecutorUtill.scrollPageDown(driver);
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, proceedToChkOutBtn), 30);
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, proceedToChkOutAddressBtn), 30);
		JsExecutorUtill.scrollPageDown(driver);
		testUtill.doClick(testUtill.doFindElement(driver, iAgreeCheckBx));
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, proceedToChkOutCarrierBtn), 30);
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, payByCheckLink), 30);
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, confirmOrderBtn), 30);
	}
	
	public void printConfirmedOrderDetails() {
		List<WebElement> orderDetails = testUtill.doGetListOfElements(driver, orderConfirmationBox);
		
		for(int i=0;i<orderDetails.size();i++) {
			System.out.println(orderDetails.get(i).getText());
		}
	}
	

}
