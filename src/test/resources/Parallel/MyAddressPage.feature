Feature: Address Page Feature

Background:
Given User has already logged in to application
|username|password|
|dastuhin292@gmail.com|Santa1234!|

Scenario: Address Page Title
Given User navigates to Address Page
When User gets title of the page
Then Title should be "Addresses - My Store"

Scenario: Add additional address
Given User navigates to Address Page
When User clicks on Add New Address
And User enters address details
|Ram|
|Sen|
|123 New Road|
|Enfield|
|1|
|11111|
|21|
|8652453596|
|8546321586|
|Other Address|
And User clicks on Save button
Then New Address section header should be "Other Address"

Scenario: Delete new address
Given User navigates to Address Page
Then User deletes the new address