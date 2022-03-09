package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase
{
	HomePage homeObject;
	
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	
	String productName="Apple MacBook Pro 13-inch";
	
	@Test (priority = 1)
	public void userCanChangeCurrency() 
	{
		homeObject=new HomePage(driver);
		homeObject.ChangeCurrency();
		
	}
	
	@Test (priority = 2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException
	{
		searchObject=new SearchPage(driver);
		productDetailsObject=new ProductDeatilsPage(driver);
		searchObject.productSearchUsingAutoSuggest("macb");
		Assert.assertTrue(productDetailsObject.headerOfProduct.getText().equalsIgnoreCase(productName));
		Thread.sleep(2000);
		Assert.assertTrue(productDetailsObject.productPirce.getText().contains("€"));
		System.out.println(productDetailsObject.productPirce.getText());
	}


}
