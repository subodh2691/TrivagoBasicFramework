Feature: Search a destination on Homepage
  	
  Scenario: Open Home Page and search for any location using search bar
  	Given User landed on Trivago Home Page
  	And Wait for 3000 milli-seconds
  	And User accepts cookies on Home Page
  	When User clicks on search
  	And Wait for 3000 milli-seconds
  	And User enters destination to search "USA"
  	Then User should be able to see search results
  	
  Scenario: Navigate to a destination through the menu on the top left
  	Given User navigates to Trivago Home Page
  	When User clicks on top left menu item
  	And Wait for 5000 milli-seconds
  	And User clicks on a destination "Northeast"
  	Then User should see the page with title having destination "Northeast"
  	And Wait for 5000 milli-seconds
  	When User clicks on top left menu item
  	And User clicks on a destination "International"
  	And Wait for 5000 milli-seconds
  	Then User should see the page with title having destination "International"
  	
  Scenario: Navigate to home page and change the locale
  	Given User navigates to Trivago Home Page
  	When User changes the locale to "Brasil"
  	Then User should be taken to "Brasil" Home page
  	And Wait for 3000 milli-seconds
  	When User changes the locale to "France"
  	Then User should be taken to "France" Home page
  	And Wait for 3000 milli-seconds
  	When User changes the locale to "USA"
  	Then User should be taken to "USA" Home page
  	And Wait for 5000 milli-seconds
  	
  Scenario: Navigate to different pages and verify all the links are working
  	Given User navigates to Trivago Home Page
  	Then Verify all the links should be working in page
  	And Wait for 3000 milli-seconds
  	When User changes the locale to "Brasil"
  	Then User should be taken to "Brasil" Home page
  	And Verify all the links should be working in page
  	When User clicks on search
  	When User changes the locale to "USA"
  	Then User should be taken to "USA" Home page
  	And Verify all the links should be working in page
  	