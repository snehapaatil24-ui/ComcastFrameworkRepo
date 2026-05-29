package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

@Listeners
public class CreatecontactTest extends com.comcast.crm.listener.BaseClass {

	@Test
	public void createContactTest() throws Throwable {

// read testscripts data from Excel file
		// WebDriver driver = new ChromeDriver();

		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// step 1 login to app

		// step2 navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewcontactBtn().click();
		cp.getLastNametext().sendKeys(lastName);
		cp.getSaveBtn().click();

		// step3 click on "create Organization" Button
		// driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step4 enter all details and create new organization
		// driver.findElement(By.name("lastname")).sendKeys(lastName);
		// driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]")).sendKeys(shippingAddress);
		// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verify Header LastName Expected result

		String ActualLastname = cp.getActlast().getText();
		System.out.println(ActualLastname);

		if (ActualLastname.equals(lastName)) {
			System.out.println(lastName + "is created==pass");
		}

		else {

			System.out.println(lastName + "is not created==fail");
		}

		// step 5 logout
		// driver.quit();

	}
}
