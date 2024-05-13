package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebdriverUtility wd=new WebdriverUtility();
	public WebDriver driver;
	
	@BeforeClass
	public void config_BC() {
		driver=new ChromeDriver();
		wd.maximize(driver);
		wd.implicitwait(driver, 20);
	}
	@BeforeMethod
	public void config_BM() {
		wd.accessApplication(driver, ConstantLib.url);
	}
	
	@AfterMethod
	public void config_AM() {
		
	}
	
	@AfterClass
	public void config_AC() {
		driver.quit();
	}
}
