package repositry;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatesPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Candidates']")
	private WebElement ApplyLeaveTab;
	
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
	private WebElement ApplyLeaveText;
	
	@FindBy(xpath="//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement JobTitle;
	
	@FindBy(xpath="//label[text()='Vacancy']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement Vacancy;
	
	@FindBy(xpath="//label[text()='Vacancy']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement Hiring_Manager;
	

	@FindBy(xpath="//label[text()='Candidate Name']/parent::div/..//input")
	private WebElement Candidate_Name;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement resetbtn;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	private WebElement recordFound;
	
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addbtn;
	
	@FindBy(xpath = "//div[@role='cell']/div")
	private List<WebElement> HeadersValues;
	
	
	@FindBy(xpath = "//div[@role='columnheader']")
	private List<WebElement> Headers;
}
