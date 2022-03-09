package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddCartPage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class AddProductToCartTest extends TestBase{

	AddCartPage addCartObject;

	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	String productName="Apple MacBook Pro 13-inch";


	@Test(priority = 1)
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
		productDetailsObject.userAddToCartPage();
		driver.navigate().to("https://demo.nopcommerce.com/cart");	
		

	}
	
	@Test(enabled = false,dependsOnMethods = {"usercanAddToCart"})
	public void usercanUpdateProductFromCart() 
	{
		addCartObject=new AddCartPage(driver);
		addCartObject.updateQuantity("4");
	}

	@Test(enabled = true,dependsOnMethods = {"usercanAddToCart"})
	public void usercanRemoveProductFromCart() 
	{
		addCartObject=new AddCartPage(driver);
		addCartObject.removeProductFromCart();;
		Assert.assertTrue(addCartObject.messageAddCartEmpty.getText().contains("Your Shopping Cart is empty!"));
	}


}
