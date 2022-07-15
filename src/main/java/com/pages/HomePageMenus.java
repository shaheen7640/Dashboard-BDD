package com.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageMenus {

	private WebDriver driver;

	private By homePageLogo = By.cssSelector("a.navbar-brand>img");
	private By menu_Home = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(1)>a");
	private By menu_RMS = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(2)>a");
	private By menu_Ticket = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(3)>a");
	private By menu_Gallary = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(4)>a");
	private By menu_Policy = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(5)>a");
	private By menu_MyProfile = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(6)>a");
	private By menu_DSR = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(7)>a");
	private By menu_Admin = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(8)>a");
	private By menu_Logout = By.cssSelector("ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(9)>a");
	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginbtn = By.xpath("//button[@type='submit' and text()='Log in']");

	public HomePageMenus(WebDriver driver) {

		this.driver=driver;


	}
	public void userLogin(String emailId,String pwd) throws InterruptedException {

		driver.findElement(userName).sendKeys(emailId);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();

		Thread.sleep(3000);		

	}
	public boolean validate_HomeLogo() {

		return driver.findElement(homePageLogo).isDisplayed();
	}

	public String verify_menu_Home() {
		String txthome=driver.findElement(menu_Home).getText();
		System.out.println(txthome);
		return txthome;

	}
	public String verify_menu_RMS() {
		String txtRMS=driver.findElement(menu_RMS).getText();
		System.out.println(txtRMS);
		return txtRMS;

	}
	public String verify_menu_Ticket() {

		String txtTicket=driver.findElement(menu_Ticket).getText();
		System.out.println(txtTicket);
		return txtTicket;
	}
	public String verify_menu_Gallery() {

		String txtGallery=driver.findElement(menu_Gallary).getText();
		System.out.println(txtGallery);
		return txtGallery;
	}
	public String verify_menu_Policy() {

		String txtPolicy=driver.findElement(menu_Policy).getText();
		System.out.println(txtPolicy);
		return txtPolicy;
	}
	public String verify_menu_MyProfile() {

		String txtMyProfile=driver.findElement(menu_MyProfile).getText();
		System.out.println(txtMyProfile);
		return txtMyProfile;
	}
	public String verify_menu_DSR() {

		String txtDsr=driver.findElement(menu_DSR).getText();
		System.out.println(txtDsr);
		return txtDsr;
	}

	public String verify_menu_Admin() {

		String txtAdmin=driver.findElement(menu_Admin).getText();
		System.out.println(txtAdmin);
		return txtAdmin;
	}
	public String verify_menu_Logout() {


		String txtLogout=driver.findElement(menu_Logout).getText();
		System.out.println(txtLogout);
		return txtLogout;
	}

}

