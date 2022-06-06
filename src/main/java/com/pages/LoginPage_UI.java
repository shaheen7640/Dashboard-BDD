package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_UI {

	private WebDriver driver;

	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginbtn = By.xpath("//button[@type='submit' and text()='Log in']");
	private By forgot_password_link = By.linkText("Forgot your password?");

	public LoginPage_UI(WebDriver driver) {

		this.driver=driver;

	}
	public String loginPageTitle() {

		return driver.getTitle();
	}
	public boolean textBox_Email() {

		return driver.findElement(userName).isDisplayed();
	}
	public boolean textBox_Password() {

		return driver.findElement(password).isDisplayed();
	}
	public boolean btn_login() {

		return driver.findElement(loginbtn).isDisplayed();
	}
	public String forgotPassLink() {

		return driver.findElement(forgot_password_link).getText();
	}
}
