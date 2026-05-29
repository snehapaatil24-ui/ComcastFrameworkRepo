package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.listener.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganisationAndDelete extends BaseClass {

	@Test
	public void createOrgandDelete() throws Throwable {

		// generate the random number

		// read testscripts data from Excel file
		String orgName = elib.getDataFromExcel("Org", 1, 2) + jlib.getRandomNumber();
		String shippingAddress = elib.getDataFromExcel("Org", 1, 3).toString();

		// step2 navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3 click on "create Organization" Button
		OrganizationsPage ob = new OrganizationsPage(driver);
		ob.getCreateNewOrgBtn().click();

		// step4 enter all details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getShippingAddEdt().sendKeys(shippingAddress);
		cnop.getSaveBtn().click();

		// verify header msg Expected Result String headerinfo =
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actorgName = oip.getHeaderMsg().getText();

		if (actorgName.contains(orgName)) {
			System.out.println(orgName + " name is verified==pass");

		} else {
			System.out.println(orgName + " name is verified==fail");
		}
		// go back to Organizations page
		hp.getOrgLink().click();
		// search for organization
		ob.getSearchEdt().sendKeys(orgName);
		// wlib.selectDropdown(ob.getSearchDD(),"Organization Name");
		ob.getSearchBtn().click();

		// In dynamic webtable select & delete org
		Thread.sleep(2000);
		oip.selandDel(orgName);
		//driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();
		wlib.acceptAlert(driver);

		// step 5 logout

	}

	

}
