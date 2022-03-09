package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	 WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	 WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	 WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	 WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	 WebElement countryList;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	 WebElement phoneTxt;

	@FindBy(id = "BillingNewAddress_City")
	 WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	 WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	 WebElement postCodeTxt;

	@FindBy(css="button.button-1.new-address-next-step-button")
	 WebElement continueBtn;

	@FindBy(id = "shippingoption_1")
	 WebElement shippingMethodRdo;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	 WebElement continueShippingBtn;

	@FindBy(css = "button.button-1.payment-method-next-step-button")
	 WebElement continuePaymentBtn;

	@FindBy(css = "button.button-1.payment-info-next-step-button")
	 WebElement continueInfoBtn;

	@FindBy(css = "a.product-name")
	public WebElement prodcutName;

	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	private WebElement confirmBtn;

	@FindBy(css = "h1")
	public WebElement ThankYoulbl;

	@FindBy(css = "div.title")
	 WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	 WebElement orderDetailsLink;


	public void RegisteredUserCheckoutProduct(String countryName, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}

	public void confirmOrder() throws InterruptedException 
	{
		clickButton(confirmBtn);
		Thread.sleep(2000);
	}

	public void viewOrderDetails() {
		clickButton(orderDetailsLink);
	}

}
