package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddWishlistPage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class AddWishlistTest extends TestBase{

	AddWishlistPage addWishlistObject;

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
	public void usercanAddToWishlist() 
	{
		productDetailsObject.userAddWishlistPage();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");	
		addWishlistObject=new AddWishlistPage(driver);

	}

	@Test(dependsOnMethods = {"usercanAddToWishlist"})
	public void usercanRemoveProductFromCart() 
	{
		addWishlistObject.removeProduct();
		Assert.assertTrue(addWishlistObject.messageWishlistEmpty.getText().contains("The wishlist is empty!"));
	}


}
