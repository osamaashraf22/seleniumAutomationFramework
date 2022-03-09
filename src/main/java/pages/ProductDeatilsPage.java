package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDeatilsPage extends PageBase {

	public ProductDeatilsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement headerOfProduct;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailAFriendBtn;
	
	
	@FindBy(id = "price-value-4")
	 public WebElement productPirce;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewBtn;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addWishlistBtn;
	
	@FindBy(css = "button.button-1.add-to-cart-button")
	WebElement addToCartBtn;
	
	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	
	public void useropenEmailFriendPage()
	{
		clickButton(emailAFriendBtn);
	}
	
	public void useropenAddReviewPage()
	{
		clickButton(addReviewBtn);
	}
	
	public void userAddWishlistPage()
	{
		clickButton(addWishlistBtn);
	}
	
	public void userAddToCartPage()
	{
		clickButton(addToCartBtn);
	}
	
	public void userAddToProductToComparePage()
	{
		clickButton(addToCompareBtn);
	}
	

}
