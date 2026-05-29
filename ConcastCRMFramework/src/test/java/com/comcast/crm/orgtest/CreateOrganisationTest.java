package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.listener.BaseClass;
import com.comcast.crm.listener.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.JavaUtility;
import com.concast.crm.generic.webdriverutility.UtilityClassObject;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
@Listeners(com.comcast.crm.listener.ListImpClass.class)

public class CreateOrganisationTest extends BaseClass{
	
	

@Test
public void createOrgTest() throws Throwable {
	
	UtilityClassObject.getTest().log(Status.INFO,"read data from properties file")	;

		
	
		//generate the random number
		
		// read testscripts data from Excel file
		String orgName= elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();
		String shippingAddress=elib.getDataFromExcel("Org", 1, 3).toString();
		
		
		//step2 navigate to Organization module
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		
		//step3 click on "create Organization" Button
		OrganizationsPage ob= new OrganizationsPage(driver);
		ob.getCreateNewOrgBtn().click();
		

		//step4 enter all details and create new organization
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getShippingAddEdt().sendKeys(shippingAddress);
		cnop.getSaveBtn().click();
		
		//verify header msg Expected Result String headerinfo =
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		
		if(actorgName.contains(orgName)) {
			System.out.println(orgName + " name is verified==pass");
			
		}
		else {
			System.out.println(orgName + " name is verified==fail");
		}
		
		//step 5 logout
			
		}
	
}
	
