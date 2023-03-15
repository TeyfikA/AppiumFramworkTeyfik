package com.matthewappium.testUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.matthewappium.utils.AppiumUtils;

import io.appium.java_client.AppiumDriver;

public class ExtentReportListeners extends AppiumUtils implements ITestListener{
	
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	ExtentTest test;
	AppiumDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot Code
		// test.addScreenCaptureFromBase64String("Name Field ScreenShot");
		test.fail(result.getThrowable());
		
//		try {
//			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		try {
//			
//
//			System.out.println(getScreenShotPath(driver, "Testing"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//				
//		try {
//			test.addScreenCaptureFromPath(getScreenShotPath(driver, result.getMethod().getMethodName()), result.getMethod().getMethodName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
