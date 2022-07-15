package stepDefinitions;

//import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.pages.HomePageMenus;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageMenus_Steps {

	HomePageMenus homePage_Menus = new HomePageMenus(DriverFactory.getDriver());
	
	//SoftAssertions softAssert =null;
	 
	@Given("User logged in {string} {string}")
	public void user_logged_in(String emailId, String pwd) throws InterruptedException {

		DriverFactory.getDriver().get("http://192.168.0.27:5000/");
		homePage_Menus.userLogin(emailId,pwd);
	}

	@When("User is on home page")
	public void user_is_on_home_page() {
		

		WebElement element = null;
		
		try {
			element = DriverFactory.getDriver().findElement(By.cssSelector("a.navbar-brand>img"));
		
		} catch (NoSuchElementException e) {
			
			e.printStackTrace();
		}
		
		Assert.assertTrue("Incorrect Email/Password",element !=null);//homePage_Menus.validate_HomeLogo());
		System.out.println("Logo Displayed");

	}

	@Then("all menus should be present")
	public void all_menus_should_be_present() {
		
		//softAssert= new SoftAssertions();
		
		homePage_Menus.verify_menu_Home();
		Assert.assertEquals("Menu HOME not visible", "HOME", homePage_Menus.verify_menu_Home());		
		//softAssert.fail("Menu HOME not visible", "HOME1", homePage_Menus.verify_menu_Home());
		
		homePage_Menus.verify_menu_RMS();
		Assert.assertEquals("Menu RMS not visible", "RMS", homePage_Menus.verify_menu_RMS());
		//softAssert.fail("Menu RMS not visible", "RMS", homePage_Menus.verify_menu_RMS());
		
		homePage_Menus.verify_menu_Ticket();
		Assert.assertEquals("Menu TICKET not visible", "TICKET", homePage_Menus.verify_menu_Ticket());
		//softAssert.fail("Menu TICKET not visible", "TICKET", homePage_Menus.verify_menu_Ticket());
		
		homePage_Menus.verify_menu_Gallery();
		Assert.assertEquals("Menu GALLERY not visible", "GALLERY", homePage_Menus.verify_menu_Gallery());
		//softAssert.fail("Menu GALLERY not visible", "GALLERY", homePage_Menus.verify_menu_Gallery());
		
		homePage_Menus.verify_menu_Policy();
		Assert.assertEquals("Menu POLICY not visible", "POLICY", homePage_Menus.verify_menu_Policy());
		//softAssert.fail("Menu POLICY not visible", "POLICY", homePage_Menus.verify_menu_Policy());
		
		homePage_Menus.verify_menu_MyProfile();
		Assert.assertEquals("Menu MY PROFILE not visible", "MY PROFILE", homePage_Menus.verify_menu_MyProfile());
		//softAssert.fail("Menu MY PROFILE not visible", "MY PROFILE", homePage_Menus.verify_menu_MyProfile());
		
		homePage_Menus.verify_menu_DSR();
		Assert.assertEquals("Menu DSR not visible", "DSR", homePage_Menus.verify_menu_DSR());
		//softAssert.fail("Menu DSR not visible", "DSR", homePage_Menus.verify_menu_DSR());
		
		homePage_Menus.verify_menu_Admin();
		Assert.assertEquals("Menu ADMIN not visible", "ADMIN", homePage_Menus.verify_menu_Admin());
		//softAssert.fail("Menu ADMIN not visible", "ADMIN", homePage_Menus.verify_menu_Admin());
		
		homePage_Menus.verify_menu_Logout();
		Assert.assertEquals("Menu LOGOUT not visible", "LOGOUT", homePage_Menus.verify_menu_Logout());
		//softAssert.fail("Menu LOGOUT not visible", "LOGOUT", homePage_Menus.verify_menu_Logout());
		
       //softAssert.assertAll();
	}


}
