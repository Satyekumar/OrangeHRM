package com.login.orangeHRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ConstantLib;
import GenericUtility.WebdriverUtility;
import repositry.DashboardPage;
import repositry.LogiNPage;
import repositry.Sidebar;

public class LoginTest extends BaseClass {
	
//	static WebDriver driver;
	
	 @Test(priority = 1,groups="Regression & sanity")
	    
	    public void validateloginwithEmptypassword()
	    {
//	    	WebdriverUtility wd=new WebdriverUtility();
//			WebDriver driver=new ChromeDriver();
//			wd.maximize(driver);
//			wd.implicitwait(driver);
//			wd.accessApplication(driver, ConstantLib.url);
			LogiNPage login=new LogiNPage(driver);
			login.LoginToApplication(ConstantLib.username, ConstantLib.emptypassword);
			String experrorMsg = "Required";
			String acterrorMsg = login.passwordErrorMsg();
			System.out.println(acterrorMsg);
			Assert.assertEquals(experrorMsg, acterrorMsg);
			
	    }
	 
	 @Test(priority = 2)
	    
	    public void validateloginwithEmptyusername()
	    {
//	    	WebdriverUtility wd=new WebdriverUtility();
//			WebDriver driver=new ChromeDriver();
//			wd.maximize(driver);
//			wd.implicitwait(driver);
//			wd.accessApplication(driver, ConstantLib.url);
			LogiNPage login=new LogiNPage(driver);
			login.LoginToApplication(ConstantLib.emptyusername, ConstantLib.password);
			String experrorMsg = "Required";
			String acterrorMsg = login.usernameErrorMsg();
			System.out.println(acterrorMsg);
			Assert.assertEquals(experrorMsg, acterrorMsg);
	    }
	 
	 @Test(priority = 3)
	    
	    public void validateloginwithbothEmpty()
	    {
//	    	WebdriverUtility wd=new WebdriverUtility();
//			WebDriver driver=new ChromeDriver();
//			wd.maximize(driver);
//			wd.implicitwait(driver);
//			wd.accessApplication(driver, ConstantLib.url);
			LogiNPage login=new LogiNPage(driver);
			login.LoginToApplication(ConstantLib.emptyusername, ConstantLib.emptypassword);
			String experrorMsg = "Required";
			String acterrorMsg = login.usernameErrorMsg();
			System.out.println(acterrorMsg);
			Assert.assertEquals(experrorMsg, acterrorMsg);
			String experrorMsg1 = "Required";
			String acterrorMsg1 = login.passwordErrorMsg();
			System.out.println(acterrorMsg);
			Assert.assertEquals(experrorMsg1, acterrorMsg1);
			
	    }
	
	@Test(priority = 4,groups="Smoke")
	public void loginTest() throws IOException
	{
//		WebdriverUtility wd=new WebdriverUtility();
//		WebDriver driver=new ChromeDriver();
//		wd.maximize(driver);
//		wd.implicitwait(driver);
//		wd.accessApplication(driver, ConstantLib.url);
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp=new DashboardPage(driver);
		String expUser = "manda user";
		String actUser = dp.DashboardPage();
		System.out.println(actUser);
		Assert.assertEquals(actUser, actUser);
		wd.takesnapshot(driver, "C:\\Users\\Vasuki M B\\eclipse-workspace\\com.crm.orangeHRM\\src\\test\\resources\\orangehrm.png");	
	}
   
}
