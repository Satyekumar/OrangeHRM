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

public class AddVacancy {
	
	WebDriver driver;
	String JobTtileOption="";
	
	@FindBy(xpath="//a[text()='Vacancies']")
	private WebElement VacanciesTab;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement AddVacanciesText;
	
	@FindBy(xpath="//label[text()='Vacancy Name']/parent::div/following-sibling::div/input")
	private WebElement vacancyName;
	
	@FindBy(xpath="//label[text()='Hiring Manager']/parent::div/following-sibling::div/input")
	private WebElement Hiring_Manager;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-option']/span")
	private WebElement Hiring_Manager_Option;
	
	
	@FindBy(xpath="//label[text()='Number of Positions']/parent::div/following-sibling::div/input")
	private WebElement Number_of_Positions;
	
	@FindBy(xpath="//label[text()='Description']/parent::div/following-sibling::div/textarea")
	private WebElement Description;
	
	@FindBy(xpath="//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
	private WebElement JobTileDropDown;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-text-label']")
	private List<WebElement> URL;
	
	
	@FindBy(xpath = "//a[@class='orangehrm-vacancy-link']")
	private List<WebElement> URLValues;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement CancelBtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement SaveBtn;
	
	public  AddVacancy()
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HashMap<String, String> AddVacancy(String vc,String JobTtileOption,String des,String hm,String np)
	{
		HashMap<String,String> url=new HashMap<String,String>();
		for(int i=0;i>URL.size();i++)
		{
			String urlname = URL.get(i).getText();
			for(int j=1;j<URLValues.size();j++)
			{
				if(i==j)
				{
					String urlvalues = URLValues.get(j).getText();	
					url.put(urlname,urlvalues );
				}
			}
		} 
		vacancyName.sendKeys(vc);
		JobTileDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+JobTtileOption+"']"))).click();
		Description.sendKeys(des);
		Hiring_Manager.sendKeys(hm);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-option']/span"))).click();
		Number_of_Positions.sendKeys(np);
		SaveBtn.click();
		
		return url;
	}
}
