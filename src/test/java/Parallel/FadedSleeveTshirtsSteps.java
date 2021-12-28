package Parallel;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.FadedSleeveTshirtsPage;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FadedSleeveTshirtsSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private HomePage homePage;
	private FadedSleeveTshirtsPage fadedSleeveTshirtsPage;
	
	private static String productPrice;
	
	@Given("User navigates to Faded Sleeve Tshrit Page")
	public void user_navigates_to_faded_sleeve_tshrit_page() {
		homePage = accountsPage.navigateHomePage();
		fadedSleeveTshirtsPage = homePage.clickOnFadedShrotSleeveTshirt();
	}
	
	@When("User gets the product price")
	public void user_gets_the_product_price() {
		productPrice = fadedSleeveTshirtsPage.getProductPrice();
	}
	
	@Then("The price should be {string}")
	public void the_price_should_be(String expectedPrice) {
		System.out.println("Expected price: "+ expectedPrice +" and Actual price: " +productPrice);
		Assert.assertTrue(expectedPrice.equals(productPrice));
	}

}
