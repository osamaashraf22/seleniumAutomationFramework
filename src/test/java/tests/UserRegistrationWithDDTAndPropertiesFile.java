package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase
{
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;

	String firstname=LoadProperties.userData.getProperty("firstname");
	String lastname=LoadProperties.userData.getProperty("lastname");
	String email=LoadProperties.userData.getProperty("email");
	String password=LoadProperties.userData.getProperty("password");
	
	
	@Test(priority = 1)
	public void userCanRegistSccussfully() 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction(firstname, lastname, email, password);

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
		loginOject.LoginFunction(email, password);
		
		Assert.assertTrue(registObject.logOutLink.getText().contains("Log out"));
	}

}
