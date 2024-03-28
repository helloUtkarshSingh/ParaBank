package TestClasses;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
import PageClasses.RegisterCustomerPage;
import PageClasses.RequestLoanPage;
import PageClasses.TransferFundsPage;
import PageClasses.UpdateContactInfoPage;

public class LoginTest extends BasicPageClasses {

	LoginPage loginPage;
	RegisterCustomerPage registercustomerPage;
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
		ArrayList<String> PropArray =readPropertiesFile.ReadPropertiedFile(FilePath);
		
		InvokeBrowser(PropArray.get(0));
		loginPage = openWebsite(PropArray.get(1));
		getPageTitle("ParaBank | Welcome | Online Banking");
		softAssert.assertAll();
	}

	@BeforeTest
	public void CustomerLogin() throws IOException {
		accountsoverviewPage = loginPage.User_Credentials("Pinky", "Pinky");

		if (driver.getTitle().equalsIgnoreCase("ParaBank | Error")) {
			registercustomerPage = loginPage.Register_Customer();
			registercustomerPage.CustomerPersonalInfo("Yellow", "Yadav", "J/69", "UK", "UP", "401107", "7739340702",
					"475644");
			String userName = generateUserName();
			String passWord = generateUserName();
			registercustomerPage.CustomerCredentials(userName, passWord);

			accountsoverviewPage = registercustomerPage.RegisterCustomer();
			getPageTitle("ParaBank | Customer Created");

		}

		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void Open_NewAccount() throws InterruptedException, IOException {

		leftmenuClass = accountsoverviewPage.getletfmenu();

		opennewaccountPage = leftmenuClass.Open_New_Account();
		getPageTitle("ParaBank | Open Account");

		opennewaccountPage.createNewAccount("SAVINGS");

		opennewaccountPage.accountDetail();
		leftmenuClass = opennewaccountPage.getletfmenu();
		accountsoverviewPage = leftmenuClass.Accounts_Overview();
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void Account_Overview() throws InterruptedException {

		accountsoverviewPage.AccountOver();
		leftmenuClass = accountsoverviewPage.getletfmenu();
		transferfundsPage = leftmenuClass.Transfer_Funds();
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void TransferFund() throws InterruptedException, IOException {
		getPageTitle("ParaBank | Transfer Funds");
		Thread.sleep(2000);
		transferfundsPage.EnterAccount("269");

		transferfundsPage.EnterAccountDetails();
		transferfundsPage.clickTransferButton();
		leftmenuClass = transferfundsPage.getletfmenu();
		billpaypage = leftmenuClass.Bill_Pay();
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void BillPay() throws IOException {
		getPageTitle("ParaBank | Bill Pay");
		billpaypage.FillPayeeInformation("Kiran", "J/302", "Pune", "UP", "401107", "7739340720", "16563", "10",
				"15897");
		billpaypage.SubmitBill();
		leftmenuClass = billpaypage.getletfmenu();
		updatecontactinfoPage = leftmenuClass.Update_ContactInfo();
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void UpdateContactInfo() throws IOException {
		getPageTitle("ParaBank | Update Profile");
		updatecontactinfoPage.UpdateInfo("Ram", "Singh", "J/69", "UK", "UP", "401107", "7739340702");
		// updatecontactinfoPage.clickUpdateContactinfoPage();
		leftmenuClass = updatecontactinfoPage.getletfmenu();
		accountsoverviewPage = leftmenuClass.Accounts_Overview();
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void FindTransactions() throws InterruptedException {
		accountsoverviewPage.AccountOver();
		accountsoverviewPage.FindAccDetails("14121");
		String transactionId = accountsoverviewPage.getTransactionId();
		leftmenuClass = accountsoverviewPage.getletfmenu();
		findTransactionsPage = leftmenuClass.Find_Transactions();
		findTransactionsPage.SelectAccount();
		findTransactionsPage.EnterTransactionID(transactionId);
		leftmenuClass = findTransactionsPage.getletfmenu();
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void ApplyLoan() throws Exception {
		requestloanPage = leftmenuClass.Request_Loan();
		String actualStauts = requestloanPage.ApplyForLoan("200", "0");
		Assert.assertEquals(actualStauts, "Denied");
		leftmenuClass = requestloanPage.getletfmenu();
		softAssert.assertAll();
	}

	@Test(priority = 8)
	public void LogOut() {
		leftmenuClass.LogOut();
	}

	@DataProvider(name = "BankingData")
	public static Object[][] getData(Method method) {
		return null;

	}

	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}

}
