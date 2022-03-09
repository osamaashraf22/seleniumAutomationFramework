package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	ContactUsPage contactUsObject;
	HomePage homeObject;
	
	String yourName="osama";
	String email="osama@yahoo.com";
	String enquiry="problem";
	
	@Test
	public void canSendQuerySccussfully()
	{
		homeObject=new HomePage(driver);
		contactUsObject=new ContactUsPage(driver);
		homeObject.openContactUsPage();
		contactUsObject.contactUsQurey(yourName, email, enquiry);
		
		Assert.assertTrue(contactUsObject.messageSccuss.getText().contains("Your enquiry has been successfull"));
		
	}

}
