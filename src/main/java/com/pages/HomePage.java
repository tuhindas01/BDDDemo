package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	private By blouseLink = By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//a[@title='Blouses']");
	private By sectionCloth = By.xpath("//*[@id='homefeatured']");
	private By fadedShrotSleeveTshirt = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public TshirtPage clickOnTshirtLink() {
		waitUtill.pageLoadWait(driver, 40);
		actionUtill.doMouseHover(driver, testUtill.doFindElement(driver, womenTab));
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, tShirtLink), 30);
		
		return new TshirtPage(driver);
	}
	
	public BlousePage clickOnBlouseLink() {
		waitUtill.pageLoadWait(driver, 40);
		actionUtill.doMouseHover(driver, testUtill.doFindElement(driver, womenTab));
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, blouseLink), 30);
		
		return new BlousePage(driver);
	}
	
	public List<String> getClothingSectionList() {
		List<String> clothingList = new ArrayList<>();
		List<WebElement> clothingListSectionList = testUtill.doGetListOfElements(driver, sectionCloth);
		
		for(WebElement e : clothingListSectionList) {
			String listElementName = e.getText();
			clothingList.add(listElementName);
			System.out.println(listElementName);
		}
		
		return clothingList;
	}
	
	public FadedSleeveTshirtsPage clickOnFadedShrotSleeveTshirt() {
		waitUtill.waitClickOn(driver, testUtill.doFindElement(driver, fadedShrotSleeveTshirt), 30);
		
		return new FadedSleeveTshirtsPage(driver);
	}

}
