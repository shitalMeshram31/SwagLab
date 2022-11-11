package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.Reports;

public class ExtentReportsSample {
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void configureReports() {
		reports = Reports.createExtentReports();
	}
	@Test
	public void test1() {
		test = reports.createTest("Test1");
		System.out.println("Test1");
	}
	@Test (dependsOnMethods ="test3" )
	public void test2() {
		test = reports.createTest("Test2");
		System.out.println("Test2");
	}
	@Test(timeOut=1000)
	public void test3() throws InterruptedException {
		Thread.sleep(2000);
		test = reports.createTest("Test3");
		System.out.println("Test3");
	}
	@AfterMethod
	public void publishResult(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else {
			test.log(Status.SKIP, result.getName());
		}
 }
@AfterTest
public void createReport() {
	reports.flush();
}
		}


