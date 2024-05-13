package repositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogiNPage {
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name=\"username\"]/parent::div/following-sibling::span")
	private WebElement usernameErrorMsg;
	
	@FindBy(xpath="//input[@name=\"password\"]/parent::div/following-sibling::span")
	private WebElement passwordErrorMsg;
	
	public LogiNPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * LoginToApplication Method will login into the Application
	 * @param un
	 * @param pw
	 */
	public void LoginToApplication(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		LoginBtn.click();
		
	}

	public WebElement getUsernameErrorMsg() {
		return usernameErrorMsg;
	}

	public WebElement getPasswordErrorMsg() {
		return passwordErrorMsg;
	}
	
	
	public String usernameErrorMsg()
	{
		return usernameErrorMsg.getText();
	}
	public String passwordErrorMsg()
	{
		return passwordErrorMsg.getText();
	}
	
	
}
