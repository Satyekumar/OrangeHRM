package com.PIM.orangeHRM;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ConstantLib;
import repositry.CustomFields;
import repositry.DashboardPage;
import repositry.LogiNPage;
import repositry.OptionalFields;
import repositry.Sidebar;

@Listeners(GenericUtility.ListnerImplementation.class)
public class ConfigurationTest  extends BaseClass{
	@Test(priority=1)
	public void OptionFieldEnablement() throws InterruptedException
	{
		String expOptionalFields = "Optional Fields";
		String expcustomFields = "Custom Fields";
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		Sidebar sd=new Sidebar(driver);
		sd.SearchPIM("PIM");
		OptionalFields of= new OptionalFields(driver);
		of.OptionalFieldsSelection(driver);
		String actOptionalFields=of.OptionalFieldstxt();
		Assert.assertEquals(expOptionalFields, actOptionalFields);
		CustomFields cf=new CustomFields(driver);
		cf.customeFieldCreation(driver, "Medical Report");
		String actcustomFields =cf.Customfieldtext();
		Assert.assertEquals(actcustomFields, expcustomFields);
	}
	@Test(priority=2)
	public void CustomFieldFieldNameErrorValidation() throws InterruptedException
	{
		String actFieldNameErrorMsg ="Required";
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		Sidebar sd=new Sidebar(driver);
		sd.SearchPIM("PIM");
		CustomFields cf=new CustomFields(driver);
		cf.fieldNameErrorValidationOncustomeFieldCreation(driver);
		String expFieldNameErrorMsg = cf.FieldNameErrorMsg();
		Assert.assertEquals(actFieldNameErrorMsg, expFieldNameErrorMsg);
	}
	
	@Test(priority=3)
	public void CustomFieldScreenErrorValidation() throws InterruptedException
	{
		String actScreenErrorMsg ="Required";
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		Sidebar sd=new Sidebar(driver);
		sd.SearchPIM("PIM");
		CustomFields cf=new CustomFields(driver);
		cf.screenErrorValidationOncustomeFieldCreation(driver, "test");
		String expScreenErrorMsg = cf.ScreenErrorMsg();
		Assert.assertEquals(actScreenErrorMsg, expScreenErrorMsg);
		
	}
	@Test(priority=4)
	public void CustomFieldtypeErrorValidation() throws InterruptedException
	{
		String acttypeErrorMsg ="Required";
		LogiNPage login=new LogiNPage(driver);
		login.LoginToApplication(ConstantLib.username, ConstantLib.password);
		DashboardPage dp= new DashboardPage(driver);
		Sidebar sd=new Sidebar(driver);
		sd.SearchPIM("PIM");
		CustomFields cf=new CustomFields(driver);
		cf.screenErrorValidationOncustomeFieldCreation(driver, "test");
		String exptypeErrorMsg = cf.TypeErrorMsg();
		Assert.assertEquals(acttypeErrorMsg, exptypeErrorMsg);
		
	}
}
