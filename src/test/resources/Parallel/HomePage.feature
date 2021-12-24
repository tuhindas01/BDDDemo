Feature: Home Page Feature

Background:
Given User has already logged in to application
|username|password|
|dastuhin292@gmail.com|Santa1234!|

Scenario: Home Page Title
Given User navigates to Home Page
When User gets title of the page
Then Title should be "My Store"

@SmokeTest
Scenario: Click on T-Shirt Link
Given User navigates to Home Page
When User clicks on Tshirt link