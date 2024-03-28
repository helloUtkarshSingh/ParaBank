package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class TransferFundsPage extends BasicPageClasses {

	@FindBy(xpath = "//input[@id='amount']")
	WebElement AmountTextBox;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement FromAccount;

	@FindBy(xpath = "//select[@id='toAccountId']")
	WebElement ToAccount;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement TransferButton;

	@FindBy(xpath = "//div[@ng-if='showResult']")
	WebElement Transfer_CompleteMess;

	public LeftMenuClass leftmenuclass;
	String your_account_id;

	public TransferFundsPage(WebDriver driver) {
		this.driver = driver;
		leftmenuclass = PageFactory.initElements(driver, LeftMenuClass.class);
	}

	public LeftMenuClass getletfmenu() {
		return leftmenuclass;
	}

	public void EnterAccount(String amount) {
		AmountTextBox.sendKeys(amount);
	}

	public void EnterAccountDetails() {

		// From Account
		/*
		 * Select fromAccount = new Select(FromAccount); List<WebElement>
		 * allOptions_From = fromAccount.getOptions(); int from_accountNo =
		 * allOptions_From.size() - 1; fromAccount.selectByIndex(from_accountNo);
		 */

		selectdropdown(FromAccount);
		// To Account
		Select toAccount = new Select(ToAccount);
		List<WebElement> allOptions_To = toAccount.getOptions();
		int to_accountNo = allOptions_To.size() - allOptions_To.size();
		toAccount.selectByIndex(to_accountNo);

	}

	public void clickTransferButton() {
		TransferButton.click();
		System.out.println("Your Transfers is Completed:-" + Transfer_CompleteMess.getText());
		System.out.println("--------------------------------");
	}

}
