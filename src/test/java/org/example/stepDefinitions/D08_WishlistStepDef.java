package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D08_WishlistStepDef {

    P03_homePage home = new P03_homePage();

    @When("user click on wishlist button on the HTC mobile product")
    public void userCanAddProductToWishlist() {

    }

    @Then("success message is displayed to the user")
    public void verifyThatProductAddedSuccessfully() {

    }
}
