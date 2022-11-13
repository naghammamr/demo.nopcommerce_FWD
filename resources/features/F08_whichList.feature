@smoke
  Feature: F08 | users can add products to wishlist
    Background:
      Given user click on wishlist button on the HTC mobile product

    Scenario: Verify that the product is added to wishlist successfully
      Then success message is displayed to the user

    Scenario: Verify that wishlist quantity is correct
      When user close the success notification bar
      And user clicks on wishlist link
      Then user can view products quantity added to the wishlist