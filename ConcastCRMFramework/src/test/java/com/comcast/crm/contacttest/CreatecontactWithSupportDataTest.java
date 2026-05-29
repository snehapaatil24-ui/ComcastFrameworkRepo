package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.listener.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.JavaUtility;

public class CreatecontactWithSupportDataTest extends BaseClass {

	@Test
	public void createContactwithDate() throws Throwable {

		// read testscripts data from Excel file

		String LastName = elib.getDataFromExcel("contact", 4, 2).toString() + jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewcontactBtn().click();

		// step2 navigate to Organization module
		// driver.findElement(By.linkText("Contacts")).click();

		// step3 click on "create Organization" Button
		// driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step4 enter all details and create new organization

		String startdate = jlib.getSystemYYYYDDMM();
		String enddate = jlib.getRequiredYYYYDDMM(30);
		cp.getLastNametext().sendKeys(LastName);

		// driver.findElement(By.name("lastname")).sendKeys(LastName);
		// driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]")).sendKeys(shippingAddress);

		cp.getStartDate().clear();
		cp.getStartDate().sendKeys(startdate);
		/*
		 * driver.findElements(By.name("support_start_date")).clear();
		 * driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		 */
		cp.getEndDate().clear();
		cp.getEndDate().sendKeys(enddate);
		/*
		 * driver.findElement(By.name("support_end_date")).clear();
		 * driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		 */
		cp.getSaveBtn().click();

		// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verify start and end date Expected result

		String Actstartd = cp.getsupportStart().getText();

		// driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (Actstartd.equals(startdate)) {
			System.out.println(startdate + " is verified==pass");
		}

		else {
			System.out.println(LastName + " is not created==fail");
		}

		String Actendd = cp.getsupportEnd().getText();
		// driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (Actendd.equals(enddate)) {
			System.out.println(enddate + " is verified==pass");
		}

		else {
			System.out.println(enddate + " is not verified==fail");
		}

	}
}
