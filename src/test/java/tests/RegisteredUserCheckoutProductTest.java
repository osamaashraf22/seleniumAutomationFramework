package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddCartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckoutProductTest extends TestBase{
	/*
	 * 1- Register User
	 * 2- Search for product
	 * 3- Add to Cart
	 * 4- Checkout
	 * 5- Logout 
	 */
	
	CheckOutPage checkoutObject;
	AddCartPage addCartObject;
	OrderDetailsPage orderObject ;
	HomePage pageObject;
	UserRegistrationPage registObject;
	
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	
	String productName="Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void userCanRegistSccussfully() 
	{
		pageObject=new HomePage(driver);
		registObject=new UserRegistrationPage(driver);
		pageObject.openRegitrationPage();
		registObject.registrationFunction("osama", "ashraf", "osama239914@yahoo.com", "123456789");

		Assert.assertTrue(registObject.sccussMessage.getText().contains("Your registration completed"));
	}
	
	
	@Test (dependsOnMethods = {"userCanRegistSccussfully"})
	public void userCanSearchWithAutoSuggest()
	{
		searchObject=new SearchPage(driver);
		productDetailsObject=new ProductDeatilsPage(driver);
		searchObject.productSearchUsingAutoSuggest("macb");
		Assert.assertTrue(productDetailsObject.headerOfProduct.getText().equalsIgnoreCase(productName));
	}
	
	@Test(dependsOnMethods = {"userCanSearchWithAutoSuggest"})
	public void usercanAddToCart() 
	{
		productDetailsObject=new ProductDeatilsPage(driver);
		productDetailsObject.userAddToCartPage();
		driver.navigate().to("https://demo.nopcommerce.com/cart");	
	}
	
	@Test(dependsOnMethods = {"usercanAddToCart"})
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckOutPage(driver);
		addCartObject=new AddCartPage(driver);
		addCartObject.openCheckOutPage();
		checkoutObject.RegisteredUserCheckoutProduct
		("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver); 
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	}

	@Test (dependsOnMethods = {"UserCanCheckoutProduct"})
	public void userCanLogOutSuccufully() 
	{
		registObject.userLogOut();

	}

}
