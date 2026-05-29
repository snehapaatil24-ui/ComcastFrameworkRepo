package com.comcast.crm.ContactTest1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.listener.BaseClass;
import com.comcast.crm.listener.ListImpClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(ListImpClass.class)

public class CreateContactTestwithTestNG extends BaseClass {
	@Test(groups="SmokeTest")
	public void createContactTest() throws Throwable {

		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewcontactBtn().click();
		cp.getLastNametext().sendKeys(lastName);
		cp.getSaveBtn().click();
		
		String ActualLastname = cp.getActlast().getText();
		System.out.println(ActualLastname);

		if (ActualLastname.equals(lastName)) {
			System.out.println(lastName + "is created==pass");
		}

		else {

			System.out.println(lastName + "is not created==fail");
		}

	}
	
	@Test(groups="RegressionTest")
	public void CreateContactWithOrgTest() throws Throwable {

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

		wlib.switchToTabOnURL(driver, "module=Accounts");
		op.getSearchEdt().sendKeys(orgName);
		cp.getSearchorg().click();

		Thread.sleep(2000);
		
		oip.clickOnOrgName(orgName);
	
		wlib.switchToTabOnURL(driver, "Contacts&action");
		cp.getSaveBtn().click();
		headerinfo = oip.getHeaderMsg().getText();

		if (headerinfo.contains(contactLastName))

		{
			System.out.println(contactLastName + " is created==pass");
		} else {
			System.out.println(contactLastName + "is not created==fail");
		}

		Thread.sleep(2000);
		String actualOrgName = oip.getActOrgnam123().getText();

		System.out.println(actualOrgName);

		if (actualOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " info is verified==pass");
		}

		else {
			System.out.println(orgName + " info is not verified==fail");
		}
	}
	
	@Test(groups="RegressionTest")
	public void createContactwithDate() throws Throwable {

		String LastName = elib.getDataFromExcel("contact", 4, 2).toString() + jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewcontactBtn().click();

		String startdate = jlib.getSystemYYYYDDMM();
		String enddate = jlib.getRequiredYYYYDDMM(30);
		cp.getLastNametext().sendKeys(LastName);

		cp.getStartDate().clear();
		cp.getStartDate().sendKeys(startdate);
		
		cp.getEndDate().clear();
		cp.getEndDate().sendKeys(enddate);
		cp.getSaveBtn().click();
		String Actstartd = cp.getsupportStart().getText();
		if (Actstartd.equals(startdate)) {
			System.out.println(startdate + " is verified==pass");
		}

		else {
			System.out.println(LastName + " is not created==fail");
		}

		String Actendd = cp.getsupportEnd().getText();

		if (Actendd.equals(enddate)) {
			System.out.println(enddate + " is verified==pass");
		}

		else {
			System.out.println(enddate + " is not verified==fail");
		}

	}
}






