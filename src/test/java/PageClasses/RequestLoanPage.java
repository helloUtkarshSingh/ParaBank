package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class RequestLoanPage extends BasicPageClasses {

	@FindBy(id = "amount")
	WebElement LoanAmount;

	@FindBy(id = "downPayment")
	WebElement DownPayment;

	@FindBy(id = "fromAccountId")
	WebElement FromAcc;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement ApplyBtt;
	
	@FindBy(xpath="//tbody")
	WebElement LoanDetailTabel;

	@FindBy(id = "loanStatus")
	WebElement LoanStatus;

	@FindBy(xpath = "//td[@id='loanStatus']")
	WebElement ConfirmationMess;

	public RequestLoanPage(WebDriver driver) {
		this.driver = driver;
	}

	public LeftMenuClass getletfmenu() {
		return PageFactory.initElements(driver, LeftMenuClass.class);
	}

	public String ApplyForLoan(String amount, String downpayment) throws Exception {
		LoanAmount.sendKeys(amount);
		DownPayment.sendKeys(downpayment);
		selectdropdown(FromAcc);
		ApplyBtt.click();

		System.out.println("Confirmation Message:- " + ConfirmationMess.getText());
		takeScreenShot(driver);
		Thread.sleep(2000);
		takeScreenShotOfSpecificArea(driver, LoanDetailTabel);
		System.out.println("----------------------------------");
		return LoanStatus.getText();
	}

	

}
