package repositry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeReports {
	
	@FindBy(xpath="//a[text()='Reports']")
	private WebElement ReportTab;
	
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
	private WebElement EmployeeReportText;
	
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
	private WebElement ReportName;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement AddReport;
	
	@FindBy(xpath="//input[@placeholder='Type here ...']")
	private WebElement AddReportNameInputTxtBox;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-option']/span")
	private WebElement ReportNameOption;
	
	@FindBy(xpath="(//div[@class='oxd-table-cell oxd-padding-cell']/div)[2]")
	private WebElement ReportNameSearchResult;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement saveBtn;
	
	public EmployeeReports(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SearchEmployeeReports(WebDriver driver,String rn)
	{
		ReportTab.click();
		AddReport.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-option']/span"))).click();
		SearchBtn.click();
		}
	
	public void CreateEmployeeReports(WebDriver driver,String rn)
	{
		ReportTab.click();
		ReportName.sendKeys(rn);
		AddReportNameInputTxtBox.sendKeys(rn);
		saveBtn.click();
		}

	public WebElement getEmployeeReportText() {
		return EmployeeReportText;
	}
	public WebElement getReportNameSearchResult() {
		return ReportNameSearchResult;
	}

	public String EmployeeReportText() {
		return EmployeeReportText.getText();
	}
	public String ReportNameSearchResult() {
		return ReportNameSearchResult.getText();
	}
	
}
   