package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver ;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy (id="phone")
	private WebElement Phnumber;
	
	public WebElement getphnumber() {
		return Phnumber;
	}
	@FindBy (id="dtlview_Phone")
	private WebElement actphone;
	
	public WebElement getActphone() {
		return actphone;
		
	}
	
	@FindBy (className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy (id="mouseArea_Organization Name")
	private WebElement ActOrgnam123;
	
	public WebElement getActOrgnam123() {
		return ActOrgnam123;
			}
	
	public void clickOnOrgName(String orgName) {

        driver.findElement(
       By.xpath("//a[text()='" + orgName + "']")
        ).click();
    }
	
	public void selandDel(String orgName) {

	    driver.findElement(
	        By.xpath("//a[text()='" + orgName + "']/ancestor::tr//a[contains(text(),'del')]")
	    ).click();
	}
}
