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
	/**
	 * 
		Created By: Subodh Agnihotri
		Method Name: verify_page. Verifies contact page
		Return Type: boolean
		Date Created: 24-May-2018
	*
	 */
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
	/**
	 * 
		Created By: Subodh Agnihotri
		Method Name: enter_message. Enters the given message in message box of contact page
		Return Type: boolean
		Date Created: 24-May-2018
	*
	 */
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
	
	/**
	 * 
		Created By: Subodh Agnihotri
		Method Name: enter_name_email. Enters Full name and Email in respective text boxes
		Return Type: boolean
		Date Created: 24-May-2018
	*
	 */
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
	
	/**
	 * 
		Created By: Subodh Agnihotri
		Method Name: submit_contact_form. Submits the contact form
		Return Type: boolean
		Date Created: 24-May-2018
	*
	 */
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