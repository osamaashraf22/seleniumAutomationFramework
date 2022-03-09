package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToComparePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	
	String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop"; 

	// 1- Search for product number 1
	// 2- Search for product number 2 
	// 3- Add to compare 
	// 4- Clear list
	
	AddProductToComparePage compareObject;
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	String productName="Apple MacBook Pro 13-inch";

	@Test(enabled = false ,priority = 1)
	public void UserCanCompareProducts() throws InterruptedException 
	{
		searchObject=new SearchPage(driver);
		productDetailsObject=new ProductDeatilsPage(driver);
		compareObject=new AddProductToComparePage(driver);
		
		searchObject.productSearchUsingAutoSuggest("mac");
		Thread.sleep(2000);
		productDetailsObject.userAddToProductToComparePage();
        
		searchObject.productSearchUsingAutoSuggest("asus");
		productDetailsObject.userAddToProductToComparePage();
		
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		//Assert.assertTrue(compareObject.firstProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		//Assert.assertTrue(compareObject.secodProductName.getText().equals("Apple MacBook Pro 13-inch"));
		compareObject.compareProducts();
		
		
		
	}
	@Test( enabled = false,dependsOnMethods = {"UserCanCompareProducts"})
	public void UserCanClearCompareList() throws InterruptedException {
		//Thread.sleep(1000);
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataMessage.getText().contains("You have no items to compare."));
	}
}

