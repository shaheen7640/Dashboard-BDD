package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ChangePassword {
	
	private WebDriver driver;
	
	//Locators
		private By userName = By.name("username");
		private By password = By.name("password");
		private By loginbtn = By.xpath("//button[@type='submit' and text()='Log in']");
		private By myProfile_Menu = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(6)>a");
		private By changePassword_Menu = By.cssSelector("#navbarText > div > ul > li:nth-child(6)> ul > li:nth-child(4) > a");
		private By txtOldPassword = By.name("oldPassword");
		private By txtNewPassword = By.name("newPassword");
		private By txtConfirmPassword = By.name("confirmPassword");
		private By btnSubmit = By.cssSelector("button.btn.btn-primary.btn-lg");
		//private By homeLogo = By.cssSelector("a.navbar-brand");
		
		
	public ChangePassword(WebDriver driver) {
		
		
		this.driver=driver;
	}
	
	public void userLogin(String emailId,String pwd) throws InterruptedException {
		
		driver.findElement(userName).sendKeys(emailId);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		
		Thread.sleep(3000);		
		
	}
	
     public void clickOnMyprofile() {
    	 
    	 driver.findElement(myProfile_Menu).click();
     }
     public void clickOnChangePass() {
    	 
    	 driver.findElement(changePassword_Menu).click();
     }
     public void fillingPassword(String oldPass, String newPass, String cnfPass) {
    	 
    	 driver.findElement(txtOldPassword).sendKeys(oldPass);
    	 driver.findElement(txtNewPassword).sendKeys(newPass);
    	 driver.findElement(txtConfirmPassword).sendKeys(cnfPass);
    	 
     }
     public void clickOnSubmitButton() {
    	 
    	 driver.findElement(btnSubmit).click();
     }
}
