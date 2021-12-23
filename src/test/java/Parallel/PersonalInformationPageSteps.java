package Parallel;

import java.util.List;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.PersonalInformationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalInformationPageSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private PersonalInformationPage personalInformationPage;
	
	@Given("User navigates to Personal Information Page")
	public void user_navigates_to_personal_information_page() {
		personalInformationPage = accountsPage.clickOnPersonalInformation();
	}
	
	@Then("User validates Personal Information details")
	public void user_validates_Personal_Information_details(DataTable infoTable) {
		List<String> expectedDetails = infoTable.asList();
		System.out.println("Expected Details :"+expectedDetails);
		
		List<String> actualDetails = personalInformationPage.getPersonalInformation();
		System.out.println("Actual Details: "+actualDetails);
		
		Assert.assertTrue(actualDetails.equals(expectedDetails));
	}

}
