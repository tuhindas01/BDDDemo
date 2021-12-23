package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver initDriver(String browser) {
		
		System.out.println("The Browser value is " +browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		
		else {
			System.out.println("Please pass the correct browser value: " +browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

}
 