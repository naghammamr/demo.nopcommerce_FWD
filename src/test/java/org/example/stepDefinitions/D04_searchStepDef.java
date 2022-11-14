package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D04_searchStepDef {

    P03_homePage home = new P03_homePage();
    SoftAssert sAssert = new SoftAssert();

    @Given("user specify search with {string} in the search field")
    public void specifySearchText(String arg0) {
        home.enterSearchValue(arg0);
    }

    @When("user click on search button")
    public void clickSearchButton() {

        home.clickSearchButton().click();
    }

    @Then("user could find {string} in relative results")
    public void userCanViewSearchResults(String arg0)
    {
        for (String productName : home.getProductName())
        {
            String actualURL = "https://demo.nopcommerce.com/search?q=";
            String expectedURL = Hooks.driver.getCurrentUrl();
            sAssert.assertTrue(expectedURL.contains(actualURL),"Invalid URL");

            sAssert.assertTrue(productName.contains(arg0), "Invalid Search Results");

            sAssert.assertAll();
        }
    }

    @Then("user click on product name to view product detail once search results are displayed")
    public void userClickOnProductName()
    {
        Assert.assertEquals(home.getProductsCount(),1);
        home.openProductDetail().click();
    }

    @And("user could find {string} in product detail page")
    public void userCanFindSKUValue(String arg0) {

        String actualSKU = home.getProductSKU();
        String expectedSKU = arg0;

        Assert.assertEquals(actualSKU,expectedSKU);
    }

}
