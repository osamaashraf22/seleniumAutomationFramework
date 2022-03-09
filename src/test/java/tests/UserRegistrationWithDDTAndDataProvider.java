package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase
{
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;

	
	@DataProvider(name = "testData")
	public static Object [][] userData() 
	{
		return new Object [][]{{"osama" , "ashraf" , "osama12@yahoo.com" , "123456789"}
		,{"ahmed" , "ashraf" , "ahmed12@yahoo.com" , "123456789"}};
	}
	
	

	
	@Test(priority = 1,dataProvider = "testData")
	public void userCanRegistSccussfully(String fname , String lname , String email , String password) 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction(fname, lname, email, password);
		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
		
		registObject.userLogOut();
		
		loginOject=new UserLoginPage(driver);
		pageObject.openLoginPage();
		loginOject.LoginFunction(email, password);
		Assert.assertTrue(registObject.logOutLink.getText().contains("Log out"));
		
		registObject.userLogOut();
	}


}
