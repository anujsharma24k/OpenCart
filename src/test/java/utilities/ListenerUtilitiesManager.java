package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClassTests;

public class ListenerUtilitiesManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	String reportName;

	@Override
	public void onStart(ITestContext testContext) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
		Date date = new Date();
		String timeStamp = dateFormat.format(date);

		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		reportName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + reportName);

		sparkReporter.config().setDocumentTitle("Automation Execution Report");

		sparkReporter.config().setReportName("Automation Functional Testing");

		sparkReporter.config().setTheme(Theme.DARK);

		extentReport = new ExtentReports();

		extentReport.attachReporter(sparkReporter);

		// System Information
		extentReport.setSystemInfo("Application", "Web Application");
		extentReport.setSystemInfo("Module", "Regression");
		extentReport.setSystemInfo("Executed By", System.getProperty("user.name"));
		extentReport.setSystemInfo("Environment", "QA");

		// Read parameters from testng.xml

		String os = testContext.getCurrentXmlTest().getParameter("os");

		if (os != null) {
			extentReport.setSystemInfo("Operating System", os);
		}

		String browser = testContext.getCurrentXmlTest().getParameter("browser");

		if (browser != null) {
			extentReport.setSystemInfo("Browser", browser);
		}

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();

		if (!includedGroups.isEmpty()) {
			extentReport.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest = extentReport.createTest( result.getTestClass().getName()
		        + " --> " + result.getMethod().getMethodName());

		extentTest.assignCategory(result.getMethod().getGroups());
		

		extentTest.log(Status.PASS, result.getName() + " got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest = extentReport.createTest( result.getTestClass().getName()
		        + " --> " + result.getMethod().getMethodName());

		extentTest.assignCategory(result.getMethod().getGroups());

		extentTest.log(Status.FAIL, result.getName() + " got failed");

		extentTest.log(Status.INFO, result.getThrowable());

		// Take ScreenShot on test failure
		
		BaseClassTests bs = new BaseClassTests();
		try {
			
			String Screenshot = bs.captureScreenshot(result.getMethod().getMethodName());
			extentTest.addScreenCaptureFromPath(Screenshot);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest = extentReport.createTest( result.getTestClass().getName()
		        + " --> " + result.getMethod().getMethodName());
		
		extentTest.assignCategory(result.getMethod().getGroups());

		extentTest.log(Status.SKIP, result.getName() + " got skipped");

		if (result.getThrowable() != null) {

			extentTest.log(Status.INFO, result.getThrowable());
		}
	}

	@Override
	public void onFinish(ITestContext testContext) {

		extentReport.flush();

		String reportPath = System.getProperty("user.dir") + "\\reports\\" + reportName;

		File extentReport = new File(reportPath);

		try {

			if (Desktop.isDesktopSupported()) {

				Desktop.getDesktop().browse(extentReport.toURI());
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}