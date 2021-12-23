Feature: Personal Infromation Feature

Background:
Given User has already logged in to application
|username|password|
|dastuhin292@gmail.com|Santa1234!|

Scenario: Personal Information Page Title
Given User navigates to Personal Information Page
When User gets title of the page
Then Title should be "Identity - My Store"

@SmokeTest
Scenario: Validate Personal Information
Given User navigates to Personal Information Page
Then User validates Personal Information details
|Santa|
|Das|
|dastuhin292@gmail.com|
|5|
|1|
|1994|