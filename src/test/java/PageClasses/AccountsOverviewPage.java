package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class AccountsOverviewPage extends BasicPageClasses {

	@FindBy(xpath = "//table[@id='accountTable']")
	List<WebElement> AccountTables;

	@FindBy(xpath = "//a[@class='ng-binding']")
	List<WebElement> AllAccNos;

	@FindBy(xpath = "(//table)[1]")
	WebElement AccDetail;

	@FindBy(xpath = "(//tbody/tr[@class='ng-scope'])[1]")
	WebElement AllTransactionId;

	@FindBy(xpath = "(//tbody)")
	WebElement TransactionDetail;

	@FindBy(xpath = "(//tbody//td)[1]")
	WebElement ReqTransactionId;

	WebDriver driver;
	public LeftMenuClass leftmenuclass;

	public AccountsOverviewPage(WebDriver driver) {
		this.driver = driver;

		leftmenuclass = PageFactory.initElements(driver, LeftMenuClass.class);
	}

	public LeftMenuClass getletfmenu() {
		return leftmenuclass;
	}

	public void AccountOver() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Your Account OverView details:");
		for (WebElement TableDetail : AccountTables) {
			System.out.println(TableDetail.getText());
		}

		System.out.println("------------------------------------");
	}

	public void FindAccDetails(String AccNo) throws InterruptedException {
		for (WebElement AllAccNo : AllAccNos) {
			Thread.sleep(2000);
			System.out.println(AllAccNo.getText());
			if (AllAccNo.getText().equalsIgnoreCase(AccNo)) {
				AllAccNo.click();
				break;
			}
		}
		Thread.sleep(2000);
		System.out.println(AccDetail.getText());
		System.out.println("------------------------------------");
	}

	public String getTransactionId() {
		AllTransactionId.click();

		System.out.println(TransactionDetail.getText());
		System.out.println("------------------------------------");
		String TransactionId = ReqTransactionId.getText();
		System.out.println("TransactionId:-" + TransactionId);
		return TransactionId;
	}

}
