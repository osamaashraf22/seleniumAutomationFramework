package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndJavaFaker extends TestBase
{
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;
	
	Faker fakeData=new Faker();
	String firstname=fakeData.name().firstName();
	String lastname=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.number().digits(8).toString();

	@Test(priority = 1)
	public void userCanRegistSccussfully() 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction(firstname,lastname ,email ,password);

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
