@smoke
  Feature: F07_FollowUs | users could open followUs links

    Scenario: Verify that the user opens facebook link
      Given user click on facebook link from the footer
      Then "https://www.facebook.com/nopCommerce" is opened in new tab

    Scenario: Verify that the user opens twitter link
      Given user click on twitter link from the footer
      Then "https://twitter.com/nopCommerce" is opened in new tab

    Scenario: Verify that the user opens rss link
      Given user click on rss link from the footer
      Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

    Scenario: Verify that the user opens youtube link
      Given user click on youtube link from the footer
      Then "https://www.youtube.com/user/nopCommerce" is opened in new tab