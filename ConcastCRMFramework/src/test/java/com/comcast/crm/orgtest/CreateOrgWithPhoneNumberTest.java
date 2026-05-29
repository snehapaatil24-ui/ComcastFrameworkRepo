package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrgWithPhoneNumberTest extends BaseClass {
	

	@Test
	public void createOrgWithPhoneNumberTest() throws Throwable {
	
		// read testscripts data from Excel file
		
		String orgName = elib.getDataFromExcel("Org", 7, 2).toString()+ jlib.getRandomNumber();
		String shippingAddress = elib.getDataFromExcel("Org", 7, 4).toString();
		String phNumber = elib.getDataFromExcel("Org", 7, 3).toString();
		
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
				
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		/*
		 * //step2 navigate to Organization module
		 * driver.findElement(By.linkText("Organizations")).click();
		 * 
		 * //step3 click on "create Organization" Button
		 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
		 * );
		 */		
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		//step4 enter all details and create new organization
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		//driver.findElement(By.id("phone")).sendKeys(phNumber);
		cnop.getShippingAddEdt().sendKeys(shippingAddress);
		//driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]")).sendKeys(shippingAddress);
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		oip.getphnumber().sendKeys(phNumber);
		
		//driver.findElement(By.id("phone")).sendKeys(phNumber);
		cnop.getSaveBtn().click();
		
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		

		//verify Header phnumber Expected result
		
		String ActualPhNum = oip.getActphone().getText();
		
				//driver.findElement(By.id("dtlview_Phone")).getText();
		if (ActualPhNum.equals(phNumber)) {
			System.out.println(phNumber + " is verified==pass");}

		else {
			System.out.println(phNumber + " is not verified==fail");}
		 

		
		
		//step 5 logout
		//driver.quit();
		
		
		
		}
	}
	
