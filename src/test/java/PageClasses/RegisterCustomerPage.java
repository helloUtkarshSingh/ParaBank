package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicsClasses.BasicPageClasses;

public class RegisterCustomerPage extends BasicPageClasses {

	@FindBy(xpath = "//input[@name='customer.firstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@name='customer.lastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='customer.address.street']")
	WebElement Address;

	@FindBy(xpath = "//input[@name='customer.address.city']")
	WebElement City;

	@FindBy(xpath = "//input[@name='customer.address.state']")
	WebElement State;

	@FindBy(xpath = "//input[@name='customer.address.zipCode']")
	WebElement ZipCode;

	@FindBy(xpath = "//input[@name='customer.phoneNumber']")
	WebElement PhoneNumber;

	@FindBy(xpath = "//input[@name='customer.ssn']")
	WebElement SSN;

	@FindBy(xpath = "//input[@name='customer.username']")
	WebElement UserName;

	@FindBy(xpath = "//input[@name='customer.password']")
	WebElement PassWord;

	@FindBy(xpath = "//input[@name='repeatedPassword']")
	WebElement ConfirmPassWord;

	@FindBy(xpath = "//input[@value='Register']")
	WebElement RegisterBtt;

	public RegisterCustomerPage(WebDriver driver) {
		this.driver = driver;

	}

	public void CustomerPersonalInfo(String firstname, String lastname, String address, String city, String state,
			String zipcode, String phonenumber, String ssn) {

		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Address.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		ZipCode.sendKeys(zipcode);
		PhoneNumber.sendKeys(phonenumber);
		SSN.sendKeys(ssn);

	}

	public void CustomerCredentials(String username, String password) {

		UserName.sendKeys(username);
		PassWord.sendKeys(password);
		ConfirmPassWord.sendKeys(password);

	}
	
	public AccountsOverviewPage RegisterCustomer() {
		RegisterBtt.click();
		return PageFactory.initElements(driver, AccountsOverviewPage.class);
	}

}
