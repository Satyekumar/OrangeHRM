package repositry;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.JavaUtils;

public class AddNewEmployeeDetails {
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement addemployeeHeading;
	
	@FindBy(name="firstName")
	private WebElement employeefirstName;
	
	@FindBy(name="middleName")
	private WebElement employeemiddleName;
	
	@FindBy(name="lastName")
	private WebElement employeelastName;
	
	@FindBy(xpath="//label[text()='Employee Id']/parent::div/following-sibling::div/input")
	private WebElement employeeid;
	
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']")
	private WebElement employeeImageUpload;
	
	@FindBy(xpath="//input[@name='firstName']/parent::div/following-sibling::span")
	private WebElement employeefirstNameErrorMsg;
	
	@FindBy(xpath="//input[@name='lastName']/parent::div/following-sibling::span")
	private WebElement employeelasttNameErrorMsg;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement CancelBtn;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-input-hint']")
	private WebElement ImageuploadHints;
	
	public  AddNewEmployeeDetails (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddemployeeHeading() {
		return addemployeeHeading;
	}
	
	public WebElement getAddemployeeId() {
		return employeeid;
	}
	public WebElement getEmployeefirstNameErrorMsg() {
		return employeefirstNameErrorMsg;
	}

	public WebElement getEmployeelasttNameErrorMsg() {
		return employeelasttNameErrorMsg;
	}

	public WebElement getImageuploadHints() {
		return ImageuploadHints;
	}
	

	
	public String AddemployeeHeading()
	{
		String empHeading = addemployeeHeading.getText();
		return empHeading;
	}
	public String AddemployeeId()
	{
		String empid = employeeid.getText();
		return empid;
	}
	
	public String EmployeefirstNameErrorMsg()
	{
		String empfirstnameErrorMsg = employeefirstNameErrorMsg.getText();	
		return empfirstnameErrorMsg;
	}
	public String EmployeelastNameErrorMsg()
	{
		String emplastnameErrorMsg = employeelasttNameErrorMsg.getText();	
		return emplastnameErrorMsg;
	}
	
	public String ImageuploadHints()
	{
		String uploadHint = ImageuploadHints.getText();
		return uploadHint;
	}
	public void AddnewEmployee(String fn,String mn,String ln) throws AWTException, InterruptedException
	{
		JavaUtils ju=new JavaUtils();
		int num = ju.randomNumber();
		
		employeefirstName.sendKeys(fn);
		employeemiddleName.sendKeys(mn);
		employeelastName.sendKeys(ln);
		employeeid.sendKeys(""+num);
		// file path passed as parameter to StringSelection
	      StringSelection s = new StringSelection("D:\\c\\Pictures\\Screenshots\\APIrequests.png");
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	      //identify element and click
	      employeeImageUpload.click();
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
	     
	      SaveBtn.click();  
	   }	
}
