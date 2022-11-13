package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {

    P03_homePage home = new P03_homePage();
    WebDriverWait wait;

    @Given("the user clicks on the first slider on the home page")
    public void clickOnFirstSlider() {
        home.firstSliderLink().click();
//        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.attributeContains(home.getCurrentSlider().get(0), "style", "display: block;"));
//        home.getCurrentSlider().get(0).click();
    }

    @Then("user will be redirected to the nokia Lumia product page")
    public void userRedirectedToNokiaPage() {
        String expectedURL = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualURL = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Invalid Navigation!");
    }

    @Given("the user change to the second slider")
    public void userChangeToSecondSlider() {
        home.changeToSecondSlider().click();
    }

    @When("user clicks on the second slider on the home page")
    public void clickOnSecondSlider() {
        home.secondSliderLink().click();
//        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.attributeContains(home.getCurrentSlider().get(0), "style", "display: block;"));
//        home.getCurrentSlider().get(1).click();
    }

    @Then("user will be redirected to the iphone6 product page")
    public void userRedirectedToIphonePage()
    {
        String expectedURL = "https://demo.nopcommerce.com/iphone-6";
        String actualURL = Hooks.driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL, "Invalid Navigation!");
    }


}