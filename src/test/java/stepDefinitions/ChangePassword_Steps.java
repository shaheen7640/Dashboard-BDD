package stepDefinitions;


import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dashboard.util.Configuration_Reader;
import com.pages.ChangePassword;
import com.qa.Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePassword_Steps {
	
	ChangePassword changePass = new ChangePassword(DriverFactory.getDriver());
	private Configuration_Reader reader;
	Properties prop;
	
	@Given("User is on home page {string} and {string}")	
	public void user_is_on_home_page(String emailId,String pwd) throws InterruptedException {
		
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
		changePass.userLogin(emailId,pwd);
		 
		
	}

	@When("User clicks on my profile menu")
	public void user_clicks_on_my_profile_menu() {
		
		changePass.clickOnMyprofile();
	    
	}

	@When("User clicks on change password")
	public void user_clicks_on_change_password() {
	   
		changePass.clickOnChangePass();
	}

	@When("User enters {string} {string} {string}")
	public void user_enters(String oldPass, String newPass, String cnfPass) {
		
		changePass.fillingPassword(oldPass, newPass, cnfPass);
		
		
	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {
	  
		changePass.clickOnSubmitButton();
	}

	@Then("User should be able to see change password confirmation popup and password should be changed")
	public void user_should_be_able_to_see_change_password_confirmation_popup_and_password_should_be_changed() {
		
		//try { 
		     WebDriverWait alertWait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(30));
			if(alertWait.until(ExpectedConditions.alertIsPresent())==null) {
				System.out.println("No alert present"); 
			}
			else
			{
				Alert alert =  DriverFactory.getDriver().switchTo().alert();
				String alertText= alert.getText();
				System.out.println("Alert Text : "+alertText);
				alert.accept();
			} 
			 
		/*} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Kindly check if you are giving valid old/new password/confirm password."); 
		}*/
		
	}
	
}
