package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		js= (JavascriptExecutor)driver;
		action=new Actions(driver);
	}

	@FindBy(className = "ico-register")
	WebElement resgitrationLink;
	
	@FindBy(className = "ico-login")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement  currencyChangeBtn;
	
	@FindBy(linkText = "Computers")
	WebElement computersMenuBtn;
	
	@FindBy(linkText = "Notebooks")
	WebElement notebooksMenuBtn;


	public void openRegitrationPage() 
	{
		clickButton(resgitrationLink);
	}
	
	public void openLoginPage() 
	{
		clickButton(loginLink);
	}
	
	public void openContactUsPage() 
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void ChangeCurrency() 
	{
		Select choice=new Select(currencyChangeBtn);
		choice.selectByVisibleText("Euro");
	}
	
	public void selectNoteBooksMenu() 
	{
		action.moveToElement(computersMenuBtn).perform();
		action.moveToElement(notebooksMenuBtn).click().perform();
	
	}
	
	
}
