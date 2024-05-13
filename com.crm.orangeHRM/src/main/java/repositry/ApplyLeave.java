package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyLeave {
	
	@FindBy(xpath="//a[text()='Apply']")
	private WebElement ApplyLeaveTab;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement ApplyLeaveText;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement LeaveType;
	
	@FindBy(xpath="//div[text()='CAN - FMLA']")
	private WebElement LeaveTypeOption;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active oxd-input--error']")
	private WebElement FromDate;
	
	@FindBy(xpath="//label[text()='To Date']/parent::div/following-sibling::div//input[@class='oxd-input oxd-input--active']")
	private WebElement ToDate;
	
	@FindBy(xpath="//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	private WebElement Comments;
	
	@FindBy(xpath="//button[text()=' Apply ']")
	private WebElement ApplyBtn;
	
	public ApplyLeave(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

}
