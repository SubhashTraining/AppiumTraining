package StepsDefinition;

import org.openqa.selenium.WebDriver;

import Drivers.DriverClass;
import Managers.ObjectManager;
import PageFiles.LoginPage;
import Readers.JSONDataReader;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {

LoginPage loginpage;
WebDriver driver;
JSONDataReader reader;
	
	@Given("^when the users opens browser and enteres the url of the application$")
	public void when_the_users_opens_browser_and_enteres_the_url_of_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		reader=JSONDataReader.getInstanceOf();
	    driver=DriverClass.getInstanceOf().getDriver();
		loginpage=ObjectManager.getInstanceOf().getLoginObject(driver);
		//loginpage.enterURL();
		driver.close();
		driver.quit();
		
	}
	
	@Given("^chooses the login button$")
	public void chooses_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Users sign ups for the first time into the applications by entering the form details$")
	public void users_sign_ups_for_the_first_time_into_the_applications_by_entering_the_form_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Users successfullys sign up$")
	public void users_successfullys_sign_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^should be logged into the application$")
	public void should_be_logged_into_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
