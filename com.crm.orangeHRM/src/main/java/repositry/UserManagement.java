package repositry;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.JavaUtils;

public class UserManagement {
	WebDriver driver;
	
	@FindBy(xpath="//li[@class='oxd-topbar-body-nav-tab --parent --visited']/span")
	private WebElement Usermanagment;
	
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
	private WebElement systemUser;
	
	@FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::div/input")
	private WebElement usernameinputtxtbox;
	
	@FindBy(xpath="//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement UserRole;
	
	@FindBy(xpath="//div[@class='oxd-select-option']//span[text()='Admin']")
	private WebElement UserRoleoption1;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement resetbtn;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	private WebElement recordFound;
	
	@FindBy(xpath="(//div[@class='oxd-table']/div//div[@class='oxd-table-cell oxd-padding-cell']/div)[2]")
	private WebElement usernameinSearchRecord;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addbtn;
	
	@FindBy(xpath = "//div[@role='cell']/div")
	private List<WebElement> HeadersValues;
	
	
	@FindBy(xpath = "//div[@role='columnheader']")
	private List<WebElement> Headers;
	
	public UserManagement(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HashMap<String, String> serchUsername(WebDriver driver,String uinput) throws InterruptedException
	{
		HashMap<String,String> map=new HashMap<String,String>();
		JavaUtils ju=new JavaUtils();
		int userrandomNumber = ju.randomNumber();
		AddUserPage au=new AddUserPage(driver);
		String SearchUser = au.userUniqueName;
		usernameinputtxtbox.sendKeys(uinput+userrandomNumber);
		searchbtn.click();
		
		Thread.sleep(300);
		if(getRecordFoundtxt().contains("Record Found"))
		{
		
		for(int i=1;i<Headers.size();i++)
		{
			String headerName = Headers.get(i).getText();
			for(int j=1;j<HeadersValues.size();j++)
			{
				if(i==j)
				{
					String headersvalues = HeadersValues.get(j).getText();	
					map.put(headerName,headersvalues );
				}
			}
		} 
		}
		else
		{
			System.out.println("No Searched User Found");
		}
		System.out.println(map);
		return map;	
	}
	
	public HashMap<String, String> UserRole(WebDriver driver) 
	{
		UserRole.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("UserRoleoption1"))).click();
		List<WebElement>Headers=driver.findElements(By.xpath("//div[@role='columnheader']"));
		List<WebElement>HeadersValues=driver.findElements(By.xpath("//div[@role='cell']/div"));
		HashMap<String,String> map=new HashMap<String,String>();
		
		for(int i=1;i<Headers.size();i++)
		{
			String headerName = Headers.get(i).getText();
			for(int j=1;j<HeadersValues.size();j++)
			{
				if(i==j)
				{
					String headersvalues = HeadersValues.get(j).getText();	
					map.put(headerName,headersvalues );
				}
			}
		} 
		System.out.println(map);
		return map;
		
	}
	public void UserRoleOption() 
	{
		UserRoleoption1.click();
	}

	public WebElement getUsermanagment() {
		return Usermanagment;
	}

	public WebElement getSystemUser() {
		return systemUser;
	}
	public WebElement getRecordFound() {
		return recordFound;
	}

	public WebElement getUsernameinSearchRecord() {
		return usernameinSearchRecord;
	}
	public String getUsermanagmentText() {
		return Usermanagment.getText();
	}

	public String getSystemUsertxt() {
	return systemUser.getText();
	}
	public String getRecordFoundtxt()
	{
		return recordFound.getText();
	}
	public String getUsernameinSearchRecordtxt()
	{
		return usernameinSearchRecord.getText();
	}

}
