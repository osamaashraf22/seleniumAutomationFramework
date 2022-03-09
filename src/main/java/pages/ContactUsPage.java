package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "FullName")
	WebElement yourNameTextBox;
	
	@FindBy(id = "Email")
	WebElement yourEmailTextBox;
	
	@FindBy(id = "Enquiry")
	WebElement EnquiryTextBox;
	
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement messageSccuss;
	
	public void contactUsQurey(String yourName , String email , String enquiry)
	{
		setTextElementText(yourNameTextBox, yourName);
		setTextElementText(yourEmailTextBox, email);
		setTextElementText(EnquiryTextBox, enquiry);
		clickButton(submitBtn);
		
	}

}
