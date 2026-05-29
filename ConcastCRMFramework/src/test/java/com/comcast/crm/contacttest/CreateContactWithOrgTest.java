package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.JavaUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void CreateContactWithOrgTest() throws Throwable {

		// generate the random number
		/*
		 * Random random= new Random(); int randomInt= random.nextInt(10000);
		 */
		// read testscripts data from Excel file

		String orgName = elib.getDataFromExcel("contact", 8, 2) + jlib.getRandomNumber();
		String shippingAddress = elib.getDataFromExcel("contact", 8, 5);
		String contactLastName = elib.getDataFromExcel("contact", 8, 3) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getShippingAddEdt().sendKeys(shippingAddress);
		cnop.getSaveBtn().click();

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String headerinfo = oip.getHeaderMsg().getText();

		/*
		 * //step2 navigate to Organization module
		 * 
		 * driver.findElement(By.linkText("Organizations")).click();
		 * 
		 * //step3 click on "create Organization" Button
		 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
		 * );
		 * 
		 * //step4 enter all details and create new organization
		 * driver.findElement(By.name("accountname")).sendKeys(orgName);
		 * driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]"))
		 * .sendKeys(shippingAddress);
		 * driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 * 
		 * //verify header msg Expected Result
		 */
		// String headerinfo =
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + " is created==pass");
		} else {
			System.out.println(orgName + " is not created==fail");
		}

		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewcontactBtn().click();
		cp.getLastNametext().sendKeys(contactLastName);
		cp.getOrgImgBtn().click();

		// step5 navigate to Organization module
		/*
		 * driver.findElement(By.linkText("Contacts")).click();
		 * 
		 * // step6 click on "create Organization" Button
		 * driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 * 
		 * // step7 enter all details and create new organization
		 * driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		 */
		// driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// switch to child window
		wlib.switchToTabOnURL(driver, "module=Accounts");
		op.getSearchEdt().sendKeys(orgName);
		cp.getSearchorg().click();

		/*
		 * driver.findElement(By.name("search_text")).sendKeys(orgName);
		 * driver.findElement(By.name("search")).click();
		 */
		Thread.sleep(2000);
		
		oip.clickOnOrgName(orgName);
		//driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wlib.switchToTabOnURL(driver, "Contacts&action");
		cp.getSaveBtn().click();
		

		// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		headerinfo = oip.getHeaderMsg().getText();

		// headerinfo =
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(contactLastName))

		{
			System.out.println(contactLastName + " is created==pass");
		} else {
			System.out.println(contactLastName + "is not created==fail");
		}

		// verify Header orgname Expected result
		
		Thread.sleep(2000);
		String actualOrgName = oip.getActOrgnam123().getText();

		// String ActualOrgName = driver.findElement(By.id("mouseArea_Organization
		// Name")).getText();
		System.out.println(actualOrgName);

		if (actualOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " info is verified==pass");
		}

		else {
			System.out.println(orgName + " info is not verified==fail");
		}

		// step 5 logout
		// driver.quit();

	}
}
