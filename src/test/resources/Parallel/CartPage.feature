Feature: Cart Page Feature

Background:
Given User has already logged in to application
|username|password|
|dastuhin292@gmail.com|Santa1234!|

Scenario: Add to Cart of Fadded Sleeve Tshirt
Given User navigates to Faded Sleeve Tshrit Page
When User enters product specifications
|quantity|size|color|
|1|M|Blue|
And User clicks on Add to Cart button
And User clicks on Proceed to Checkout
And User gets title of the page
Then Title should be "Order - My Store"
And The "Faded Short Sleeve T-shirts" should be added on the cart
And User clicks on continue shopping

Scenario: Place an Order
Given User add a product to cart
|quantity|size|color|
|1|M|Blue|
And User plces an order
And User gets title of the page
Then Title should be "Order confirmation - My Store"
And User gets confirmed order details
