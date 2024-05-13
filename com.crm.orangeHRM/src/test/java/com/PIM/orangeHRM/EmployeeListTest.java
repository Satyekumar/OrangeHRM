package com.PIM.orangeHRM;

import java.awt.AWTException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ConstantLib;
import repositry.AddNewEmployeeDetails;
import repositry.DashboardPage;
import repositry.EmployeeList;
import repositry.LogiNPage;
import repositry.PersonalDetailsPage;
import repositry.Sidebar;

public class EmployeeListTest extends BaseClass{
	
	@Test(priority = 1)
	
	public void SearchByEmployeeName() throws InterruptedException {
		String expemployeeName = "Amelia";
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		Sidebar sd=new Sidebar(driver);
		sd.SearchPIM("PIM");
		EmployeeList empl= new EmployeeList(driver);
		empl.EmployeeSearchByName("Amelia");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")));
		String actFirstAndMiddlename = empl.FirstAndMiddlenameSection();
		System.out.println(actFirstAndMiddlename);
		String record = empl.EmployeeInfo();
		Assert.assertEquals(actFirstAndMiddlename, expemployeeName);
		empl.ResetSearch();
	}
	
@Test(priority = 2)
	
	public void SearchByEmployeeId() throws InterruptedException {
	
	String expemployeeId = "01715";
	LogiNPage login=new LogiNPage(driver);
	login.LoginToApplication(ConstantLib.username, ConstantLib.password);
	DashboardPage dp= new DashboardPage(driver);
	Sidebar sd=new Sidebar(driver);
	sd.SearchPIM("PIM");
	EmployeeList empl= new EmployeeList(driver);
	empl.EmployeeSearchById("01715");
	Thread.sleep(2000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")));
	String actempid = empl.empId();
	System.out.println(actempid);
	String record = empl.EmployeeInfo();
	Assert.assertEquals(actempid, expemployeeId);
	empl.ResetSearch();	
	}
@Test(priority = 3)

public void SearchBySupervisorName() throws InterruptedException {
	
	String expsupervisorname = "Timothy Lewis Amiano";
	String expNoRecordFound="No Records Found";
	LogiNPage login=new LogiNPage(driver);
	login.LoginToApplication(ConstantLib.username, ConstantLib.password);
	DashboardPage dp= new DashboardPage(driver);
	Sidebar sd=new Sidebar(driver);
	sd.SearchPIM("PIM");
	EmployeeList empl= new EmployeeList(driver);
	empl.EmployeeSearchBySupervisorName(driver,"Timothy Lewis Amiano");
	
	
	String actrecord = empl.noRecordsFound();
	Assert.assertEquals(actrecord, expNoRecordFound);
	empl.ResetSearch();
}
@Test(priority = 4)
public void SearchByEmployeeStatus()
{
	String expNoRecordFound="No Records Found";
	LogiNPage login=new LogiNPage(driver);
	login.LoginToApplication(ConstantLib.username, ConstantLib.password);
	DashboardPage dp= new DashboardPage(driver);
	Sidebar sd=new Sidebar(driver);
	sd.SearchPIM("PIM");
	EmployeeList empl= new EmployeeList(driver);
	empl.SearchByemployeementStatus(driver);
	String actrecord = empl.noRecordsFound();
	Assert.assertEquals(actrecord, expNoRecordFound);
	empl.ResetSearch();
}
@Test(priority = 5)
public void AddNewEmployee() throws AWTException, InterruptedException
{   
	String expImageName="APIrequests.png";
	String expsection="Attachments";
	String expimageuploadHints="Accepts jpg, .png, .gif up to 1MB. Recommended dimensions: 200px X 200px";
	LogiNPage login=new LogiNPage(driver);
	login.LoginToApplication(ConstantLib.username, ConstantLib.password);
	DashboardPage dp= new DashboardPage(driver);
	Sidebar sd=new Sidebar(driver);
	sd.SearchPIM("PIM");
	EmployeeList empl= new EmployeeList(driver);
	empl.AddNewEmployeeBtn();
	AddNewEmployeeDetails aed=new AddNewEmployeeDetails(driver);
	String actimageuploadHints = aed.ImageuploadHints();
	Assert.assertEquals(actimageuploadHints, expimageuploadHints);
	aed.AddnewEmployee("satyendra1", "kumar1", "singh1");
	//String actualemployeeId = aed.AddemployeeId();
	PersonalDetailsPage pd=new PersonalDetailsPage(driver);
	pd.personalDetailsData(driver, "56785434", "1991-01-15", "1991-01-15");
	pd.CustomFieldsData(driver, "test");
	pd.AddAttachment("test");
	pd.AttachmentTable(driver);	
	
}

}
