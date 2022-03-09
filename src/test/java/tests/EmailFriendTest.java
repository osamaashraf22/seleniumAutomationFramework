package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	//1-registration
	//2- search for product
	//3- send email friend
	//4-user logout
	
	
	EmailFriendPage emailFriendObject;
	HomePage pageObject;
	UserRegistrationPage registObject;
	
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	String productName="Apple MacBook Pro 13-inch";
	
	String emailFriend="test@yahoo.com";
	String personalMessage="producto is very goog to you";
	
	//1-registration
	@Test(priority = 1)
	public void userCanRegistSccussfully() 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction("osama", "ashraf", "osama34@yahoo.com", "123456789");
		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
	}
	
	
	//2- search for product
	@Test(dependsOnMethods = {"userCanRegistSccussfully"})
	public void userCanSearchWithAutoSuggest()
	{
		searchObject=new SearchPage(driver);
		productDetailsObject=new ProductDeatilsPage(driver);
		searchObject.productSearchUsingAutoSuggest("macb");
		Assert.assertTrue(productDetailsObject.headerOfProduct.getText().equalsIgnoreCase(productName));	
	}
	
	//3- send email friend
	@Test(dependsOnMethods = {"userCanSearchWithAutoSuggest"})
	public void userCanSendEmailToFriendSuccess()
	{
		productDetailsObject.useropenEmailFriendPage();
		emailFriendObject=new EmailFriendPage(driver);
		emailFriendObject.userSendEmailToFriend(emailFriend, personalMessage);
		Assert.assertTrue(emailFriendObject.messageSucces.getText().contains("Your message has been sent"));
		
	}
	
	//4-user logout
	@Test (dependsOnMethods = {"userCanSendEmailToFriendSuccess"})
	public void userCanLogOutSuccufully() 
	{
		registObject.userLogOut();

	}

}
