package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	
HomePage homObject;
UserRegistrationPage registerObject;
	
@Given("^the user in the home page$")
public void the_user_in_the_home_page() 
{
	 homObject=new HomePage(driver);
	 homObject.openRegitrationPage();
}

@When("^I click on the register link$")
public void i_click_on_the_register_link()
{
  Assert.assertTrue(driver.getCurrentUrl().contains("register"));
}

/*
 * @When("^I enterd the user data$") public void i_enterd_the_user_data() {
 * registerObject=new UserRegistrationPage(driver);
 * registerObject.registrationFunction("o", "a", "osama@yahoo.com",
 * "123456789"); }
 */

@When("^I enterd \"([^\"]*)\" ,\"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
public void i_enterd(String firstname, String lastname, String email, String password)   
{
	 registerObject=new UserRegistrationPage(driver);
	 registerObject.registrationFunction(firstname,lastname, email,password); 
}


@Then("^the Registration is displayed Successfully$")
public void the_Registration_is_displayed_Successfully() 
{
	registerObject=new UserRegistrationPage(driver);
	Assert.assertTrue(registerObject.sccussMessage.getText().contains("Your registration completed"));
	registerObject.userLogOut();
}


}
