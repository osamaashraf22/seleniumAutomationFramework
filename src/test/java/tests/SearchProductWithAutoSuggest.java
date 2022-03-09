package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDeatilsPage;
import pages.SearchPage;

public class SearchProductWithAutoSuggest extends TestBase
{
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
	public void userCanSearchWithAutoSuggest()
	{
		searchObject=new SearchPage(driver);
		productDetailsObject=new ProductDeatilsPage(driver);
		searchObject.productSearchUsingAutoSuggest("macb");
		Assert.assertTrue(productDetailsObject.headerOfProduct.getText().equalsIgnoreCase(productName));
	}

}
