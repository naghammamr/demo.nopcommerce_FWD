package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {

    P03_homePage home = new P03_homePage();

    @When("user click on wishlist button on the HTC mobile product")
    public void userCanAddProductToWishlist() {
        //home.wishlistButtonHTC().click();
        home.getProductsWishlistButton().get(2).click();
    }

    @Then("success message is displayed to the user")
    public void verifyThatProductAddedSuccessfully() {
        SoftAssert sAssert = new SoftAssert();

        String actualMsgColor = home.getSuccessMsgColor();
        String expectedSuccessMsgColor = "rgba(75, 176, 122, 1)";
        sAssert.assertTrue(actualMsgColor.contains(expectedSuccessMsgColor), "Invalid rgba");

        sAssert.assertTrue(home.successMsg().contains("The product has been added to your wishlist"), "Invalid Success Message");
        sAssert.assertTrue(home.successMsgDisplay(), "Product add to wish list message wasn't displayed");

        sAssert.assertAll();
    }

    @When("user close the success notification bar")
    public void userCloseNotificationBar() {
        home.closeNotificationIcon().click();
    }

    @And("user clicks on wishlist link")
    public void userCanClickOnWishlistLink()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(home.wishListLink()));
        home.wishListLink().click();
    }

    @Then("user can view products quantity added to the wishlist")
    public void userCanViewProductsQty()
    {
        int productQTY = Integer.parseInt(home.getWishlistProductsQTY());
        Assert.assertTrue(productQTY > 0);
    }
}
