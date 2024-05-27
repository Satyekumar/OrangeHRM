package repositry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptionalFields {
	
	@FindBy(xpath="//span[@class='oxd-topbar-body-nav-tab-item']")
	private WebElement configuration;
	
	@FindBy(xpath="//a[text()='Optional Fields']")
	private WebElement OptionalFields;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-main-title']")
	private WebElement OptionalFieldstxt;
	
	@FindBy(xpath="(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[1]")
	private WebElement nickname;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement saveBtn;
	
	public OptionalFields(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This Method is used for Optional Fields Selection
	 * @param driver
	 */
	public void OptionalFieldsSelection(WebDriver driver)
	{
		configuration.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Optional Fields']"))).click();
		nickname.click();
		saveBtn.click();
		
	}
	
	public WebElement getOptionalFieldstxt() {
		return OptionalFieldstxt;
	}
	
	public String OptionalFieldstxt() {
		return OptionalFieldstxt.getText();
	}
}
