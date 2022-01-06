package Parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.ContactUsPage;
import com.utill.ExcelReaderUtill;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactUsPageSteps {
	
	private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
	private ContactUsPage contactUsPage;
	
	@Given("User navigates to Contact Us Page")
	public void user_navigates_to_contact_us_page() {
		contactUsPage = accountsPage.clickOnContactUsLink();
	}
	
	@When("User fills the form from the given sheetname ContactUs and rownumber {int}")
	public void user_fills_the_form_from_the_given_sheetname_contact_us_and_rownumber(Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReaderUtill reader = new ExcelReaderUtill();
		List<Map<String,String>> testData = reader.getData(".\\src\\test\\resources\\InputSheets\\contactUsDetails.xlsx", "ContactUs");
		
		String heading = testData.get(rowNumber).get("subjectheading");
		String emailId = testData.get(rowNumber).get("email");
		String orderId = testData.get(rowNumber).get("orderref");
		String msg = testData.get(rowNumber).get("message");
		
		contactUsPage.fillContactUsForm(heading, emailId, orderId, msg);
	}
	
	@When("User clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clikOnSendMessageButton();
	}
	
	@Then("It shows successfull message {string}")
	public void it_shows_successfull_message(String expectedSuccessMessage) {
		String successMessage = contactUsPage.getMessageResponse();
		Assert.assertEquals(successMessage, expectedSuccessMessage);
		
	   
	}

}
