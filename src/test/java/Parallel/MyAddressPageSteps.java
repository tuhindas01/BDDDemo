package Parallel;

import java.util.List;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.MyAddressPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class MyAddressPageSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private MyAddressPage myAddressPage;
	
	private static String header;
	
	@Given("User navigates to Address Page")
	public void user_navigates_to_address_page() {
		myAddressPage = accountsPage.clickOnMyAddress();
	}
	
	@When("User clicks on Add New Address")
	public void user_clicks_on_add_new_address() {
		myAddressPage.clickOnAddNewAddress();
	}
	
	@When("User enters address details")
	public void user_enters_address_details(DataTable addressTable){
		List<String> addressDataTable = addressTable.asList();
	
		String[] strAddressTableArr = new String[addressDataTable.size()];
		 
        for (int i = 0; i < addressDataTable.size(); i++) {
        	strAddressTableArr[i] = addressDataTable.get(i);
        }
		
		myAddressPage.enterAddressDetails(strAddressTableArr);
	}
	
	@When("User clicks on Save button")
	public void user_clicks_on_save_button() {
		myAddressPage.addressSave();
	}
	
	@Then("New Address section header should be {string}")
	public void new_address_section_header_should_be(String expectedHeader) {
		System.out.println("Expected Header :"+expectedHeader);
		String actualHeader = myAddressPage.getNewAddressSectionHeader(expectedHeader);
		Assert.assertEquals(actualHeader, expectedHeader.toUpperCase());
		
		myAddressPage.deleteNewAddress();
	}
	
	@Then("User deletes the new address")
	public void user_deletes_the_new_address() {
		myAddressPage.deleteNewAddress();
	}

}
