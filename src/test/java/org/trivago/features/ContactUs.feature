Feature: Contact Us Page Verification

  Scenario: Open Contact page and verify if user successfully able to send contact form
  	Given User landed on Trivago Home Page
  	And User accepts cookies on Home Page
  	And Wait for 3000 milli-seconds
  	When User clicks on contact link in home page
  	And Wait till contact page opens
  	And User enters message in message box "Trivago is beautiful"
  	And User enters name as "Subodh Agnihotri" and email as "test@test.com"
  	Then User should be able to submit the form successfully
  	