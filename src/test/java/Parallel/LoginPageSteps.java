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
	
	@When("User gets tiltle on Homepage")
	public void user_gets_the_title_on_Homepage(){
		title = loginPage.getLoginPageTitle();
		System.out.println("Login page of title is " +title);
	}
	
	@Then("Title should be {string}")
	public void title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

}
