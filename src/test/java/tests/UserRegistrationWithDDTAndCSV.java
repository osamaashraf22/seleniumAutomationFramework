package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndCSV extends TestBase
{
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;

	CSVReader reader;
	
	@Test(priority = 1)
	public void userCanRegistSccussfully() throws IOException, CsvValidationException 
	{
		// get path of csv file
		String csv_file=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.csv";
		reader=new CSVReader(new FileReader(csv_file));
		
		String [] csvCell;
		// while loop will be executed till the last value in csv file
		while ((csvCell =reader.readNext()) != null) 
		{
			String firstname=csvCell[0];
			String lastname=csvCell[1];
			String email=csvCell[2];
			String password=csvCell[3];pageObject=new HomePage(driver);
			registObject=new UserRegistrationPage(driver);
			pageObject.openRegitrationPage();
			registObject.registrationFunction(firstname, lastname, email, password);
			Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
			
			registObject.userLogOut();
			
			loginOject=new UserLoginPage(driver);
			pageObject.openLoginPage();
			loginOject.LoginFunction(email, password);
			Assert.assertTrue(registObject.logOutLink.getText().contains("Log out"));
			
			registObject.userLogOut();
		}
	}

}
