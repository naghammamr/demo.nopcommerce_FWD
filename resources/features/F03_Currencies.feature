@smoke
Feature: F03_Currencies | users could select Euro currency from the dropdown list on the home page

  Scenario: user could select Euro currency from home page
    Given user open the currency drop down at home page and select Euro option
    Then Euro symbol is displayed on all products

