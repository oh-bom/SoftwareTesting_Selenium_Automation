package rahulshettyacademy.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // thread-safe
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // assign unique thread id, ThreadLocal에 매핑 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passsed");
	}

	@Override 
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		// extentTest.get(): thread id를 가져옴 
		
		String filePath=null;
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			filePath=getScreenShot(result.getMethod().getMethodName(),driver);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
