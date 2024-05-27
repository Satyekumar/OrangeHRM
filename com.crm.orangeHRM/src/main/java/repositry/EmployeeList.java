package repositry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeList {
	
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
	private WebElement employeeInfo;
	
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/following-sibling::div//input")
	private WebElement employeename;
	
	@FindBy(xpath="//label[text()='Employee Id']/parent::div/following-sibling::div//input")
	private WebElement employeeId;
	
	@FindBy(xpath="//label[text()='Supervisor Name']/parent::div/following-sibling::div//input")
	private WebElement SupervisorName;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement Search;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement Reset;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addBtn;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	private WebElement recordsFound;
	
	@FindBy(xpath="//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[3]/div")
	private WebElement firstAndMiddlenameSection;
	
	
	@FindBy(xpath="//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[2]/div")
	private WebElement empId;
	
	@FindBy(xpath="//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[8]/div")
	private WebElement supervisorName;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	private WebElement norecordFound;
	
	@FindBy(xpath="//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement employeementStatus;
	
	@FindBy(xpath="//span[text()='Freelance']")
	private WebElement Freelance;
	
	
	
	
	public EmployeeList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EmployeeSearchByName(String en)
	{
		employeename.sendKeys(en);
		Search.click();	
	}
	
	public void EmployeeSearchById(String id)
	{
		employeeId.sendKeys(id);
		Search.click();	
	}
	
	public void SearchByemployeementStatus(WebDriver driver)
	{
		employeementStatus.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("Freelance"))).click();
		
		Search.click();	
	}
	
	public void EmployeeSearchBySupervisorName(WebDriver driver, String sname)
	{
		SupervisorName.sendKeys(sname);
		try {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option']/span"))).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Search.click();	
	}

	public WebElement getEmployeeInfo() {
		return employeeInfo;
	}
	
	public WebElement norecordFound() {
		return norecordFound;
	}

	public WebElement getRecordsFound() {
		return recordsFound;
	}

	public WebElement getFirstAndMiddlenameSection() {
		return firstAndMiddlenameSection;
	}

	public WebElement getSupervisorName() {
		return SupervisorName;
	}

	
	public WebElement getEmpId() {
		return empId;
	}

	public String EmployeeInfo()
	{
		String empinfo = employeeInfo.getText();
		
		return empinfo;
	}
	
	public String RecordsFound() {
		 String recordcount = recordsFound.getText();
		 return recordcount;
	}
	
	public String noRecordsFound() {
		 String norecordcount = norecordFound.getText();
		 return norecordcount;
	}
	
	public String FirstAndMiddlenameSection() {
		 String firstnamevalue = firstAndMiddlenameSection.getText();
		 return firstnamevalue;
	}
	public String empId() {
		 String eid = empId.getText();
		 return eid;
	}
	public String Supervisorname() {
		 String sname = supervisorName.getText();
		 return sname;
	}

	public void ResetSearch()
	{
		Reset.click();
	}

	public void AddNewEmployeeBtn()
	{
		addBtn.click();
		
		
	}
}
