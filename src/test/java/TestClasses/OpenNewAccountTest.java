package TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;
import BasicsClasses.ReadPropertiesFile;
import PageClasses.AccountsOverviewPage;
import PageClasses.BillPayPage;
import PageClasses.FindTransactionsPage;
import PageClasses.LogOutPage;
import PageClasses.LoginPage;
import PageClasses.OpenNewAccountPage;
import PageClasses.RequestLoanPage;
import PageClasses.TransferFundsPage;
import PageClasses.UpdateContactInfoPage;

public class OpenNewAccountTest extends BasicPageClasses {

	LoginPage loginPage;
	LeftMenuClass leftmenuClass;
	OpenNewAccountPage opennewaccountPage;
	AccountsOverviewPage accountsoverviewPage;
	TransferFundsPage transferfundsPage;
	BillPayPage billpaypage;
	UpdateContactInfoPage updatecontactinfoPage;
	FindTransactionsPage findTransactionsPage;
	RequestLoanPage requestloanPage;
	LogOutPage logoutPage;
	ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	SoftAssert softAssert = new SoftAssert();

	@BeforeSuite
	public void Open_BankSite() throws IOException {
		String FilePath = System.getProperty("user.dir") + "\\Resources\\config.properties";
		InvokeBrowser(readPropertiesFile.ReadPropertiedFile(FilePath).get(0));
		loginPage = openWebsite(readPropertiesFile.ReadPropertiedFile(FilePath).get(1));
		getPageTitle("ParaBank | Welcome | Online Banking");
		softAssert.assertAll();
	}

	@Test(dataProvider = "getData")
	public void Open_NewAccount(Hashtable<String, String> dataTable) throws InterruptedException {
		loginPage = login();
		accountsoverviewPage = loginPage.User_Credentials("Pinky", "Pinky");
		accountsoverviewPage.AccountOver();
		leftmenuClass=accountsoverviewPage.getletfmenu();
		leftmenuClass.LogOut();
	}

	//@Test(dependsOnMethods = "Open_NewAccount")
	public void LogOut() {
		leftmenuClass.LogOut();
	}
	

	
	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}


}
