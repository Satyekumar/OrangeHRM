package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobTitle {
	
	@FindBy(xpath="//li[@class='oxd-topbar-body-nav-tab --parent']/span[text()='Job ']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']//a[text()='Job Titles']")
	private WebElement JobTitlesAtmenuBar;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement JobTitles;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	private WebElement RecordsFound;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement Addbtn;
	
	@FindBy(xpath="//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th']")
	private WebElement Header;
	
	@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell']/div")
	private WebElement tablevalue;
	
	@FindBy(xpath="//button[@class=\\\"oxd-icon-button oxd-table-cell-action-space\\\"]/i)[2]")
	private WebElement deleteJobTitles;
	
	@FindBy(xpath="//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"]/i)[2]")
	private WebElement EditJobTitles;
	public JobTitle(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	

}
