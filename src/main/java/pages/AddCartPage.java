package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCartPage extends PageBase{

	public AddCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "itemquantity11234")
	WebElement quantityTextBox;
	
	@FindBy(id = "updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css = "button.remove-btn")
	WebElement removeBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement messageAddCartEmpty;
	
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement agreeCheckBox;
	
	public void updateQuantity(String quantity) 
	{
		clearText(quantityTextBox);
		setTextElementText(quantityTextBox, quantity);
		clickButton(updateCartBtn);
	}
	
	public void removeProductFromCart()
	{
	  clickButton(removeBtn);	
	}
	
	public void openCheckOutPage() 
	{
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}
	
	
	
}
