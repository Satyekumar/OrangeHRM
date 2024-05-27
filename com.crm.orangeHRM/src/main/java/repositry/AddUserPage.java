package repositry;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import GenericUtility.JavaUtils;

public class AddUserPage {
	
	String s="";
	static String userUniqueName;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement addUsertxt;
	
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
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement Addbtn;
	
	@FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::div/input")
	private WebElement username;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-option']/span")
	private WebElement usernameAutoSuggestion;
	
	
	@FindBy(xpath="//label[text()='Password']/parent::div/following-sibling::div/input")
	private WebElement password;
	
	@FindBy(xpath="//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
	private WebElement confirmpassword;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement savebtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement cancelbtn;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	private WebElement deleteUserButton;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
	private WebElement deletePopHeading;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--card-body']")
	private WebElement deletePopSubHeading;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']")
	private WebElement deletePopCancelButton;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	private WebElement deletePopYesDeleteButton;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement requiredErrorMsg;
	
	
	public AddUserPage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	public void AddUser(WebDriver driver,String empname,String un,String pwd,String Cpwd)
	{
		Addbtn.click();
		userrole.click();
		UserRoleoption1.click();
		employeename.sendKeys(empname);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-option']/span"))).click();
		status.click();
		statusoption1.click();
		JavaUtils ju=new JavaUtils();
		int userrandomNumber = ju.randomNumber();
		username.clear();
		String  userUniqueName=un+userrandomNumber;
		username.sendKeys(userUniqueName);
		password.sendKeys(pwd);
		confirmpassword.sendKeys(Cpwd);
		savebtn.click();
	}
	
	public void SearchAddedUser(WebDriver driver,String un)
	{
		Boolean flag=false;
		
		List<WebElement> userdeleteRecords = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']/div[@class='oxd-table-cell-actions']/button/i[@class=\"oxd-icon bi-trash\"]"));
		List<WebElement> userRecords = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']/div"));
		for(int i=0;i<userRecords.size();i++)
		{
			if(userRecords.get(i).getText().contains(un))
			
					{
				flag=true;
			      s=userRecords.get(i).getText();
				break;
					}
		}
		if(flag)
		{
			System.out.println("User Found");
			System.out.println(s);
		}
		else
		{
			System.out.println("User Not Found");
			Assert.fail("After Search Application is not able to find User");
		}
		
	}
	
	public void DeleteAddedUser(WebDriver driver)
	{
		//String RefName="Satyendra";
		driver.findElement(By.xpath("//div[text()='"+s+"']/../../div[@class='oxd-table-cell oxd-padding-cell']//button/i[@class=\"oxd-icon bi-trash\"]")).click();
		DeletePopSubHeading();
		DeletePopSubHeading();
		deletePopYesDeleteButton.click();
}
	
	public WebElement getDeletePopHeading() {
		return deletePopHeading;
	}
	public WebElement getDeletePopSubHeading() {
		return deletePopSubHeading;
	}
	
	public WebElement getRequiredErrorMsg() {
		return requiredErrorMsg;
	}
	public String DeletePopHeading() {
		return deletePopHeading.getText();
	}
	public String DeletePopSubHeading() {
		return deletePopSubHeading.getText();
	}
	
	public String RequiredErrorMsg() {
		return requiredErrorMsg.getText();
	}
}
