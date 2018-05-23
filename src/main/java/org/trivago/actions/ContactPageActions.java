package org.trivago.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.trivago.objectrepo.ContactPageObjects;
import org.trivago.resources.PrePostSteps;
import org.trivago.resources.Reporter;


public class ContactPageActions {
	
	
	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;	
	
	public ContactPageActions(PrePostSteps obj)
	{
		prePostSteps=obj;
		driver=obj.driver;
		wait=obj.wait;
//		this.test=testReport.test;
	}
	
	public boolean verify_page() {
		
		ContactPageObjects objContact = new ContactPageObjects(driver);
		for (String winHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(winHandle);              
	    }
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(objContact.pageTitle));
		if(objContact.pageTitle.isDisplayed()) {
			Reporter.addStepLog("Contact Page is opened successfully");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean enter_message(String message) {
		
		ContactPageObjects objContact = new ContactPageObjects(driver);
		try {
				objContact.msgBox.sendKeys(message);
				Reporter.addStepLog("Successfully entered the message");
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean enter_name_email(String Name, String email) {
		ContactPageObjects objContact = new ContactPageObjects(driver);
		try {
			objContact.txtFullName.sendKeys(Name);
			objContact.txtEmail.sendKeys(email);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean submit_contact_form() {
		wait = new WebDriverWait(driver, 10);
		ContactPageObjects objContact = new ContactPageObjects(driver);
		try {
				objContact.btnSubmit.click();
				wait.until(ExpectedConditions.visibilityOf(objContact.msgSuccess));
				Reporter.addStepLog("Successfully sent the contact form to Trivago");
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}