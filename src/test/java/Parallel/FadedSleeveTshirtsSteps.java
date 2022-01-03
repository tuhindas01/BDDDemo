package Parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.CartPage;
import com.pages.FadedSleeveTshirtsPage;
import com.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FadedSleeveTshirtsSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private HomePage homePage;
	private FadedSleeveTshirtsPage fadedSleeveTshirtsPage;
	private CartPage cartPage;
	
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
	
	@When("User enters product specifications")
	public void user_enters_product_specifications(DataTable credTable) {
		List<Map<String,String>> crdList = credTable.asMaps();
		String strQuantity = crdList.get(0).get("quantity");
		String strSize = crdList.get(0).get("size");
		String strColor = crdList.get(0).get("color");
		
		fadedSleeveTshirtsPage.selectProductSpec(strQuantity, strSize, strColor);
	}

	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {
		fadedSleeveTshirtsPage.clickOnAddtoCart();
	}
	
	@When("User clicks on Proceed to Checkout")
	public void user_clicks_on_proceed_to_checkout() {
		cartPage = fadedSleeveTshirtsPage.clickOnProceedToCheckout();
	}


	@Then("The {string} should be added on the cart")
	public void the_should_be_added_on_the_cart(String product) {
		boolean status = false;
		
		System.out.println("Expected String: "+product);
		List<String> productDetails = cartPage.getProductDetailsFromTable();
		System.out.println(productDetails);
		
		for(int i=0;i<productDetails.size();i++) {
			if(productDetails.get(i).contains(product)) {
				status = true;
				break;
			}
		}
		
		Assert.assertTrue(status);
	}
	
	@Then("User clicks on continue shopping")
	public void user_clicks_on_continue_shopping() {
		cartPage.clickOnContinueShoppingButton();
	}


}
