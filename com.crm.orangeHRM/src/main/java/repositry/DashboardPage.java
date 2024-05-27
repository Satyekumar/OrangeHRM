package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement username;
	
	@FindBy(xpath="//p[text()='Time at Work']")
	private WebElement timeAtWork;
	
	@FindBy(xpath="//div[@class='orangehrm-attendance-card-profile-record']")
	private WebElement punchedout;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span orangehrm-attendance-card-fulltime']")
	private WebElement attendancecardfulltime;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement LogoutDropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement LogoutLink;
	
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Logout(WebDriver driver)
	{
		LogoutDropdown.click();
		LogoutLink.click();
	}
	
	public WebElement getUsername() {
		return username;
	}



	public WebElement getTimeAtWork() {
		return timeAtWork;
	}



	public WebElement getPunchedout() {
		return punchedout;
	}



	public WebElement getAttendancecardfulltime() {
		return attendancecardfulltime;
	}



	public String DashboardPage()
	{
		String actUser = getUsername().getText();
		return actUser;
	}
	
	public String TimeAtWork()
	{
		String taw = timeAtWork.getText();
		return taw;
	}
	public String Punchedout()
	{
		String po = punchedout.getText();
		return po;
	}
	public String Attendancecardfulltime() {
		String atf = attendancecardfulltime.getText();
		return atf;
	}
	
	}



