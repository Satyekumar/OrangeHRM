package GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation extends BaseClass implements ITestListener,ISuiteListener {
	
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configuration ");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report BackUp ");
	}
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test Start ==== "+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Success of test cases and its details are : "+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : "+result.getMethod().getMethodName());
		
		TakesScreenshot ts = (TakesScreenshot) sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/test.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
	    
		/*EventFiringWebDriver eDriver=new EventFiringWebDriver(eDriver);

		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File("./Screenshot/test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		}
		
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Skip of test cases and its details are : "+result.getName());  
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : "+result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
