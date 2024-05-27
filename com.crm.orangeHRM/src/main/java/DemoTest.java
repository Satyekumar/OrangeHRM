import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import repositry.LogiNPage;

public class DemoTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebdriverUtility utility=new WebdriverUtility();
		utility.accessApplication(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LogiNPage logiNPage=new LogiNPage(driver);
		logiNPage.LoginToApplication("Admin", "admin123");
		System.out.println("hello");
	}

}
