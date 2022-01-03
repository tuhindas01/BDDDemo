package Parallel;

import java.util.List;
import java.util.Map;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.CartPage;
import com.pages.FadedSleeveTshirtsPage;
import com.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private HomePage homePage;
	private FadedSleeveTshirtsPage fadedSleeveTshirtsPage;
	private CartPage cartPage;

	@When("User navigates directly to order page")
	public void user_navigates_directly_to_order_page() {
		cartPage = accountsPage.clickOnAddToCartTab();
	}
	
	@When("User plces an order")
	public void user_plces_an_order() {
		cartPage.purchaseOrder();
	}
	
	@Then("User gets confirmed order details")
	public void user_gets_confirmed_order_details() {
		cartPage.printConfirmedOrderDetails();
	}
	
	@Given("User add a product to cart")
	public void user_add_a_product_to_cart(DataTable credTable) {
		List<Map<String,String>> crdList = credTable.asMaps();
		String strQuantity = crdList.get(0).get("quantity");
		String strSize = crdList.get(0).get("size");
		String strColor = crdList.get(0).get("color");
		
		homePage = accountsPage.navigateHomePage();
		fadedSleeveTshirtsPage = homePage.clickOnFadedShrotSleeveTshirt();
		fadedSleeveTshirtsPage.selectProductSpec(strQuantity, strSize, strColor);
		fadedSleeveTshirtsPage.clickOnAddtoCart();
		cartPage = fadedSleeveTshirtsPage.clickOnProceedToCheckout();
		
	}
}
