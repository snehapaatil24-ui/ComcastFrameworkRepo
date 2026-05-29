package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver= null;
	public ContactPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	public WebElement getStartDate() {
		return startDate;
		
		
	}
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	public WebElement getEndDate() {
		return endDate;	
	}
	
	@FindBy (id="dtlview_Support Start Date")
	private WebElement Supportstart;
	
	public WebElement getsupportStart() {
		return Supportstart;
	}
	@FindBy (id="dtlview_Support End Date")
	private WebElement Supportend;
	
	public WebElement getsupportEnd() {
		return Supportend;
	}
	
	@FindBy(xpath= "//img[@title='Create Contact...']")
	private WebElement CreatenewcontactBtn;
	
	@FindBy (name="lastname")
	private WebElement LastNametext;
	
	@FindBy (xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	@FindBy (id="dtlview_Last Name")
	private WebElement Actlast;
	
	@FindBy (xpath=("//input[@name='account_name']/following-sibling::img"))
	private WebElement OrgImgBtn;
	
	public WebElement getOrgImgBtn() {
		return OrgImgBtn;
		
	}
	
	
	public WebElement getActlast() {
		return Actlast;
		
	}
	
	public WebElement getCreatenewcontactBtn() {
		return CreatenewcontactBtn;
	}	
		public WebElement getLastNametext() {
			return LastNametext;
		}
		
		public WebElement getSaveBtn() {
			return SaveBtn;
		}
		@FindBy(name="search")
		private WebElement Searchorg;
		
		public WebElement getSearchorg() {
			return Searchorg;
			
			
		}
		
		
	}

	

