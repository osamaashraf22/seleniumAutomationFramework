package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement emailFriendTextBox;
	
	@FindBy(id = "YourEmailAddress")
	WebElement yourEmailAddressTextBox;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTextBox;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement messageSucces;
	
	public void userSendEmailToFriend(String emailFriend , String personalMessage) 
	{
		setTextElementText(emailFriendTextBox, emailFriend);
		setTextElementText(personalMessageTextBox, personalMessage);
		clickButton(submitBtn);
		
	}
	
	

}
