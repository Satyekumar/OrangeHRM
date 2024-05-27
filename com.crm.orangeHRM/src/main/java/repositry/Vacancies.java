package repositry;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vacancies {
	WebDriver driver;
	String JobTtileOption="";
	String VacancyOption="";
	String Hiring_ManagerOption="";
	String SatusOption="";
	
	@FindBy(xpath="//a[text()='Vacancies']")
	private WebElement VacanciesTab;
	
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
	private WebElement VacanciesText;
	
	@FindBy(xpath="//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement JobTileDropDown;
	
	@FindBy(xpath="//label[text()='Vacancy']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement VacancyDropDown;
	
	@FindBy(xpath="//label[text()='Hiring Manager']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement Hiring_ManagerDropDown;
	
	@FindBy(xpath="//label[text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement SatusDropDown;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement resetbtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addbtn;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	private WebElement recordFound;
	
	@FindBy(xpath = "//div[@role='cell']/div")
	private List<WebElement> HeadersValues;
	
	
	@FindBy(xpath = "//div[@role='columnheader']")
	private List<WebElement> Headers;
	
	public Vacancies()
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public String getRecordFoundtxt()
	{
		return recordFound.getText();
	}
	
	public HashMap<String, String> SearchVacaniesyByJobTitle(String jobTitle) throws InterruptedException
	{
		JobTileDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+JobTtileOption+"']"))).click();
		searchbtn.click();
		HashMap<String,String> map=new HashMap<String,String>();
		Thread.sleep(300);
		if(getRecordFoundtxt().contains("Record Found"))
		{
		
		for(int i=1;i<Headers.size();i++)
		{
			String headerName = Headers.get(i).getText();
			for(int j=1;j<HeadersValues.size();j++)
			{
				if(i==j)
				{
					String headersvalues = HeadersValues.get(j).getText();	
					map.put(headerName,headersvalues );
				}
			}
		} 
		}
		else
		{
			System.out.println("No Searched User Found");
		}
		System.out.println(map);
		return map;	
		
	}
	
	public HashMap<String, String> SearchVacaniesyByVacancy(String vac) throws InterruptedException
	{
		VacancyDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+VacancyOption+"']"))).click();
		searchbtn.click();
		HashMap<String,String> map=new HashMap<String,String>();
		Thread.sleep(300);
		if(getRecordFoundtxt().contains("Record Found"))
		{
		
		for(int i=1;i<Headers.size();i++)
		{
			String headerName = Headers.get(i).getText();
			for(int j=1;j<HeadersValues.size();j++)
			{
				if(i==j)
				{
					String headersvalues = HeadersValues.get(j).getText();	
					map.put(headerName,headersvalues );
				}
			}
		} 
		}
		else
		{
			System.out.println("No Searched User Found");
		}
		System.out.println(map);
		return map;	
	}
	public HashMap<String, String> SearchVacaniesyByHiring_Manager(String hm) throws InterruptedException
	{
		Hiring_ManagerDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+Hiring_ManagerOption+"']"))).click();
		searchbtn.click();
		HashMap<String,String> map=new HashMap<String,String>();
		Thread.sleep(300);
		if(getRecordFoundtxt().contains("Record Found"))
		{
		
		for(int i=1;i<Headers.size();i++)
		{
			String headerName = Headers.get(i).getText();
			for(int j=1;j<HeadersValues.size();j++)
			{
				if(i==j)
				{
					String headersvalues = HeadersValues.get(j).getText();	
					map.put(headerName,headersvalues );
				}
			}
		} 
		}
		else
		{
			System.out.println("No Searched User Found");
		}
		System.out.println(map);
		return map;	
	}
	public HashMap<String, String> SearchVacaniesyByStatus(String sttus) throws InterruptedException
	{
		SatusDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+SatusOption+"']"))).click();
		searchbtn.click();
		HashMap<String,String> map=new HashMap<String,String>();
		Thread.sleep(300);
		if(getRecordFoundtxt().contains("Record Found"))
		{
		
		for(int i=1;i<Headers.size();i++)
		{
			String headerName = Headers.get(i).getText();
			for(int j=1;j<HeadersValues.size();j++)
			{
				if(i==j)
				{
					String headersvalues = HeadersValues.get(j).getText();	
					map.put(headerName,headersvalues );
				}
			}
		} 
		}
		else
		{
			System.out.println("No Searched User Found");
		}
		System.out.println(map);
		return map;	
	}
	
	
	
}
