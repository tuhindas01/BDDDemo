package Parallel;

import java.util.List;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.MyAddressPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyAddressPageSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private MyAddressPage myAddressPage;
	
	@Given("User navigates to Address Page")
	public void user_navigates_to_address_page() {
		myAddressPage = accountsPage.clickOnMyAddress();
	}
	
	@When("User clicks on Add New Address")
	public void user_clicks_on_add_new_address() {
		myAddressPage.clickOnAddNewAddress();
	}
	
	@When("User enters address details")
	public void user_enters_address_details(DataTable addressTable) throws InterruptedException {
		Thread.sleep(3000);
		List<String> addressDataTable = addressTable.asList();
	
		String[] strAddressTableArr = new String[addressDataTable.size()];
		 
        for (int i = 0; i < addressDataTable.size(); i++) {
        	strAddressTableArr[i] = addressDataTable.get(i);
        }
		
		myAddressPage.enterAddressDetails(strAddressTableArr);
		Thread.sleep(6000);
	}

}
