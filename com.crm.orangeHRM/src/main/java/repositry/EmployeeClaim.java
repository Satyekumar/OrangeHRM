package repositry;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeClaim {
	WebDriver driver;
	
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/..//input")
	private WebElement EmployeeName;
	
	@FindBy(xpath="//label[text()='Reference Id']/parent::div/..//input")
	private WebElement RefrenceId;
	
	@FindBy(xpath="//label[text()='From Date']/parent::div/..//input")
	private WebElement FromDate;
	
	@FindBy(xpath="//label[text()='To Date']/parent::div/..//input")
	private WebElement ToDate;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement AssignClaimBtn;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	private WebElement RecordsFoundText;
	
	@FindBy(xpath = "//div[@role='cell']/div")
	private List<WebElement> HeadersValues;
	
	
	@FindBy(xpath = "//div[@role='columnheader']")
	private List<WebElement> Headers;
	
	
	public EmployeeClaim()
	{
		PageFactory.initElements(driver, this);
	}

	public void SearchClaimByEmployeeName(String emp)
	{
		EmployeeName.sendKeys(emp);
		SearchBtn.click();
		
	}
	public void SearchClaimByRefrenceId(String empRefId)
	{
		EmployeeName.sendKeys(empRefId);
		SearchBtn.click();
	}
}
