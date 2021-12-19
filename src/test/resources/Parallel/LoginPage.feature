Feature: Login Page Feature

Scenario: Login Page Title
Given User is on Homepage
When User gets title on Homepage
Then Title should be "Login - My Store"

Scenario: Forgot Password link present
Given User is on Homepage
Then Forgot your password link should be displayed

Scenario: Create an Account button present
Given User is on Homepage
Then Create an Account button should be displayed