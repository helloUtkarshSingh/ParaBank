package BasicsClasses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageClasses.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicPageClasses {
	public String your_account_id;
	public WebDriver driver;

	public void InvokeBrowser(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("Edge")) {
			System.out.println("No such Driver");
		} else if (BrowserName.equalsIgnoreCase("Gecko")) {
			System.out.println("No such Driver");
		} else {
			System.out.println("No such Driver");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
	}

	public LoginPage openWebsite(String URL) {
		driver.get(URL);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public LoginPage login() {
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public void getPageTitle(String your_account_id) throws IOException {
		String actualValue = driver.getTitle();
		try {
			Assert.assertEquals(actualValue, your_account_id);
			System.out.println("Page title :- " + actualValue);
			System.out.println("------------------------------");
		} catch (Exception e) {
			takeScreenShot(driver);
			System.out.println("Assertion failed! Screenshot captured.");
			e.getMessage();
		}

	}

	public void selectdropdown(WebElement dropdownXpath) {
		Select You_AccountNo = new Select(dropdownXpath);
		List<WebElement> allOptions_From = You_AccountNo.getOptions();
		int accountNo = allOptions_From.size() - 1;
		You_AccountNo.selectByIndex(accountNo);

	}

	public void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + generateFileName() + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public void takeScreenShotOfSpecificArea(WebDriver driver,WebElement element) {
		//Get entire page screenshot
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg;
		
		try {
			fullImg = ImageIO.read(SrcFile);
			
			//Get the location of element on the page
			Point point = element.getLocation();
			
			//Get width and height of the element
			int eleWidth = element.getSize().getWidth()+10;
			int eleHeight = element.getSize().getHeight()+10;
			System.out.println("Height of the element:- "+eleHeight);
			System.out.println("Height of the element:- "+eleWidth);
			//Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreensShot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			
			ImageIO.write(eleScreensShot, "png", SrcFile);
			
			//Copy the element screenshot to disk
			File DestFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + generateFileName() + ".png");
			FileUtils.copyFile(SrcFile, DestFile);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	public String generateFileName() {

		Date now = new Date(); // To get current Date

		SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");// We create an instance of
																						// SimpleDateFormat with the
																						// desired pattern
		String file_Name = dateformatter.format(now);// We then call the format method on our dateFormat object, passing
														// in the now
		return file_Name;
	}
	
	public String generateUserName() {
		Random rand = new Random();
		String userName = "Utkarsh"+rand.nextInt();
		System.out.println("UserName:-"+userName);
		return userName;
	}

}
