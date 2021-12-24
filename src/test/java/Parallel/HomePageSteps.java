package Parallel;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private HomePage homePage;
	
	@Given("User navigates to Home Page")
	public void user_navigates_to_home_page() {
		homePage = accountsPage.navigateHomePage();
	}
	
	@When("User clicks on Tshirt link")
	public void user_clicks_on_tshirt_link() {
		homePage.clickOnTshirtLink();
	}

}
