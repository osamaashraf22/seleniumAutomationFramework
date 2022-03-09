package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class productHoverMenuTest extends TestBase{
	
	HomePage homeObject;
	
	
	@Test
	public void userCanselectNoteBooksMenu() 
	{
		homeObject=new HomePage(driver);
		homeObject.selectNoteBooksMenu();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
	}

}
