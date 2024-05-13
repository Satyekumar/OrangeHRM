package repositry;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.rmi.AccessException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.WebdriverUtility;

public class PersonalDetailsPage {
	
	WebdriverUtility wd= new WebdriverUtility();
	@FindBy(xpath="//h6[text()='Personal Details']")
	private WebElement PersonalDetails;
	
	@FindBy(name="firstName")
	private WebElement employeefirstName;
	
	@FindBy(name="middleName")
	private WebElement employeemiddleName;
	
	@FindBy(name="lastName")
	private WebElement employeelastName;
	
	@FindBy(xpath="//label[contains(text(),'License Number')]/parent::div/following-sibling::div/input")
	private WebElement LicenseNumber ;
	
	@FindBy(xpath="//label[text()='License Expiry Date']/parent::div/following-sibling::div//input")
	private WebElement LicenseexpiryDate ;
	
	@FindBy(xpath="//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement Nationality ;
	
	@FindBy(xpath="//div[@class='oxd-select-option']")
	private WebElement Nationalityvalus ;
	
	@FindBy(xpath="//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement MaritalStatus ;
	
	@FindBy(xpath="//div[@class='oxd-select-option']")
	private WebElement MaritalStatusvalues ;
	
	@FindBy(xpath="//label[text()='Date of Birth']/parent::div/following-sibling::div//div/input")
	private WebElement DateOfBirth ;
	
	@FindBy(xpath="(//input[@type='radio']/following-sibling::span)[1]")
	private WebElement maleAsGender ;
	
	@FindBy(xpath="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
	private WebElement saveBtn1 ;
	
	@FindBy(xpath="//label[text()='Blood Type']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement Bloodtype ;
	
	@FindBy(xpath="//div[@class='oxd-select-option']")
	private WebElement BloodtypeOption ;
	
	@FindBy(xpath="//label[text()='Test_Field']/parent::div/following-sibling::div/input")
	private WebElement testField ;
	
	@FindBy(xpath="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]")
	private WebElement saveBtn2 ;
	
	@FindBy(xpath="//h6[text()='Attachments']")
	private WebElement attachmenttxt ;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--text']")
	private WebElement addBtn ;
	
	@FindBy(xpath="//div[@class='oxd-file-button']")
	private WebElement browseBtn ;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement browseBtnErrorMsg ;
	
	@FindBy(xpath="//div[@class='oxd-file-input-div']")
	private WebElement fileSelectiontxt ;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-input-hint']")
	private WebElement fileuploadhints ;
	
	@FindBy(xpath="//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	private WebElement comments ;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement CancelBtn ;
	
	@FindBy(xpath="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[3]")
	private WebElement savebtn ;
	
    public PersonalDetailsPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getPersonalDetails() {
		return PersonalDetails;
	}

	public WebElement getEmployeefirstName() {
		return employeefirstName;
	}

	public WebElement getEmployeemiddleName() {
		return employeemiddleName;
	}

	public WebElement getEmployeelastName() {
		return employeelastName;
	}
	
	public WebElement getNationalityDropdown()
	{
		return Nationality;
	}

	public WebElement getAttachmenttxt() {
		return attachmenttxt;
	}

	public WebElement getBrowseBtnErrorMsg() {
		return browseBtnErrorMsg;
	}

	public WebElement getFileSelectiontxt() {
		return fileSelectiontxt;
	}

	public WebElement getFileuploadhints() {
		return fileuploadhints;
	}
	
	public String PersonalDetails() {
		return PersonalDetails.getText();
		 
	}

	public String EmployeefirstName() {
		return employeefirstName.getText();
		  }

	public String EmployeemiddleName() {
		return employeemiddleName.getText();
		 
	}

	public String EmployeelastName() {
		
		return employeelastName.getText();
		
	}

	public String Attachmenttxt() {
		return attachmenttxt.getText();
	}

	public String BrowseBtnErrorMsg() {
		return browseBtnErrorMsg.getText();
	}

	public String FileSelectiontxt() {
		return fileSelectiontxt.getText();
	}

	public String Fileuploadhints() {
		return fileuploadhints.getText();
	}
	

	public void personalDetailsData(WebDriver driver,String licn,String lic,String dob) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(LicenseNumber));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'License Number')]/parent::div/following-sibling::div/input")));
		Thread.sleep(2000);
		LicenseNumber.click();
		LicenseNumber.sendKeys(licn);
		LicenseexpiryDate.click();
		LicenseexpiryDate.sendKeys(lic);
		Nationality.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Afghan']"))).click();
		MaritalStatus.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Single']"))).click();
		DateOfBirth.click();
		DateOfBirth.sendKeys(dob);
		maleAsGender.click();
		saveBtn1.click();
		
	}
	
	public void CustomFieldsData(WebDriver driver,String tf)
	{
		Bloodtype.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='A+']"))).click();
		testField.sendKeys(tf);
		saveBtn2.click();
		
	}
	public void AddAttachment(String cmt) throws AWTException, InterruptedException
	{
		addBtn.click();
		
		// file path passed as parameter to StringSelection
	      StringSelection s = new StringSelection("D:\\c\\Pictures\\Screenshots\\APIrequests.png");
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	      //identify element and click
	      browseBtn.click();
	      // Robot object creation
	      Robot r = new Robot();
	      //pressing enter
         Thread.sleep(300);
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      Thread.sleep(300);
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	      Thread.sleep(300);
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      Thread.sleep(300);
	      comments.sendKeys(cmt);
	      savebtn.click();
		
	}
	
	public HashMap<String, String> AttachmentTable(WebDriver driver)
	{
		HashMap<String,String> map=new HashMap<String,String>();
		List<WebElement> attchmentvalues = driver.findElements(By.xpath("//div[@class=\"oxd-table-cell oxd-padding-cell\"]"));
		int valuescolomnsize = attchmentvalues.size();
		System.out.println(valuescolomnsize);
		List<WebElement> attchmentHeader = driver.findElements(By.xpath("//div[@class=\"oxd-table-header-cell oxd-padding-cell oxd-table-th\"]"));
		int Headercolomnsize = attchmentHeader.size();
		System.out.println(Headercolomnsize);
		for(int i=0;i<attchmentHeader.size();i++)
		{
			WebElement elementnameList = attchmentHeader.get(i);
			String elementname = elementnameList.getText();
			//System.out.println(elementname);
			for(int j=1;j<attchmentvalues.size();j++)
			{
				WebElement elementlistFprValue = attchmentvalues.get(j);
				String elementValue = elementlistFprValue.getText();
				if(i==j)
				{
					//System.out.println(elementValue);
					map.put(elementname, elementValue);
					
				}
			}
			for(Entry<String, String> k:map.entrySet())
			{
				System.out.println("The Header is=>"+k.getKey()+"The value for correspounding Header is=>"+k.getValue());
		
		}
		System.out.println(map);
		
		}
		return map;
	}
}
