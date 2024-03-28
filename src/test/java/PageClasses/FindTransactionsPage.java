package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class FindTransactionsPage extends BasicPageClasses{
	
	@FindBy(xpath="//select[@id='accountId']")
	WebElement AccountNos;
	
	@FindBy(id="criteria.transactionId")
	WebElement TransactionId;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement findTransactionBYID;
    
	
	public LeftMenuClass leftmenuclass;
	public FindTransactionsPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public LeftMenuClass getletfmenu() {
		return PageFactory.initElements(driver, LeftMenuClass.class);
		
	}
	
	public void SelectAccount() {
		/*
		 * Select You_AccountNo = new Select(AccountNos); List<WebElement>
		 * allOptions_From = You_AccountNo.getOptions(); int accountNo =
		 * allOptions_From.size() - 1; You_AccountNo.selectByIndex(accountNo);
		 */
		selectdropdown(AccountNos);
		
	}
	
	public void EnterTransactionID(String ID) {
		TransactionId.sendKeys(ID);
		findTransactionBYID.click();
	}
	
 
}
