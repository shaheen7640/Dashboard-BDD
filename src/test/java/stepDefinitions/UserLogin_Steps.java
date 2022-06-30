package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.pages.UserLogin;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserLogin_Steps {



	private UserLogin userLogin = new UserLogin(DriverFactory.getDriver());

	@Given("User on login page") public void user_on_login_page() {
		try {
			DriverFactory.getDriver().get("http://192.168.0.27:5000/");
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("-/-Make sure you are connected with vpn/Site is down or change the driver manager version in POM-/-");
			System.out.println("---------------------------------------------------------------------------------------------------");
		}
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String email, String password) {
		userLogin.enterUserName(email);
		userLogin.enterPassword(password);
	}

	@When("click on Login button")
	public void click_on_login_button() {
		userLogin.clickOnLogingBtn();


	}

	@Then("User should be landed on home page")
	public void user_should_be_landed_on_home_page() throws InterruptedException {
		
		Thread.sleep(5000);

		WebElement element=null;
		try {
			element = DriverFactory.getDriver().findElement(By.xpath("//a[@class='navbar-brand']"));
		} catch (NoSuchElementException e) {

			e.printStackTrace();
		}
		Assert.assertTrue("Incorrect Email/Password",element !=null);
    	System.out.println("User logged in");
	}
}
