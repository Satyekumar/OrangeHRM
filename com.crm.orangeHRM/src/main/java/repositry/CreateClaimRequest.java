package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateClaimRequest {
WebDriver driver;

    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
     private WebElement AssignClaimBtn;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement Create_Claim_Request;
	
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/..//input")
	private WebElement EmployeeName;
	
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/..//span")
	private WebElement EmployeeNameErrorMsg;
	
	@FindBy(xpath="//label[text()='Event']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement Event;
	
	@FindBy(xpath="//label[text()='Event']/parent::div/..//span")
	private WebElement EventErrorMsg;
	
	@FindBy(xpath="//span[text()='Accommodation']")
	private WebElement EventOption;
	
	@FindBy(xpath="//label[text()='Currency']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement Currency;
	
	@FindBy(xpath="//label[text()='Currency']/parent::div/..//span")
	private WebElement CurrencyErrorMsg;
	
	@FindBy(xpath="//span[text()='Albanian Lek']")
	private WebElement CurrencyOption;
	
	@FindBy(xpath="//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	private WebElement Remarks;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement CreateBtn;
	
	public CreateClaimRequest()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ErrorValidationForCreateClaimRequest()
	{
		AssignClaimBtn.click();
		CreateBtn.click();
		String employeeNameErrorMsg=EmployeeNameErrorMsg.getText();
		String eventErrorMsg=EventErrorMsg.getText();
		String currencyErrorMsg=CurrencyErrorMsg.getText();
		System.out.println(employeeNameErrorMsg);
		System.out.println(eventErrorMsg);
		System.out.println(currencyErrorMsg);
		
	}
	
	public void CreateClaimRequest()
	{
		
	}

}
