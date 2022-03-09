package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase{

	public AddReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    @FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTextBox;
    
    @FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTextBox;
    
    @FindBy(css = "button.button-1.write-product-review-button")
    WebElement submitReviewBtn;	
    
    @FindBy(id = "addproductrating_4")
    WebElement ratingRadioBtn;
    
	@FindBy(css = "div.result")
	public WebElement messageReviewSucces;
	
	public void writeReview(String reviewTitle , String reviewText) 
	{
		setTextElementText(reviewTitleTextBox, reviewTitle);
		setTextElementText(reviewTextBox, reviewText);
		clickButton(ratingRadioBtn);
		clickButton(submitReviewBtn);
	}

}
