package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concast.crm.generic.webdriverutility.UtilityClassObject;

public class HomePage {
	WebDriver driver ;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (linkText="Products")
	private WebElement productLink;
	
	public WebElement getproductLink() {
		return productLink;
		
	}
	
	
	@FindBy (linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy (linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy (linkText="Campaigns")
	private WebElement CampaignLink;
	
	@FindBy (linkText="More")
	private WebElement MoreLink;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy (linkText="Sign Out")
	private WebElement SignoutLink;
	
	public  WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	public void navigateToCampaginPage() {
			Actions action= new Actions(driver);
			action.moveToElement(MoreLink).perform();
			CampaignLink.click();
		
			
		}
	public void logout() {
		Actions action= new Actions(driver);
		action.moveToElement(adminImg).perform();
		SignoutLink.click();
	}

}
