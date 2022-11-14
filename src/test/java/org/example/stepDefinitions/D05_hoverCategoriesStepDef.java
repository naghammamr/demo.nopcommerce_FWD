package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

public class D05_hoverCategoriesStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user hovers on a main-category")
    public void userHoversOnMainCategory() {
        home.hoverRandomCategory();
    }

    @When("the sub category list open and the user can click on any sub-category")
    public void subCategoryListOpen() {
        home.clickRandomSubCategory();
    }

    @Then("sub-category page will open successfully")
    public void userNavigatedToSelectedSubCategoryPage() {
        SoftAssert sAssert = new SoftAssert();

        String actualTitle = home.getOpenedProductTitle();
        String expectedTitle = Hooks.driver.getCurrentUrl().toLowerCase().trim();

        sAssert.assertTrue(expectedTitle.contains(actualTitle), "Names are not matched");

        sAssert.assertAll();
    }


}
