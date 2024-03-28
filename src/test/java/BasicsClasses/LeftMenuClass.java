package BasicsClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageClasses.AccountsOverviewPage;
import PageClasses.BillPayPage;
import PageClasses.FindTransactionsPage;
import PageClasses.LogOutPage;
import PageClasses.OpenNewAccountPage;
import PageClasses.RequestLoanPage;
import PageClasses.TransferFundsPage;
import PageClasses.UpdateContactInfoPage;

public class LeftMenuClass extends BasicPageClasses {

	public LeftMenuClass(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Open New Account']")
	WebElement OpenNewAccount;

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Accounts Overview']")
	WebElement AccountsOverview;

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Transfer Funds']")
	WebElement TransferFunds;

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Bill Pay']")
	WebElement BillPay;

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Find Transactions']")
	WebElement FindTransactions;

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Update Contact Info']")
	WebElement UpdateContactInfo;

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Request Loan']")
	WebElement RequestLoan;

	@FindBy(xpath = "//div[@id='leftPanel']//li/a[text()='Log Out']")
	WebElement LogOut;

	public OpenNewAccountPage Open_New_Account() {
		OpenNewAccount.click();
		return PageFactory.initElements(driver, OpenNewAccountPage.class);
	}

	public AccountsOverviewPage Accounts_Overview() {
		AccountsOverview.click();
		return PageFactory.initElements(driver, AccountsOverviewPage.class);
	}

	public TransferFundsPage Transfer_Funds() {
		TransferFunds.click();
		return PageFactory.initElements(driver, TransferFundsPage.class);
	}

	public BillPayPage Bill_Pay() {
		BillPay.click();
		return PageFactory.initElements(driver, BillPayPage.class);
	}

	public UpdateContactInfoPage Update_ContactInfo() {
		UpdateContactInfo.click();
		return PageFactory.initElements(driver, UpdateContactInfoPage.class);
	}

	public FindTransactionsPage Find_Transactions() {
		FindTransactions.click();
		return PageFactory.initElements(driver, FindTransactionsPage.class);
	}

	public RequestLoanPage Request_Loan() {
		RequestLoan.click();
		return PageFactory.initElements(driver, RequestLoanPage.class);
	}

	public LogOutPage LogOut() {
		LogOut.click();
		return PageFactory.initElements(driver, LogOutPage.class);
	}

}
