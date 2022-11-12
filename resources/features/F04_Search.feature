@smoke
  Feature: F04_Search | user will be able to search for products with different parameters

    Scenario Outline: user could search using product name
      Given user specify search with "<productName>" in the search field
      When user click on search button
      Then user could find "<productName>" in relative results
      Examples:
        |productName|
        |book|
        |laptop|
        |nike|

    Scenario Outline: user could search for product using sku
      Given user specify search with "<sku>" in the search field
      When user click on search button
      Then user click on product name to view product detail once search results are displayed
      And user could find "<sku>" in product detail page
      Examples:
        |sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|