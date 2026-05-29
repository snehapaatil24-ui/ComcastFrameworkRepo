package com.concast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String WindowID = it.next();
			driver.switchTo().window(WindowID);
			
			String actUrl= driver.getCurrentUrl();
		if(actUrl.contains(partialURL)) {
			break;
		}	
	}
	}
	 public void acceptAlert(WebDriver driver) {
	        Alert alt = driver.switchTo().alert();
	        alt.accept();
	    }
		public void selectDropdown(WebElement element, String text) {
	        Select s = new Select(element);
	        s.selectByVisibleText(text);
	    }
}
	
	