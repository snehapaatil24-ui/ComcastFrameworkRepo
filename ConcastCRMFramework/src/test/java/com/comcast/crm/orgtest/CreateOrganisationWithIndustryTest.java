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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.listener.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganisationWithIndustryTest extends BaseClass{
	
	@Test
	public void createOrgwithIndus() throws Throwable {
		
		// read testscripts data from Excel file
		
		String orgName = elib.getDataFromExcel("Org", 4, 2)+ jlib.getRandomNumber();
		String industry =elib.getDataFromExcel("Org", 4, 3).toString();
		String type = elib.getDataFromExcel("Org", 4, 4).toString();
		String shippingAddress =elib.getDataFromExcel("Org", 4, 3).toString();
		
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		//step2 navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3 click on "create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		
		//step4 enter all details and create new organization
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement wbb = cnop.getIndustrys();
		
	//driver.findElement(By.name("industry"));
		
		Select sel= new Select(wbb);
		sel.selectByVisibleText(industry);
		//second drop down
	  WebElement sj = cnop.getacctype();
	  
			  
			  //driver.findElement(By.name("accounttype"));
		Select sel1= new Select(sj);
		sel1.selectByVisibleText(type);
		cnop.getShippingAddEdt().sendKeys(shippingAddress);
		
	//	driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]")).sendKeys(shippingAddress);
		
		cnop.getSaveBtn().click();
		
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//verify the industries and type info
		
		//verify Header orgname Expected result
		
		String ActualIndustries = cnop.getActIndus().getText();
				//driver.findElement(By.id("dtlview_Industry")).getText();
		if (ActualIndustries.equals(industry)) {
			System.out.println(industry +" information is verified==pass");}

		else {
			System.out.println(industry +"information is not verified==fail");}
		
		String ActualType = cnop.getacttype().getText();
		
				//driver.findElement(By.id("dtlview_Type")).getText();
		if (ActualType.equals(type)) {
			System.out.println(type +" information is verified==pass");}

		else {
			System.out.println(type +"information is not verified==fail");}
		 

		
		
		//step 5 logout
	//	driver.quit();
		
		
		
		}
}
