package com.pages;

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
	
	public boolean validateProductNameFromTable(String productName) {
		boolean status = false;
		System.out.println("Expected: "+productName);
		WebElement productTable = testUtill.doFindElement(driver, productTableLocator);
		
		List<WebElement> productRows = productTable.findElements(By.tagName("tr"));
		
		for(int i=0;i<productRows.size();i++) {
			List<WebElement> productCols = productRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<productCols.size();j++) {
				String cellText = productCols.get(j).getText();	
				System.out.println(productCols.get(j).getText());
				if(cellText.equals(productName)) {
					System.out.println("Actual: "+cellText);
					status = true;
				}
			}
		}
		
		return status;
	}

}
