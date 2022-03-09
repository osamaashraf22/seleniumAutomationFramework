package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordLeftBtn;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTextBox;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTextBox;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confrimNewPasswordTextBox;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtnSave;
	
	@FindBy(css = "div.bar-notification.success")
	public WebElement sccussMessageChangePassword;
	
	@FindBy(css = "span.close")
	WebElement closeMessageSccuss;

	public void openChangePasswordPage() 
	{
		clickButton(changePasswordLeftBtn);
	}
	
	public void closeMessageSccuss()
	{
		clickButton(closeMessageSccuss);
	}
	
	public void userChangeAccount(String oldPassword ,String newPassword)
	{
		setTextElementText(oldPasswordTextBox, oldPassword);
		setTextElementText(newPasswordTextBox, newPassword);
		setTextElementText(confrimNewPasswordTextBox, newPassword);
		clickButton(changePasswordBtnSave);	
	}


}
