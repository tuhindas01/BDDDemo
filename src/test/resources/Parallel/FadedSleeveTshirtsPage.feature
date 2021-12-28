Feature: Faded Sleeve Tshirts Page Feature

Background:
Given User has already logged in to application
|username|password|
|dastuhin292@gmail.com|Santa1234!|

Scenario: Get on Faded Sleeve Tshrit Price
Given User navigates to Faded Sleeve Tshrit Page
When User gets the product price
Then The price should be "$16.51"
