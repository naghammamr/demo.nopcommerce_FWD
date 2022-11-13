@smoke
  Feature: F06_HomePageSliders

    Scenario: Verify that the first slider is clickable on home page
      Given the user clicks on the first slider on the home page
      Then user will be redirected to the nokia Lumia product page

    Scenario: Verify that the second slider is clickable on home page
      Given the user change to the second slider
      When user clicks on the second slider on the home page
      Then user will be redirected to the iphone6 product page