package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagement {
	
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
	
	public UserManagement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void serchUsername(String uinput)
	{
		usernameinputtxtbox.sendKeys(uinput);
		
	}
	
	public void UserRole() 
	{
		UserRole.click();
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
