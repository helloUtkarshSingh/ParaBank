package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class BillPayPage extends BasicPageClasses {
	@FindBy(xpath = "//input[@name='payee.name']")
	WebElement PayeeName;

	@FindBy(xpath = "//input[@name='payee.address.street']")
	WebElement PayeeAddress;

	@FindBy(xpath = "//input[@name='payee.address.city']")
	WebElement PayeeCity;

	@FindBy(xpath = "//input[@name='payee.address.state']")
	WebElement PayeeState;

	@FindBy(xpath = "//input[@name='payee.address.zipCode']")
	WebElement PayeeZipCode;

	@FindBy(xpath = "//input[@name='payee.phoneNumber']")
	WebElement PayeePhoneNumber;

	@FindBy(xpath = "//input[@name='payee.accountNumber']")
	WebElement PayeeAccNo;

	@FindBy(xpath = "//input[@name='verifyAccount']")
	WebElement PayeeVerifyAccount;

	@FindBy(xpath = "//input[@name='amount']")
	WebElement PayeeAmount;

	@FindBy(xpath = "//select[@name='fromAccountId']")
	WebElement FromAcc;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement SubmitButt;

	@FindBy(xpath = "//div[@ng-show='showResult']")
	WebElement ConfirmationMessage;

	public LeftMenuClass leftmenuclass;

	public BillPayPage(WebDriver driver) {
		this.driver = driver;
		leftmenuclass = PageFactory.initElements(driver, LeftMenuClass.class);
	}

	public LeftMenuClass getletfmenu() {
		return leftmenuclass;
	}

	public void FillPayeeInformation(String name, String address, String city, String state, String zipcode,
			String phoneNumber, String payeeAccountNo, String Amount, String FromAccountNo) {
		PayeeName.sendKeys(name);
		PayeeAddress.sendKeys(address);
		PayeeCity.sendKeys(city);
		PayeeState.sendKeys(state);
		PayeeZipCode.sendKeys(zipcode);
		PayeePhoneNumber.sendKeys(phoneNumber);
		PayeeAccNo.sendKeys(payeeAccountNo);
		PayeeVerifyAccount.sendKeys(payeeAccountNo);
		PayeeAmount.sendKeys(Amount);
	}

	public void SubmitBill() {
		SubmitButt.click();
		System.out.println(ConfirmationMessage.getText());
		// System.out.println("--------------------------------");
	}

}
