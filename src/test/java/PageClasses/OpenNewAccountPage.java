package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class OpenNewAccountPage extends BasicPageClasses {
	@FindBy(xpath = "//select[@id='type']")
	WebElement AccountType;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement AccountNumber;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement OpenNewAccountButton;

	@FindBy(xpath = "//div[@ng-if='showResult']")
	WebElement Congratulation_Mess;

	@FindBy(xpath = "//a[@id='newAccountId']")
	WebElement CreatedAccountNumber;

	@FindBy(xpath = "//div[@ng-if='showDetails']//tr")
	List<WebElement> AccountDetails;

	@FindBy(xpath = "//td[@id='accountId']")
	WebElement AccountDetailID;

	WebDriver driver;
	String your_account_id;
	public LeftMenuClass leftmenuclass;

	public OpenNewAccountPage(WebDriver driver) {
		this.driver = driver;
		leftmenuclass = PageFactory.initElements(driver, LeftMenuClass.class);
	}

	public LeftMenuClass getletfmenu() {
		return leftmenuclass;
	}

	public void createNewAccount(String accountType) throws InterruptedException {

		Select accounttype = new Select(AccountType);
		accounttype.selectByVisibleText(accountType);

		Thread.sleep(2000);

		OpenNewAccountButton.click();

		System.out.println("Successfull message:- " + Congratulation_Mess.getText());
		System.out.println("---------------------------------------------");
	}

	public void accountDetail() throws InterruptedException {
		your_account_id = CreatedAccountNumber.getText();
		CreatedAccountNumber.click();

		Thread.sleep(2000);
		System.out.println("Your Account Number is:- " + your_account_id);
		System.out.println("Your Account Details: ");
		for (WebElement AccountDetail : AccountDetails) {
			System.out.println(AccountDetail.getText());
		}

		System.out.println("--------------------------------");

	}

}
