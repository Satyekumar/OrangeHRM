package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCandidatePage {
	WebDriver driver;
		
		String s="";
		static String userUniqueName;
		
		@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
		private WebElement addCandidatetxt;
		
		@FindBy(xpath="//input[@name='firstName']")
		private WebElement FirstName;
		
		@FindBy(xpath="//input[@name='firstName']/parent::div/following-sibling::span")
		private WebElement firstNameErrorMsg;
		
		@FindBy(xpath="//input[@name='middleName']")
		private WebElement MiddleName;
		
		@FindBy(xpath="//input[@name='lastName']")
		private WebElement LastName;
		
		@FindBy(xpath="//input[@name='lastName']/parent::div/following-sibling::span")
		private WebElement LastNameErrorMsg;
		
		@FindBy(xpath="//label[text()='Vacancy']/parent::div/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']/div[text()='-- Select --']")
		private WebElement Vacancy;
		
		@FindBy(xpath="//span[text()='Junior Account Assistant']")
		private WebElement VacancyOption;
		

		@FindBy(xpath="//label[text()='Email']/parent::div/following-sibling::div/input")
		private WebElement EmailTxtField;
		

		@FindBy(xpath="//label[text()='Contact Number']/parent::div/following-sibling::div/input")
		private WebElement ContactTxtField;
		
		@FindBy(xpath="//div[@class='oxd-file-button']")
		private WebElement Browser;
		
		@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-input-hint']")
		private WebElement FileUploadHint;
		
		@FindBy(xpath="//label[text()='Keywords']/parent::div/following-sibling::div/input")
		private WebElement Keywords;
		
		@FindBy(xpath="//label[text()='Notes']/parent::div/following-sibling::div/textarea")
		private WebElement Notes;
		
		@FindBy(xpath="//label[text()='Date of Application']/parent::div/following-sibling::div//input")
		private WebElement Date_of_Application;
		
		@FindBy(xpath="//input[@type='checkbox']")
		private WebElement Consent_To_KeepData;
		
		@FindBy(xpath="//button[text()=' Save ']")
		private WebElement SaveBtn;
		
		public AddCandidatePage()
		{
			PageFactory.initElements(driver, this);
		}
}
