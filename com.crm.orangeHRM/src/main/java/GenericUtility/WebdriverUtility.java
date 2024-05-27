package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import repositry.AddNewEmployeeDetails;
import repositry.PersonalDetailsPage;



public class WebdriverUtility  {
	
	
	
	private WebElement ele;

	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
    public void implicitwait(WebDriver driver,int sec)
    {
    	driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
    }
    
    public void getExplicitWait(WebDriver driver,int sec,String xpath)
    {
    	WebDriverWait wait=new WebDriverWait(driver,sec);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    
    public void accessApplication(WebDriver driver,String url)
    {
    	driver.get(url);
    }
    public void LogOutFromApplication(WebDriver driver,String url)
    {
    	driver.get(url);
    }
    
    
    public void findElementWithValue(WebDriver driver,String nameAttribute,String value)
    {
	driver.findElement(By.name(nameAttribute)).sendKeys(value);
    	
    }
    public WebElement findElementwithxpath(WebDriver driver,String xpathAttribute)
    {
    	return driver.findElement(By.xpath(xpathAttribute));
    }
    public void assertion(String actResult,String ExpResult)
    {
    	Assert.assertEquals(ExpResult, actResult, ExpResult);
    }
    public static void takesnapshot(WebDriver driver,String Filewithpath) throws IOException
    {
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
    	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	File DesFile = new File(Filewithpath);
    	FileUtils.copyFile(SrcFile, DesFile);
    }
    public void scrolltoElement(WebDriver driver,WebElement element)
    {
    	int y=element.getLocation().getY();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0,"+y+")");
    	}
    public static void selectDate(WebDriver driver, WebElement element, String dateValue) {
    	

        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]", element, dateValue);

    }
    
    
   public void selectByVisibilityText(WebElement element,String text)
   {
	   WebElement WebElement = null;
	Select select= new Select(WebElement);
	   select.selectByVisibleText(text);
   }
   public void Mousehover(WebDriver driver,WebElement element) {
	   Actions action=new Actions(driver);
	   action.moveToElement(ele).build().perform();
   }
   
   public void Dateselection(WebDriver driver,String element)
   {
	   
   }
   public void SwitchToAlertaccept(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   
}