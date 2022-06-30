package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
	
	private WebDriver driver;
	
	private By forgotPassword = By.linkText("Forgot your password?");
	private By registerdEmail = By.name("email");
	private By btnSend = By.className("btn-block-sm");
	
	public ForgotPassword(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void clickOnLink() throws InterruptedException {
		
		driver.findElement(forgotPassword).click();
		Thread.sleep(3000);
	}
	public void sendMail(String sendMail) {
		
		driver.findElement(registerdEmail).sendKeys(sendMail);
	}
	public void clickOnBtnSend() {
		
		driver.findElement(btnSend).click();
	}
	public void wait_for_alert() {

	

}
}