package org.trivago.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObjects {

	WebDriver driver;
	
	public HomePageObjects (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(css=".search-icon")
	public WebElement searchBar;
	
	@FindBy(xpath="//a[contains(@class,'room5-logo')]")
	public WebElement homePage;
	
	@FindBy(css=".input.search-input")
	public WebElement searchInput;
	
	@FindBy(css=".nav-icon")
	public WebElement navIcon;
	
	@FindBy(id="all_destinations_btn")
	public WebElement btnAllDestinations;
	
	@FindBy(className="locales-dropdown")
	public WebElement optSelectCountry;
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	public WebElement lnkContact;
	
	@FindBy(xpath="//h3//span[contains(text(),'Search Results')]")
	public WebElement searchHeading;
	
	@FindBy(id="confirm")
	public WebElement chkboxAgree;
	
	@FindBy(className="et-email")
	public WebElement txtEmailInput;

	@FindBy(css=".submit")
	public WebElement btnSubmit;
	
	@FindBy(xpath="//p[contains(text(),'You are now checked-in!')]")
	public WebElement msgNewsletterSuccess;
	
	@FindBy(className="Cookie__button")
	public WebElement acceptCookie;
	
	@FindBy(id="articleheader")
	public WebElement articleHeader;
	
	@FindBy(xpath="//h1[@class='section-title main']")
	public WebElement sectionTitle;
	
	@FindBy(xpath="//h2[@class='section-title main']/span")
	public WebElement localePageTitle;
	
	String elemDestination="//a[@class='link'][contains(text(),'place')]"	;
	public WebElement lnkDestination(String Destination) {
        return driver.findElement(By.xpath(elemDestination.replace("place", Destination)));
	}
}
