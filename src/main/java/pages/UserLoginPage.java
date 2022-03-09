package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase
{

	public UserLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;
	
	
	
	public void LoginFunction(String email , String password)
	{
		setTextElementText(emailTextBox, email);
		setTextElementText(passwordTextBox, password);
		clickButton(loginBtn);
	}
	

}
