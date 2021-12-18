package Parallel;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	@Given("User is on Homepage")
	public void user_is_on_Homepage() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication");
	}
	
	@When("User gets title on Homepage")
	public void user_gets_the_title_on_Homepage(){
		title = loginPage.getLoginPageTitle();
		System.out.println("Login page of title is " +title);
	}
	
	@Then("Title should be {string}")
	public void title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}
	
	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		boolean forgotPassword = loginPage.isForgotPasswordLink();
		Assert.assertTrue(forgotPassword);
	}
	
	@Then("Create an Account button should be displayed")
	public void create_an_account_button_should_be_displayed() {
		boolean createAccount = loginPage.isCreateAccountButton();
		Assert.assertTrue(createAccount);
	}

}
