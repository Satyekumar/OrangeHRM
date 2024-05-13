package Report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport  implements ITestListener
{
	
	private static ExtentReports extent = new ExtentReports();
	   private static ExtentTest test;

	   public void onTestStart(ITestResult result) {
	       test = extent.createTest(result.getMethod().getMethodName());
	   }

	   public void onTestSuccess(ITestResult result) {
	       test.log(Status.PASS, "Test Passed");
	   }

	   public void onTestFailure(ITestResult result) {
	       test.log(Status.FAIL, "Test Failed");
	   }

	   public void onTestSkipped(ITestResult result) {
	       test.log(Status.SKIP, "Test Skipped");
	   }

	   public void onStart(ITestContext context) {
	       ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	       extent.attachReporter(htmlReporter);
	   }

	   public void onFinish(ITestContext context) {
	       extent.flush();
	   }

}
