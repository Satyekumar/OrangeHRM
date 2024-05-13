package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar {
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active']")
	private WebElement search;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement admin;
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement PIM;
	
	@FindBy(xpath="//span[text()='Leave']")
	private WebElement Leave;
	
	public Sidebar(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SearchAdmin(String sr)
	{
		search.sendKeys(sr);
		admin.click();
		
	}
	
	public void SearchPIM(String sr)
	{
		search.sendKeys(sr);
		PIM.click();
	}
	public void Leave(String sr)
	{
		search.sendKeys(sr);
		Leave.click();
	}
	
}
