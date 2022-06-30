package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLogin {
	
	private WebDriver driver;
	//Locators
	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginbtn = By.xpath("//button[@type='submit' and text()='Log in']");
	
	//Constructor
	public UserLogin(WebDriver driver) {
		
		this.driver=driver;
	}
	//Actions
    public void enterUserName(String emailId) {
    	
    	driver.findElement(userName).sendKeys(emailId);
    	
    }
    public void enterPassword(String pwd) {
    	
    	driver.findElement(password).sendKeys(pwd);
    }
    public void clickOnLogingBtn() {
    	
    	driver.findElement(loginbtn).click();
    }

}
