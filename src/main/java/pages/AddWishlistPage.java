package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddWishlistPage extends PageBase{

	public AddWishlistPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css = "button.remove-btn")
	WebElement removeBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement messageWishlistEmpty;
		
	public void removeProduct() 
	{
		clickButton(removeBtn);
	}
	
}
