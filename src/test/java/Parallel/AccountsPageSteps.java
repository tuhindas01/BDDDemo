package Parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String,String>> crdList = credTable.asMaps();
		
		String userName = crdList.get(0).get("username");
		String passWord = crdList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, passWord);
	}
	
	@Given("User is on Accounts Page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page Title is " +title);
	}
	
	@Then("User gets Account Section Details")
	public void user_gets_account_section_details(DataTable sectionTable) {
		List<String> expectedAccountSectionList = sectionTable.asList();
		System.out.println("Expected Account Section List : " +expectedAccountSectionList);
		
		List<String> actualAccountSectionList = accountsPage.getAccountSectionList();
		System.out.println("Actual Account Section List : " +actualAccountSectionList);
		
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}
	
	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(int expectedCount) {
		int actualCount = accountsPage.getAccountSectionCount();
		System.out.println("Actual "+actualCount);
		Assert.assertTrue(expectedCount == actualCount);
	}
	
}
