package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.pages.P02_Login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P03_homePage home = new P03_homePage();
    P02_Login login = new P02_Login();
    SoftAssert sAssert = new SoftAssert();

    @Given("user go to login page")
    public void goLoginPage() {
        home.loginLink().click();
    }

    @When("^user login with \"(.*)\" email: \"(.*)\" and password: \"(.*)\"$")
    public void userEnterEmailAndPassword(String type, String email, String password) {
        String scenarioType = type;
        login.enterEmailAndPassword(email, password);
    }

    @And("user clicks on login button")
    public void userClickLoginBtn() {
        login.clickLoginButton().click();
    }

    @Then("user is logged to the system successfully")
    public void userLoggedIn() {
        sAssert = new SoftAssert();
        String currentHomePageURL = Hooks.driver.getCurrentUrl();
        sAssert.assertEquals(currentHomePageURL, "https://demo.nopcommerce.com/", "Invalid URL!");
        sAssert.assertTrue(home.myAccountTab().isDisplayed(), "Invalid Login!");
        sAssert.assertAll();
    }

    @Then("user could not login to the system")
    public void userFailedToLogin() {

        String actualErrorMsg = login.getFailedLoginErrorMsg();
        String expectedErrorMsg = "Login was unsuccessful.";
        sAssert.assertTrue(actualErrorMsg.contains(expectedErrorMsg),"Error message text is wrong");

        String errorMsgColor = login.getFailedLoginErrorMsgColor();
        String expectedErrorMsgColor = Color.fromString("rgba(228, 67, 75, 1)").asHex();
        String actualErrorMsgColor = Color.fromString(errorMsgColor).asHex();
        System.out.println("Expected is: " + expectedErrorMsgColor + " ,And Actual is: " + actualErrorMsgColor);

        sAssert.assertEquals(actualErrorMsgColor, expectedErrorMsgColor, "Invalid Message color!");


    }

}