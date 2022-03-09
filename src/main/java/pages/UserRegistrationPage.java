package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "gender-male")
	WebElement genderRadioBtn;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTxtBox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTxtBox;
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(css = "div.result")
	public WebElement sccussMessage;
	
	@FindBy(css = "a.ico-logout")
	public WebElement logOutLink;
	
	@FindBy(css = "a.ico-account")
	WebElement myAccountLink;
	
	public void registrationFunction(String firstName , String lastName , String Email , String password)
	{
		clickButton(genderRadioBtn);
	    setTextElementText(firstNameTxtBox, firstName);
	    setTextElementText(lastNameTxtBox, lastName);
	    setTextElementText(emailTxtBox, Email);
	    setTextElementText(passwordTxtBox, password);
	    setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerButton);
	}
	
	public void userLogOut() 
	{
		clickButton(logOutLink);
	}
	
	public void OpenMyAccountPage() 
	{
		clickButton(myAccountLink);
	}

	
	

}
