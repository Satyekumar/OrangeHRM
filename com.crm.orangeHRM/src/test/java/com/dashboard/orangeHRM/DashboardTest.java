package com.dashboard.orangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ConstantLib;
import GenericUtility.WebdriverUtility;
import repositry.DashboardPage;
import repositry.LogiNPage;
import repositry.Sidebar;
import repositry.UserManagement;

public class DashboardTest extends BaseClass{
	@Test
	public void dashboardSection() throws IOException
	{
//		WebDriver driver=new ChromeDriver();
		String expTAW="Time at Work";
//		LoginTest lt=new LoginTest();
//		lt.loginTest();
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		String actTimeatwork = dp.TimeAtWork();
		System.out.println(actTimeatwork);
		Assert.assertEquals(actTimeatwork, expTAW);
		Sidebar sb=new Sidebar(driver);
		sb.SearchAdmin("Admin");
		UserManagement um= new UserManagement(driver);
		um.UserRole();
		
		
	}
	
	

}
