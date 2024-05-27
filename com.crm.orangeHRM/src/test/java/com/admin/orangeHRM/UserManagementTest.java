package com.admin.orangeHRM;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ConstantLib;
import repositry.AddUserPage;
import repositry.DashboardPage;
import repositry.LogiNPage;
import repositry.Sidebar;
import repositry.UserManagement;

@Listeners(GenericUtility.ListnerImplementation.class)
public class UserManagementTest extends BaseClass{
	@Test(priority=1)
	public void SearchSystemUser() throws InterruptedException
	{
		LogiNPage login=new LogiNPage(sdriver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		System.out.println(ConstantLib.username);
		System.out.println(ConstantLib.password);
		DashboardPage dp= new DashboardPage(sdriver);
		Sidebar sb=new Sidebar(sdriver);
		sb.SearchAdmin("Admin");
		UserManagement um= new UserManagement(sdriver);
		um.serchUsername(sdriver, "Admin");
		
	}
	
	
		@Test(priority=2)
		public void AddSystemUser() throws InterruptedException
		{
			String expSystemUsertxt ="System Users";
			LogiNPage login=new LogiNPage(driver);
			login.LoginToApplication(ConstantLib.username, ConstantLib.password);
			DashboardPage dp= new DashboardPage(driver);
			Sidebar sb=new Sidebar(driver);
			sb.SearchAdmin("Admin");
			UserManagement um= new UserManagement(driver);
			//um.serchUsername(driver, "Admin");
			AddUserPage au=new AddUserPage(driver);
			au.AddUser(driver, "Ranga  Akunuri", "Satyendra", "Priety@36", "Priety@36");
			String actSystemUsertxt = um.getSystemUsertxt();
			Assert.assertEquals(actSystemUsertxt, expSystemUsertxt);
			
		}
		
		@Test(priority=3)
		public void SearchAddedSystemUser() throws InterruptedException
		{
			LogiNPage login=new LogiNPage(driver);
			login.LoginToApplication(ConstantLib.username, ConstantLib.password);
			DashboardPage dp= new DashboardPage(driver);
			Sidebar sb=new Sidebar(driver);
			sb.SearchAdmin("Admin");
			UserManagement um= new UserManagement(driver);
			AddUserPage aup=new AddUserPage(driver);
			aup.SearchAddedUser(driver, "Satyendra");
			
				
		}
		@Test(priority=4)
		public void delteAddedSystemUser() throws InterruptedException
		{
			LogiNPage login=new LogiNPage(driver);
			login.LoginToApplication(ConstantLib.username, ConstantLib.password);
			DashboardPage dp= new DashboardPage(driver);
			Sidebar sb=new Sidebar(driver);
			sb.SearchAdmin("Admin");
			UserManagement um= new UserManagement(driver);
			AddUserPage aup=new AddUserPage(driver);
			aup.SearchAddedUser(driver, "Satyendra");
			aup.DeleteAddedUser(driver);
				
		}
	}
	
	

