Feature: Accounts Page Feature

Background:
Given User has already logged in to application
|username|password|
|dastuhin292@gmail.com|Santa1234!|

Scenario: Account Page Title
Given User is on Accounts Page
When User gets title of the page
Then Title should be "My account - My Store"

Scenario: Accounts Section Count
Given User is on Accounts Page
Then User gets Account Section Details
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Accounts section count should be 5

@SmokeTest
Scenario: Footer Link Details
Given User is on Accounts Page
Then User prints all the footer links
