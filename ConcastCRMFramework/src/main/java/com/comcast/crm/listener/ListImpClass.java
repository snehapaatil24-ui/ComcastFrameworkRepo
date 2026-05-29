package com.comcast.crm.listener;

import java.util.Date;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.concast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		// add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "===Start=====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "====started====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==========" + result.getMethod().getMethodName() + "===END====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "====Passed====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.FAIL, result.getMethod().getMethodName() + "====Failed====");

		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);

		/*
		 * TakesScreenshot ts = (TakesScreenshot)BaseClass.driver1; File src
		 * =ts.getScreenshotAs(OutputType.FILE);
		 */

		/*
		 * File dest = new File("./configAppData/+testName+"+"+time+".png");
		 * 
		 * try { FileHandler.copy(src, dest); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace();}
		 */
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
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
