@smoke
Feature: F03_Currencies | users could select Euro currency from the dropdown list on the home page

  Scenario: user could select Euro currency from home page
    Given user open the currency drop down at home page and select Euro option
    Then Euro symbol is displayed on all products

#  1- Select Euro currency from the dropdown list on the top left of home page
#  2- Use hard assertion to verify Euro Symbol (€) is shown on the 4 products displayed in Home page
#  in this step you should create for loop
#  2.1- use findElements with get(i) method then use getText()
#  2.2- save the output inside variable
#  2.3- do hard assert to verify that the variable contains "€"
