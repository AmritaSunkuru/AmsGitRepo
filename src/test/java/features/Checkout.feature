Feature: Place the order for Products
@PlaceOrder
Scenario Outline: Search experiece for product search in both home and offers page
Given User is on Greenkart Landing page
When User searched with Shortname <VegetableName> and extracted actual name of product
And Added <Quantity> items to the selected product to the cart
Then User proceeds to Checkout and validate the <VegetableName> items in checkout page
And verify user has ability to enter promo code and place the order
 
Examples:
|VegetableName|Quantity|
|Tom          |3       |

