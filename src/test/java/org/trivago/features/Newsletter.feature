Feature: NewsLetter subscription on Homepage

  Scenario: Open Home page and verify the newsletter subscription
  	Given User landed on Trivago Home Page
  	And Wait for 3000 milli-seconds
  	And User accepts cookies on Home Page
  	And Wait for 3000 milli-seconds
  	When User enters the email id "test@test.com"
  	Then User should get error when check box is unchecked

  Scenario: Open Home page and verify the newsletter subscription
  	Given User landed on Trivago Home Page
  	And Wait for 3000 milli-seconds
  	When User enters the email id "test@test.com"
  	And User checks on the agree to recieve mail for newsletter
  	Then User should be able to subscribe the newsletter using entered mail