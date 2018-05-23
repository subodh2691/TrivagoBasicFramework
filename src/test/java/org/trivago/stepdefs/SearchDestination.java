package org.trivago.stepdefs;

import org.trivago.resources.PrePostSteps;
import org.trivago.actions.HomePageActions;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class SearchDestination 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public SearchDestination (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@When("^User clicks on search$")
	public void click_search_icon()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User unable to click on search", actionHome.click_search_bar());
	}
	
	@When("^User enters destination to search \"([^\"]*)\"$")
	public void enter_destination_to_search(String destination)
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User is unable to input a destination in search", actionHome.search_destination_in_search_bar(destination));
	}
	
	@Then("^User should be able to see search results$")
	public void verify_search_results()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User landed on incorrect page", actionHome.verify_search_heading());
	}
	
	@When("^User clicks on top left menu item$")
	public void click_menu()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User is unable to click on menu", actionHome.clickMenu());
	}
	
	@When("^User clicks on a destination \"([^\"]*)\"$")
	public void select_destination(String destination)
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User is unable to select a destination or its not present", actionHome.selectDestination(destination));
	}
	
	@Then("^User should see the page with title having destination \"([^\"]*)\"$")
	public void check_destination_page_title(String title)
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("Page shown doesn't have the desired title", actionHome.check_destination_page(title));
	}
	
	@When("^User changes the locale to \"([^\"]*)\"$")
	public void change_locale(String locale) 
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User unable to change the locale", actionHome.select_locale(locale));
	}
	
	@When("^User should be taken to \"([^\"]*)\" Home page$")
	public void	verify_locale_page_load(String locale) 
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User landed on different locale page", actionHome.verify_locale_page(locale));
	}
	
	@Then("^Verify all the links should be working in page$")
	public void verify_links_href() 
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("Got error while validating some of the links on web page", actionHome.verifyURLStatus());
	}
	
}
