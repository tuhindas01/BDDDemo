Feature: Contact Us Feature

Background:
Given User has already logged in to application
|username|password|
|dastuhin292@gmail.com|Santa1234!|


Scenario: Contact Us page title
Given User navigates to Contact Us Page
When User gets title of the page
Then Title should be "Contact us - My Store"

Scenario Outline: Contact Us Scenario with different set of data
Given  User navigates to Contact Us Page
When User fills the form from the given sheetname <SheetName> and rownumber <RowNumber>
And User clicks on send button
Then It shows successfull message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|ContactUs|0|
|ContactUs|1|