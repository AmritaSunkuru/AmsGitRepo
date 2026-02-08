Feature: Search and place the order for Products
@OffersPage
Scenario Outline: Search experiece for product search in both home and offers page
Given User is on Greenkart Landing page
When User searched with Shortname <VegetableName> and extracted actual name of product
Then User searched for <VegetableName> shortname in offers page to check if product exists
And Validate product name in offers page matches with Landing page
Examples:
|VegetableName|
|Tom|
|Beet|
|Yam|
|Noodles|
