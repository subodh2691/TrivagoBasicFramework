package org.trivago.actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.trivago.objectrepo.HomePageObjects;
import org.trivago.resources.PrePostSteps;
import org.trivago.resources.Reporter;

import com.gargoylesoftware.htmlunit.Page;

public class HomePageActions {

	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePageActions(PrePostSteps obj) {
		prePostSteps = obj;
		driver = obj.driver;
		wait = obj.wait;
		// this.test=testReport.test;
	}

	public boolean click_search_bar() {
		HomePageObjects homeObject = new HomePageObjects(driver);
		wait = new WebDriverWait(driver, 30);
		try {
			if (homeObject.searchBar.isDisplayed()) {
				homeObject.searchBar.click();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean search_destination_in_search_bar(String destination) {
		HomePageObjects homeObject = new HomePageObjects(driver);
		wait = new WebDriverWait(driver, 30);
		try {
			if (homeObject.searchInput.isDisplayed()) {
				WebElement input = homeObject.searchInput;
				input.sendKeys(destination);
				input.sendKeys(Keys.ENTER);
				wait.until(ExpectedConditions.visibilityOf(homeObject.searchHeading));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean verify_search_heading() {
		HomePageObjects homeObject = new HomePageObjects(driver);
		
		if (homeObject.searchHeading.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean enter_email_to_subscribe(String email) {
		HomePageObjects homeObject = new HomePageObjects(driver);
		try {
			if(homeObject.txtEmailInput.isDisplayed()) {
				homeObject.txtEmailInput.clear();
				homeObject.txtEmailInput.sendKeys(email);
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean check_agree_terms() {
		HomePageObjects homeObject = new HomePageObjects(driver);
		try {
			if(homeObject.chkboxAgree.isDisplayed()) {
				homeObject.chkboxAgree.click();
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean subscribe_news_letter() {
		HomePageObjects homeObject = new HomePageObjects(driver);
		wait = new WebDriverWait(driver, 10);
		try {

			if (homeObject.btnSubmit.isDisplayed()) {
				homeObject.btnSubmit.click();
				wait.until(ExpectedConditions.visibilityOf(homeObject.msgNewsletterSuccess));
				Reporter.addStepLog("Successfully created newsletter");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean click_contact_us() {
		HomePageObjects homeObject = new HomePageObjects(driver);
		if (homeObject.lnkContact.isDisplayed()) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,300)", "");
			homeObject.lnkContact.click();
			return true;
		} else {
			Reporter.addStepLog("Unable to click on contact");
			return false;
		}
	}

	public boolean verify_page_title() {
		
		if (driver.getTitle().contains("Room5")) {
			Reporter.addStepLog("User landed on trivago home page successfully");
			return true;
			
		} else {
			Reporter.addStepLog("User landed on different page");
			return false;
		}
	}
	
	public boolean click_accept_cookies() {
		HomePageObjects homeObject = new HomePageObjects(driver);
		if(homeObject.acceptCookie.isDisplayed()) {
			homeObject.acceptCookie.click();
			Reporter.addStepLog("User accepted cookies successfully");
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean navigate_home() {
		wait = new WebDriverWait(driver, 30);
		HomePageObjects homeObject = new HomePageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(homeObject.homePage));
		if (homeObject.homePage.isDisplayed()){
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			homeObject.homePage.click();
			wait.until(ExpectedConditions.visibilityOf(homeObject.lnkContact));
			return true;
		}
		else {
			Reporter.addStepLog("Unable to navigate to home page");
			return false;
		}
	}
	
	public boolean clickMenu() {
		wait = new WebDriverWait(driver, 30);
		HomePageObjects homeObject = new HomePageObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(homeObject.navIcon));
		if(homeObject.navIcon.isDisplayed()) {
			homeObject.navIcon.click();
			return true;
		}
		else {
			Reporter.addStepLog("Unable to click on Menu");
			return false;
		}
	}
	
	public boolean selectDestination(String destination) 
	{
		HomePageObjects homeObject = new HomePageObjects(driver);
		wait = new WebDriverWait(driver, 30);
		try{
			WebElement place = homeObject.lnkDestination(destination);
			
			if (place.isDisplayed()) {
				Thread.sleep(300);
				place.click();
				wait.until(ExpectedConditions.visibilityOf(homeObject.sectionTitle));
				return true;
			}
			else {
				Reporter.addStepLog("Entered destination is not displayed on webPage");
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public boolean check_destination_page(String title)
	{
		String PageTitle = driver.getTitle();
		if(PageTitle.contains(title)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void pause_execution(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public boolean select_locale(String locale)
	{
		HomePageObjects homeObject = new HomePageObjects(driver);
		if(homeObject.optSelectCountry.isDisplayed()) {
			Select drpdwnCountry = new Select(homeObject.optSelectCountry);
			drpdwnCountry.selectByVisibleText(locale);
			return true;
		}
		else {
			Reporter.addStepLog("Unable to select the locale/incorrect locale");
			return false;
		}	
	}
	
	public boolean verify_locale_page(String locale)
	{
		HomePageObjects homeObject = new HomePageObjects(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homeObject.localePageTitle));
		String CurrentURL = driver.getCurrentUrl();
		Select drpdwnCountry = new Select(homeObject.optSelectCountry);
		WebElement selected_locale = drpdwnCountry.getFirstSelectedOption();
		String CountryURL = selected_locale.getAttribute("value");
		System.out.println(CurrentURL);
		System.out.println(CountryURL);
		if(CurrentURL.contains(CountryURL))
		{
			return true;
		}
		else {
			Reporter.addStepLog("User landed on wrong page");
			return false;
		}
	}
	
	public boolean verifyURLStatus()
	{
		List<WebElement> list=driver.findElements(By.xpath("//*[@href]"));
		
		for(int i=0;i<list.size();i++)
		{
			String url=list.get(i).getAttribute("href").trim();	
		    HttpClient client = HttpClientBuilder.create().build();
		    HttpGet request = new HttpGet(url);
		    try 
		    {
		        HttpResponse response = client.execute(request);
		        // verifying response code and The HttpStatus should be 200 if not,
		        // increment invalid link count
		        // We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
	
		        if (response.getStatusLine().getStatusCode() != 200)
		        {
			        System.out.println("Link not working : "+url+" , Response code : "+response.getStatusLine().getStatusCode());
			        return false;
		        }
		        else {
		        	System.out.println("Clicked on link : "+url+" and got response : "+response.getStatusLine().getStatusCode());
		        }
		    } catch (Exception e) 
		    {
		        e.printStackTrace();
		    }
		}
		Reporter.addStepLog("Successfully verified all the links");
		return true;
	}

}
