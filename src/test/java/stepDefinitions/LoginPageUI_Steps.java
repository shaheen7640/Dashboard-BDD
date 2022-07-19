package stepDefinitions;

import java.util.Properties;

import org.junit.Assert;

import com.dashboard.util.Configuration_Reader;
import com.pages.LoginPage_UI;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageUI_Steps {
	
	private String loginPage_Title;
	
	private LoginPage_UI loginPageUI = new LoginPage_UI(DriverFactory.getDriver());
	private Configuration_Reader reader;
	Properties prop;
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		
		reader = new Configuration_Reader();
		prop = reader.init_Property();
		
		try {
			DriverFactory.getDriver().get(prop.getProperty("url"));
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("-/-Make sure you are connected with vpn/Site is down or change the driver manager version in POM-/-");
			System.out.println("---------------------------------------------------------------------------------------------------");
		}
		
	    
	}
	@When("Page is loaded")
	public void page_is_loaded() {
		 loginPage_Title = loginPageUI.loginPageTitle();
		
	}
	@Then("Login page title should be {string}")
	public void login_page_title_should_be(String expectedTitle) {
		
		System.out.println("Actual login page Title : "+loginPage_Title);
		Assert.assertTrue(loginPage_Title.contains(expectedTitle));
	}
	@Then("User should be able to see eamil textbox")
	public void user_should_be_able_to_see_eamil_textbox() {
	   
		Assert.assertTrue(loginPageUI.textBox_Email());
		System.out.println("Email textbox is displayed successfully");
	}

	@Then("User should be able to see password textbox")
	public void user_should_be_able_to_see_password_textbox() {
		
		Assert.assertTrue(loginPageUI.textBox_Password());	 
		System.out.println("Password textbox is displayed successfully");
	}
	@Then("User should be able to see a login button")
	public void User_should_be_able_to_see_a_login_button() {
		
		Assert.assertTrue(loginPageUI.btn_login());		   
	}
	@Then("User should be able to see {string} link")
	public void user_should_be_able_to_see_link(String forgotPassLink) {
		
		System.out.println("Actual Forgot password text : "+loginPageUI.forgotPassLink());
		Assert.assertTrue(loginPageUI.forgotPassLink().contains(forgotPassLink));
	   
	}
	
}
