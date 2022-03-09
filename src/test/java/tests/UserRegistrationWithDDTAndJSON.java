package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndJSON extends TestBase {
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;

	@Test(priority = 1)
	public void userCanRegistSccussfully() throws FileNotFoundException, IOException, ParseException {
		
		JsonDataReader jsonReader=new JsonDataReader();
		jsonReader.jsonReader();
		
		
		pageObject = new HomePage(driver);
		registObject = new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction(jsonReader.firstname, jsonReader.lastname,jsonReader.email ,jsonReader.password );
		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
		
		registObject.userLogOut();
		
		loginOject = new UserLoginPage(driver);
		pageObject.openLoginPage();
		loginOject.LoginFunction(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registObject.logOutLink.getText().contains("Log out"));
		
		registObject.userLogOut();
	}
}
