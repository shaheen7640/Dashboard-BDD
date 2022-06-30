package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Shaheen Akhtar
 *This class is responsible to launches the chrome browser.
 */

public class DriverFactory {
	
	public WebDriver driver;
	//This will helpful for parallel testing along with reports and ThreadLocal provides get and set methods.
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	
	public WebDriver initDriver() {
		
			// this line is same as driver = new ChromeDriver 
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
		
		
		return getDriver();
	}
	
	//it will be used to get the driver from ThreadLocal and synchronized all the instances of driver. 
    public static synchronized WebDriver getDriver() {
    	
    	return tldriver.get();
    }
}
