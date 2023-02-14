Feature: Testing the search and ordering the mobile device on flipkart page

Scenario: Verifying the ordering of ipad and placing the order

Given user opens the flipkart page
Then user types "ipad" in the search box
When suggestions are displayed select one of them
Then on results page filter all results by the "Wi-Fi Only" filter
Then select one of the results
Then Checkout the order
Then Place the order
Then Enter Random Email and Phone number