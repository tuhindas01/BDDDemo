package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utill.JsExecutorUtill;
import com.utill.TestUtill;

public class LoginPage {
	
	private WebDriver driver;
	private TestUtill testUtill = new TestUtill();
	
	//By Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPassword = By.xpath("//a[contains(text(),'Forgot your password?')]");
	private By createAccountButton = By.id("SubmitCreate");
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Methods
	public String getLoginPageTitle() {
		String title = testUtill.doGetTitle(driver);
		return title;
	}
	
	public boolean isForgotPasswordLink() {
		JsExecutorUtill.scrollPageDown(driver);
		boolean isForgotPwdLinkDispayed = testUtill.doCheckIsDisplayed(testUtill.doFindElement(driver, forgotPassword));
		return isForgotPwdLinkDispayed;
	}
	
	public boolean isCreateAccountButton() {
		boolean isCreateAccBtnDispayed = testUtill.doCheckIsDisplayed(testUtill.doFindElement(driver, createAccountButton));
		return isCreateAccBtnDispayed;
	}
	
	public void enterUserName(String username) {
		testUtill.doSendKey(testUtill.doFindElement(driver, emailId), username);
	}
	
	public void enterPassword(String pwd) {
		testUtill.doSendKey(testUtill.doFindElement(driver, password), pwd);
	}
	
	public void clickOnSignIn() {
		testUtill.doClick(testUtill.doFindElement(driver, signInButton));
	}
	
	public AccountsPage doLogin(String un, String pd) {
		testUtill.doSendKey(testUtill.doFindElement(driver, emailId), un);
		testUtill.doSendKey(testUtill.doFindElement(driver, password), pd);
		testUtill.doClick(testUtill.doFindElement(driver, signInButton));
		
		return new AccountsPage(driver);
	}

}
