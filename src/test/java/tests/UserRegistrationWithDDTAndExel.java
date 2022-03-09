package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndExel extends TestBase
{
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;

	@DataProvider(name = "ExcelData")
	public Object [] [] userRegisterDta() throws IOException
	{
		// get data from excel reader class
		ExcelReader excelReader=new ExcelReader();
		return excelReader.getExcelData();
	}
	
	@Test(priority = 1,dataProvider = "ExcelData")
	public void userCanRegistSccussfully(String fname , String lname , String email , String password) 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction(fname,lname ,email ,password );
		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
		
		registObject.userLogOut();
		
		loginOject=new UserLoginPage(driver);
		pageObject.openLoginPage();
		loginOject.LoginFunction(email, password);
		Assert.assertTrue(registObject.logOutLink.getText().contains("Log out"));
		registObject.userLogOut();
		
	}

}
