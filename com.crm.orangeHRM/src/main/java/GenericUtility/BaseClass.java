package GenericUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import DBUtility.DataBaseUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import repositry.DashboardPage;

public class BaseClass {
	public static Properties prop;
	public WebdriverUtility wd=new WebdriverUtility();
	DashboardPage dp;
	public WebDriver driver;
	public static WebDriver sdriver;
	
	DataBaseUtility dbLib=new DataBaseUtility();
	FileUtility fLib= new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtils jLib= new JavaUtils();
	
	@BeforeSuite(groups= {"Smoke","Regression"})
	public void config_BS()
	{
		System.out.println("Connect to DB,Report Config====");
		
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void config_BC() throws IOException {
		
		System.out.println("=====Launch The Browser====");
		String BROWSER ="chrome";
		if(BROWSER.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			sdriver=driver;
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			sdriver=driver;
		}
		else if(BROWSER.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			sdriver=driver;
		}
		
		//driver=new ChromeDriver();
		wd.maximize(sdriver);
		wd.implicitwait(driver, 10);
		
	}
	@BeforeMethod
	public void config_BM() {
		wd.accessApplication(sdriver, ConstantLib.url);
	}
	
	@AfterMethod
	public void config_AM() {
		System.out.println("Loging Out From the Application");
		
		dp=new DashboardPage(sdriver);
		dp.Logout(sdriver);
	}
	
	@AfterClass
	public void config_AC() {
		sdriver.quit();
	}
	
	@AfterSuite
	public void config_AS()
	{
		System.out.println("Disconnecting from DB,Report BackUp====");
	}
}
