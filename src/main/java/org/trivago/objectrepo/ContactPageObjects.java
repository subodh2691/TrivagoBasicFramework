package org.trivago.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactPageObjects {

	WebDriver driver;
	
	public ContactPageObjects (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//public String frmAdmin = "_nice_admin_portlet_WAR_platformuseradminportlet_iframe";
		
	@FindBy(className="contact-msg")
	public WebElement msgBox;
	
	@FindBy(xpath="//span[contains(text(),'Your Email')]/preceding::input[@class='contact-input']")
	public WebElement txtFullName;
	
	@FindBy(id="contact-email")
	public WebElement txtEmail;
	
	@FindBy(className="contact-submit")
	public WebElement btnSubmit;
	
	@FindBy(xpath="//h2/span[contains(text(),'feedback')]")
	public WebElement pageTitle;
	
	@FindBy(xpath="//div[contains(text(),'Success')]")
	public WebElement msgSuccess;
}
