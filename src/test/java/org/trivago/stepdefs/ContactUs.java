package org.trivago.stepdefs;

import org.trivago.resources.PrePostSteps;
import org.trivago.actions.ContactPageActions;
import org.trivago.actions.HomePageActions;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class ContactUs 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public ContactUs (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@When("^User clicks on contact link in home page$")
	public void click_contact_link()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User unable to click on contact link",actionHome.click_contact_us());
	}
	
	@When("^Wait till contact page opens$")
	public void wait_contact_page_load()
	{
		ContactPageActions actionContact = new ContactPageActions(prePostSteps);
		Assert.assertTrue("Not landed on contact page",actionContact.verify_page());
	}
	
	@And("^User enters message in message box \"([^\"]*)\"$")
	public void enter_message(String message)
	{
		ContactPageActions actionContact = new ContactPageActions(prePostSteps);
		Assert.assertTrue("User unable to subscribe the newsletter",actionContact.enter_message(message));
	}
	
	@And("^User enters name as \"([^\"]*)\" and email as \"([^\"]*)\"$")
	public void enter_name_email(String name, String email)
	{
		ContactPageActions actionContact = new ContactPageActions(prePostSteps);
		Assert.assertTrue("User unable to enter name and email",actionContact.enter_name_email(name, email));
	}
	
	@And("^User should be able to submit the form successfully$")
	public void click_submit_form()
	{
		ContactPageActions actionContact = new ContactPageActions(prePostSteps);
		Assert.assertTrue("User unable to subscribe the newsletter",actionContact.submit_contact_form());
	}
	
}
