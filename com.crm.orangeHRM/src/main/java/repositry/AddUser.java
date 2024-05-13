package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUser {
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement addUser;
	
	@FindBy(xpath="//label[text()='User Role']/parent::div/following-sibling::div//div/div[@class='oxd-select-text-input']")
	private WebElement userrole;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement employeename;
	
	@FindBy(xpath="//div[@class='oxd-select-option']/span[text()='Admin']")
	private WebElement UserRoleoption1;
	
	@FindBy(xpath="//label[text()='Status']/parent::div/following-sibling::div//div/div[@class='oxd-select-text-input']")
	private WebElement status;
	
	@FindBy(xpath="//div[@class='oxd-select-option']/span[text()='Enabled']")
	private WebElement statusoption1;
	
	@FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::div/input")
	private WebElement username;
	
	@FindBy(xpath="//label[text()='Password']/parent::div/following-sibling::div/input")
	private WebElement password;
	
	@FindBy(xpath="//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
	private WebElement confirmpassword;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement savebtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement cancelbtn;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement requiredErrorMsg;
	
	public AddUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void AddUser(String empname,String un,String pwd,String Cpwd)
	{
		userrole.click();
		UserRoleoption1.click();
		employeename.sendKeys(empname);
		status.click();
		statusoption1.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		confirmpassword.sendKeys(Cpwd);
		savebtn.click();
	}
	

}
