package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;

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

    @Then("then the user will be redirected to the sub-category page")
    public void userNavigatedToSelectedSubCategoryPage() {

    }


}
