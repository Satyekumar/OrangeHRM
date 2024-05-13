package com.PIM.orangeHRM;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ConstantLib;
import repositry.DashboardPage;
import repositry.EmployeeReports;
import repositry.LogiNPage;
import repositry.Sidebar;

public class ReportTest extends BaseClass{
	@Test
	public void SearchReport()
	{
		String expReportNameSearchResult = "Employee Job Details";
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		Sidebar sd=new Sidebar(driver);
		sd.SearchPIM("PIM");
		EmployeeReports er=new EmployeeReports(driver);
		er.SearchEmployeeReports(driver, "Employee Job Details");
		String actReportNameSearchResult = er.ReportNameSearchResult();
		Assert.assertEquals(actReportNameSearchResult, expReportNameSearchResult);
	}
	@Test
	public void CreatReport()
	{
		String expReportNameSearchResult = "Employee Job Details";
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		Sidebar sd=new Sidebar(driver);
		sd.SearchPIM("PIM");
		EmployeeReports er=new EmployeeReports(driver);
		er.CreateEmployeeReports(driver, "Employee Job Details");
			}
}
