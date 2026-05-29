package com.comcast.crm.OrgTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.listener.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.concast.crm.generic.webdriverutility.UtilityClassObject;
@Listeners(com.comcast.crm.listener.ListImpClass.class)
public class CreateOrgwithTestNGTest extends BaseClass {
	
	@Test(groups="SmokeTest")
	public void createOrgTest() throws Throwable {
		
	//	UtilityClassObject.getTest().log(Status.INFO,"read data from properties file")	;

			String orgName= elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();
			String shippingAddress=elib.getDataFromExcel("Org", 1, 3).toString();
			HomePage hp= new HomePage(driver);
			hp.getOrgLink().click();
			OrganizationsPage ob= new OrganizationsPage(driver);
			ob.getCreateNewOrgBtn().click();
			CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
			cnop.getOrgNameEdt().sendKeys(orgName);
			cnop.getShippingAddEdt().sendKeys(shippingAddress);
			cnop.getSaveBtn().click();
			OrganizationInformationPage oip= new OrganizationInformationPage(driver);
			String actorgName = oip.getHeaderMsg().getText();
			
			if(actorgName.contains(orgName)) {
				System.out.println(orgName + " name is verified==pass");
				
			}
			else {
				System.out.println(orgName + " name is verified==fail");
			}	
			}
	@Test(groups="RegressionTest")
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		WebElement wbb = cnop.getIndustrys();
		Select sel= new Select(wbb);
		sel.selectByVisibleText(industry);
	  WebElement sj = cnop.getacctype();
		Select sel1= new Select(sj);
		sel1.selectByVisibleText(type);
		cnop.getShippingAddEdt().sendKeys(shippingAddress);
		cnop.getSaveBtn().click();
		String ActualIndustries = cnop.getActIndus().getText();
		if (ActualIndustries.equals(industry)) {
			System.out.println(industry +" information is verified==pass");}

		else {
			System.out.println(industry +"information is not verified==fail");}
		
		String ActualType = cnop.getacttype().getText();
		if (ActualType.equals(type)) {
			System.out.println(type +" information is verified==pass");}

		else {
			System.out.println(type +"information is not verified==fail");}
		
		}
		
	@Test(groups="RegressionTest")
	public void createOrgWithPhoneNumberTest() throws Throwable {
	
		String orgName = elib.getDataFromExcel("Org", 7, 2).toString()+ jlib.getRandomNumber();
		String shippingAddress = elib.getDataFromExcel("Org", 7, 4).toString();
		String phNumber = elib.getDataFromExcel("Org", 7, 3).toString();
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();	
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getShippingAddEdt().sendKeys(shippingAddress);
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		oip.getphnumber().sendKeys(phNumber);
		cnop.getSaveBtn().click();
		String ActualPhNum = oip.getActphone().getText();
		if (ActualPhNum.equals(phNumber)) {
			System.out.println(phNumber + " is verified==pass");}

		else {
			System.out.println(phNumber + " is not verified==fail");}

		}
}
