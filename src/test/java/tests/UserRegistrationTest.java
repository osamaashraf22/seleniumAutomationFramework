package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;

	@Test(priority = 1)
	public void userCanRegistSccussfully() 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction("osama", "ashraf", "osama2351@yahoo.com", "123456789");

		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
	}

	@Test (dependsOnMethods = {"userCanRegistSccussfully"})
	public void userCanLogOutSuccufully() 
	{
		registObject.userLogOut();

	}

	@Test (dependsOnMethods = {"userCanLogOutSuccufully"})
	public void userCanLoginSccuffully() 
	{
		loginOject=new UserLoginPage(driver);
		pageObject.openLoginPage();
		loginOject.LoginFunction("osama2351@yahoo.com", "123456789");
		
		Assert.assertTrue(registObject.logOutLink.getText().contains("Log out"));
	}

}
