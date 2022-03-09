package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class AddReviewTest extends TestBase{
	    //1-registration
		//2- search for product
		//3- add review
		//4-user logout
	
	AddReviewPage addReviewObject;
	
	HomePage pageObject;
	UserRegistrationPage registObject;
	UserLoginPage loginOject;
	
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void userCanRegistSccussfully() 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction("osama", "ashraf", "osama251@yahoo.com", "123456789");

		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegistSccussfully"})
	public void userCanSearchWithAutoSuggest()
	{
		searchObject=new SearchPage(driver);
		productDetailsObject=new ProductDeatilsPage(driver);
		searchObject.productSearchUsingAutoSuggest("macb");
		Assert.assertTrue(productDetailsObject.headerOfProduct.getText().equalsIgnoreCase(productName));
	}
	
	@Test(dependsOnMethods = {"userCanSearchWithAutoSuggest"})
	public void userCanAddReview()
	{
		productDetailsObject.useropenAddReviewPage();
		addReviewObject=new AddReviewPage(driver);
		addReviewObject.writeReview("mac", "very good");
		
		Assert.assertTrue(addReviewObject.messageReviewSucces.getText().contains("Product review is successfully added"));
	}

	@Test (dependsOnMethods = {"userCanAddReview"})
	public void userCanLogOutSuccufully() 
	{
		registObject.userLogOut();

	}
	
	


}
