package com.yadhu.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestListeners implements ITestListener {

	public ExtentSparkReporter htmlreporter;
	public ExtentReports reports;
	public ExtentTest test;

	public void configure() {
		System.out.println("Inside configure");
		htmlreporter = new ExtentSparkReporter("ExtentSparkReporterDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		reports.setSystemInfo("Machine", "Yadhu PC");
		reports.setSystemInfo("OS", "Windows 10");
		
		htmlreporter.config().setDocumentTitle("Extent Listener report");
		htmlreporter.config().setReportName("E-commerce Testing");
		htmlreporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    System.out.println("Test Case :"+result.getName()+"--> PASS");
	    test = reports.createTest(result.getName());
	    test.log(Status.PASS,MarkupHelper.createLabel("Name of the TestCase: "+result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case :"+result.getName()+"--> FAIL");
		test = reports.createTest(result.getName());
	    test.log(Status.FAIL,MarkupHelper.createLabel("Name of the TestCase: "+result.getName(), ExtentColor.RED));
	    String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";

		File screenShotFile = new File(screenShotPath);

		if (screenShotFile.exists()) {
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		}
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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		onTestFailure(result);
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		configure();
		System.out.println("Starting the Execution");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Execution Ends");
		reports.flush();
		
	}

}
