package repositry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomFields {

	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement Customfieldtext;
	
	@FindBy(xpath="//span[@class='oxd-topbar-body-nav-tab-item']")
	private WebElement configuration;
	
	@FindBy(xpath="//a[text()='Custom Fields']")
	private WebElement CustomFields;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement Addbtn;
	
	@FindBy(xpath="//label[text()='Field Name']/parent::div/following-sibling::div/input")
	private WebElement FieldName;
	
	@FindBy(xpath="//label[text()='Field Name']/parent::div/following-sibling::span")
	private WebElement FieldNameErrorMsg;
	
	@FindBy(xpath="//label[text()='Screen']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement Screen;
	
	@FindBy(xpath="//label[text()='Screen']/parent::div/following-sibling::span")
	private WebElement ScreenErrorMsg;
	
	@FindBy(xpath="//span[text()='Personal Details']")
	private WebElement PersonalDetailsScreenoption;
	
	@FindBy(xpath="//label[text()='Type']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement Type;
	
	@FindBy(xpath="//label[text()='Type']/parent::div/following-sibling::span")
	private WebElement TypeErrorMsg;
	
	@FindBy(xpath="//span[text()='Text or Number']")
	private WebElement typeoption;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement saveBtn;
	
	
	public CustomFields(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	/**
	 *author-satyendra kumar 
	 * This Method is used for Custom Field creation
	 * @param driver
	 * @param fn
	 */
	public void customeFieldCreation(WebDriver driver,String fn)
	{    
		configuration.click();
		CustomFields.click();
		Addbtn.click();
		FieldName.sendKeys(fn);
		Screen.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Personal Details']"))).click();
		Type.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Text or Number']"))).click();
		saveBtn.click();
	}
	/**
	 *author-satyendra kumar 
	 * This Method is used for field Name Error Validation on Custom Field creation
	 * @param driver
	 * @param fn
	 */
	public void fieldNameErrorValidationOncustomeFieldCreation(WebDriver driver)
	{
		configuration.click();
		CustomFields.click();
		Addbtn.click();
		Screen.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Personal Details']"))).click();
		Type.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Text or Number']"))).click();
		saveBtn.click();
	}
	/**
	 *author-satyendra kumar 
	 * This Method is used for screen Error Validation on Custom Field creation
	 * @param driver
	 * @param fn
	 */
	public void screenErrorValidationOncustomeFieldCreation(WebDriver driver,String fn)
	{
		configuration.click();
		CustomFields.click();
		Addbtn.click();
		FieldName.sendKeys(fn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		Type.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Text or Number']"))).click();
		saveBtn.click();
	}
	public void typeErrorValidationOncustomeFieldCreation(WebDriver driver,String fn)
	{
		configuration.click();
		CustomFields.click();
		Addbtn.click();
		FieldName.sendKeys(fn);
		Screen.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Personal Details']"))).click();
		
		saveBtn.click();
	}
	public WebElement getCustomfieldtext() {
		return Customfieldtext;
	}
	
	public WebElement getFieldNameErrorMsg() {
		return FieldNameErrorMsg;
	}
	
	public WebElement getScreenErrorMsg() {
		return ScreenErrorMsg;
	}
	
	public WebElement getTypeErrorMsg() {
		return TypeErrorMsg;
	}
	public String Customfieldtext() {
		return Customfieldtext.getText();
	}
	
	public String FieldNameErrorMsg() {
		return FieldNameErrorMsg.getText();
	}
	
	public String ScreenErrorMsg() {
		return ScreenErrorMsg.getText();
	}
	
	public String TypeErrorMsg() {
		return TypeErrorMsg.getText();
	}
	
	
	
}

