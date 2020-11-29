Feature: Verify search
  As a user
  I should search and get appropriate results

Scenario: Validate search with valid data
 Given user is on homepage
  When user enter product in search box
  And click on search icon
  Then user should see products as search results