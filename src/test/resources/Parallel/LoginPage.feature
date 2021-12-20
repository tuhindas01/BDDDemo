Feature: Login Page Feature

Scenario: Login Page Title
Given User is on Homepage
When User gets title of the page
Then Title should be "Login - My Store"

Scenario: Forgot Password link present
Given User is on Homepage
Then Forgot your password link should be displayed

Scenario: Create an Account button present
Given User is on Homepage
Then Create an Account button should be displayed

Scenario: Login with correct credentials
Given User is on Homepage
When User enters username "dastuhin292@gmail.com"
And User enters password "Santa1234!"
And User clicks on Login button
Then User gets title of the page
And Title should be "My account - My Store"