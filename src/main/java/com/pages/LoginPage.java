package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//By Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPassword = By.linkText("Forgot your password?");
	private By createAccountButton = By.id("SubmitCreate");
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Methods
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean isForgotPasswordLink() {
		boolean isForgotPwdLinkDispayed = driver.findElement(forgotPassword).isDisplayed();
		return isForgotPwdLinkDispayed;
	}
	
	public boolean isCreateAccountButton() {
		boolean isCreateAccBtnDispayed = driver.findElement(createAccountButton).isDisplayed();
		return isCreateAccBtnDispayed;
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnSignIn() {
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String un, String pd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pd);
		driver.findElement(signInButton).click();
		
		return new AccountsPage(driver);
	}

}
