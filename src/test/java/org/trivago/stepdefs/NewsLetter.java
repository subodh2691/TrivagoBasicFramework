package org.trivago.stepdefs;

import org.trivago.resources.PrePostSteps;
import org.trivago.actions.HomePageActions;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class NewsLetter 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public NewsLetter (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@When("^User enters the email id \"([^\"]*)\"$")
	public void enter_email_to_subscribe(String email)
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User unable to enter email id",actionHome.enter_email_to_subscribe(email));
	}
	
	@When("^User checks on the agree to recieve mail for newsletter$")
	public void click_agree_check_box()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User unable to click on \"Agree\" check box",actionHome.check_agree_terms());
	}
	
	@Then("^User should be able to subscribe the newsletter using entered mail$")
	public void subscribe_to_newsletter()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User unable to subscribe the newsletter",actionHome.subscribe_news_letter());
	}
	
	@Then("^User should get error when check box is unchecked$")
	public void subscribe_without_terms()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertFalse("User unable to subscribe the newsletter",actionHome.subscribe_news_letter());
	}
	
	@Given("^User landed on Trivago Home Page$")
	public void validate_home_page()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User landed on incorrect page", actionHome.verify_page_title());
	}
	
	@And("^User accepts cookies on Home Page")
	public void accept_cookies_home_page()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User is unable to accept cookies", actionHome.click_accept_cookies());
	}
	
	@Given("^User navigates to Trivago Home Page$")
	public void navigate_to_home_page()
	{
		HomePageActions actionHome = new HomePageActions(prePostSteps);
		Assert.assertTrue("User unable to navigate to home page", actionHome.navigate_home());
	}
	
	@Given("^Wait for (\\d+) milli-seconds$")
	public void wait_app(int milliSec)
	{

		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
