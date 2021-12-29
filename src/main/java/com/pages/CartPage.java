package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utill.TestUtill;

public class CartPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	
	private By productTableLocator = By.xpath("//*[@id='cart_summary']/tbody");
	
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

}
