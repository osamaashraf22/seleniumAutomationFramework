package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDeatilsPage;
import pages.SearchPage;


public class SearchProductTest extends TestBase
{
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
	public void userCanSearchProdect() 
	{
		searchObject=new SearchPage(driver);
		productDetailsObject=new ProductDeatilsPage(driver);
		
		searchObject.SearchFunction(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(productDetailsObject.headerOfProduct.getText().equalsIgnoreCase(productName));
	}

}
