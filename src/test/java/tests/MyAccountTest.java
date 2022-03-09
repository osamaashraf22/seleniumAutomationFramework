package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccountPage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;
	MyAccountPage myAccount;
	
	String firstName="osama";
	String lastName="ashraf";
	String email="osama18@yahoo.com";
	String oldPassword="123456789";
	String newPassword="12345678";
	
	@Test(priority = 1)
	public void userCanRegistSccussfully() 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction(firstName,lastName,email , oldPassword);

		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegistSccussfully"})
	public void userCanChangeAccountPasswordSccussfully() 
	{
		myAccount=new MyAccountPage(driver);
		registObject=new UserRegistrationPage(driver);
		registObject.OpenMyAccountPage();
		myAccount.openChangePasswordPage();
		myAccount.userChangeAccount(oldPassword, newPassword);
		
		Assert.assertTrue(myAccount.sccussMessageChangePassword.getText().contains("Password was changed"));
		myAccount.closeMessageSccuss();
	}
	
	@Test (dependsOnMethods = {"userCanChangeAccountPasswordSccussfully"})
	public void userCanLogOutSuccufully() 
	{
		registObject.userLogOut();

	}

	@Test (dependsOnMethods = {"userCanLogOutSuccufully"})
	public void userCanLoginSccuffully() 
	{
		loginOject=new UserLoginPage(driver);
		pageObject.openLoginPage();
		loginOject.LoginFunction(email, newPassword);
		
		Assert.assertTrue(registObject.logOutLink.getText().contains("Log out"));
	}

}
