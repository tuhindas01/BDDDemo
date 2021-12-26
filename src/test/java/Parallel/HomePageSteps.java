package Parallel;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
	

	@When("User clicks on Blouses link")
	public void user_clicks_on_blouses_link() {
		homePage.clickOnBlouseLink();
	}
	
	@Then("Print all the clothing details")
	public void print_all_the_clothing_details() {
		List<String> list = homePage.getClothingSectionList();
	}
	
	@Then("Click on the price {string}")
	public void click_on_the_price(String expectedPrice) {
		homePage.clickOnItemByPrice(expectedPrice);
	}
	

}
