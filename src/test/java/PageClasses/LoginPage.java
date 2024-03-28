package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasicsClasses.BasicPageClasses;

public class LoginPage extends BasicPageClasses {

	RegisterCustomerPage registercustomerPage;
	AccountsOverviewPage accountsoverviewPage;

	@FindBy(xpath = "//input[@name='username']")
	WebElement Username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;

	@FindBy(xpath = "//h1")
	WebElement IfError;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement LogIn_Button;

	@FindBy(xpath = "//p/a[text()='Register']")
	WebElement RegisterCustomer;

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public RegisterCustomerPage Register_Customer() {
		RegisterCustomer.click();
		return PageFactory.initElements(driver, RegisterCustomerPage.class);
	}

	public AccountsOverviewPage User_Credentials(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.elementToBeClickable(LogIn_Button));
			LogIn_Button.click();
			if (driver.getTitle().equalsIgnoreCase("ParaBank | Error")) {
				registercustomerPage = Register_Customer();
				registercustomerPage.CustomerPersonalInfo("Yellow", "Yadav", "J/69", "UK", "UP", "401107", "7739340702",
						"475644");
				String userName = generateUserName();
				String passWord = generateUserName();
				registercustomerPage.CustomerCredentials(userName, passWord);

				accountsoverviewPage = registercustomerPage.RegisterCustomer();
				getPageTitle("ParaBank | Customer Created");

			}

		} catch (Exception e) {
			System.out.println("Login failed. Please check your credentials.");
		}

		return PageFactory.initElements(driver, AccountsOverviewPage.class);
	}

}
