package com.comcast.crm.listener;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.JavaUtility;
import com.concast.crm.generic.webdriverutility.UtilityClassObject;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	// create object from property file
	public DatabaseUtility dlib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	// public static WebDriver driver1 = null;

	/*
	 * public static ExtentSparkReporter spark; public static ExtentReports report;
	 */

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configBS() throws SQLException {
		System.out.println("-----Connect Db, Report Config----");
		dlib.getDBconnection();
		/*
		 * ExtentSparkReporter spark= new
		 * ExtentSparkReporter("./AdvanceReport/report.html");
		 * spark.config().setDocumentTitle("CRM Test Suite Results");
		 * spark.config().setReportName("CRM Report");
		 * spark.config().setTheme(Theme.DARK);
		 */
		// add Env information and create test
		/*
		 * report = new ExtentReports(); report.attachReporter(spark);
		 * report.setSystemInfo( "OS", "Windows-10"); report.setSystemInfo("BROWSER",
		 * "CHROME-100");
		 */
	}

	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	// (groups= {"SmokeTest", "RegressionTest"})
	public void configBC(@Optional("Chrome") String browser) throws Throwable

	{
		System.out.println("Launch the browser");
		String BROWSER = browser;

		// flib.getDataFromPropertiesFile("BROWSER");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod(alwaysRun = true)
	// (groups= {"SmokeTest", "RegressionTest"})
	public void configBM() throws Throwable {
		System.out.println("Login");
		String URL = flib.getDataFromPropertiesFile("URL");
		String USERNAME = flib.getDataFromPropertiesFile("USERNAME");
		String PASSWORD = flib.getDataFromPropertiesFile("PASSWORD");

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(alwaysRun = true)
	// (groups= {"SmokeTest", "RegressionTest"})
	public void configAM() {
		System.out.println("Logout");
		HomePage hp = new HomePage(driver);
		hp.logout();

	}

	@AfterClass(alwaysRun = true)
	// (groups= {"SmokeTest", "RegressionTest"})
	public void configAC() throws SQLException {
		System.out.println("Close the browser");
		UtilityClassObject.getDriver().quit();

	}

	@AfterSuite(alwaysRun = true)
	// (groups= {"SmokeTest", "RegressionTest"})
	public void configAS() throws SQLException {
		System.out.println("-----close DB, Report backup----");
		dlib.closeDbconnection();
		// report.flush();

	}

}
