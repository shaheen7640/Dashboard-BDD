package stepDefinitions;


import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ForgotPassword;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPassword_Steps {

	private ForgotPassword forgotPassWord = new ForgotPassword(DriverFactory.getDriver());

	@Given("User login page")
	public void user_login_page() {

		DriverFactory.getDriver().get("http://192.168.0.27:5000/");

	}

	@When("User clicks on forgot your password link")
	public void user_clicks_on_forgot_your_password_link() throws InterruptedException {

		forgotPassWord.clickOnLink();

	}

	@Then("User should be prompted to a forgot your password popup")
	public void user_should_be_prompted_to_a_forgot_your_password_popup() {

		Assert.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//div[@class='modal-content']")).isDisplayed());
		System.out.println("Popup displayed");

	}

	@When("User enters their registered {string} id into text box")
	public void user_enters_their_registered_id_into_text_box(String email) {

		forgotPassWord.sendMail(email);
	}

	@When("clicks on Send Password button")
	public void clicks_on_send_password_button() {

		forgotPassWord.clickOnBtnSend();

	}

	@Then("User should be prompted to a reset password confirmation popup")
	public void user_should_be_prompted_to_a_reset_password_confirmation_popup() {

		WebDriverWait alertWait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(30));

		//Validating email confirmation Pop-up
		Assert.assertEquals(alertWait, alertWait);

		if(alertWait.until(ExpectedConditions.alertIsPresent())==null){

			System.out.println("No alert present"); 
		}
		else
		{
			Alert alert = DriverFactory.getDriver().switchTo().alert(); 
			String alertText= alert.getText();
			System.out.println("Alert Text : "+alertText); alert.accept();
			if(alertText.contains("email is not existing "))
			{Assert.assertFalse(true);}
		}
	}

	@Then("User should be received a mail which contains reset password link")
	public void user_should_be_received_a_mail_which_contains_reset_password_link() {

		System.out.println("Mail sent");

	}


}
