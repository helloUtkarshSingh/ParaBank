package PageClasses;

import org.openqa.selenium.WebDriver;

import BasicsClasses.BasicPageClasses;
import BasicsClasses.LeftMenuClass;

public class LogOutPage extends BasicPageClasses{
	
	public LeftMenuClass leftmenuclass;
	public LogOutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LeftMenuClass getletfmenu() {
		return leftmenuclass;
	}


}
