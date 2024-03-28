package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class UpdateContactInfoPage extends BasicPageClasses {

	public LeftMenuClass leftmenuclass;

	public UpdateContactInfoPage(WebDriver driver) {
		this.driver = driver;
		leftmenuclass = PageFactory.initElements(driver, LeftMenuClass.class);
	}
	
	public LeftMenuClass getletfmenu() {
		return leftmenuclass;
	}

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

	@FindBy(xpath = "//input[@type='submit']")
	WebElement UpdateProfileButton;

	@FindBy(xpath = "//div[@ng-if='showResult']")
	WebElement UpdateMess;

	public void UpdateInfo(String firstname, String lastname, String address, String city, String state, String zipcode,
			String phonenumber) {

		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Address.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		ZipCode.sendKeys(zipcode);
		PhoneNumber.sendKeys(phonenumber);

	}

	public void clickUpdateContactinfoPage(){
		UpdateProfileButton.click();
		System.out.println("You Profile is Updated:-" + UpdateMess.getText());
		System.out.println("--------------------------------");
		//return PageFactory.initElements(driver, LeftMenuClass.class);
	}

}
