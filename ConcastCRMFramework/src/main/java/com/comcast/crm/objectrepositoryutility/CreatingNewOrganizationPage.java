package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	private static final String industry = null;


	WebDriver driver;
	public CreatingNewOrganizationPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);}
	
	@FindBy(name= "accountname")
	private WebElement orgNameEdt;
	
	
	@FindBy(xpath= "(//textarea[@class='detailedViewTextBox'])[2]")
	private WebElement shippingAddEdt;

	@FindBy(xpath= "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industrys;
	

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getShippingAddEdt() {
		return shippingAddEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
public WebElement getIndustrys() {
		return industrys;
	}

public void createOrg(String orgName,String shippingAddress, String industry)
{
	orgNameEdt.sendKeys(orgName);
	Select sel= new Select(industrys);
	sel.selectByVisibleText(industry);
	
	shippingAddEdt.sendKeys(shippingAddress);
	
	saveBtn.click();
}
@FindBy(name="accounttype")
private WebElement Acctype;

public WebElement getacctype() {
	return Acctype;
	
}

@FindBy(id="dtlview_Industry")
private WebElement actIndus;

public WebElement getActIndus() {
	return actIndus;
}
@FindBy(id="dtlview_Type")
private WebElement ActType;

public WebElement getacttype() {
	return ActType;
}


}