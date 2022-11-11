package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_Home;
import org.example.pages.P01_Register;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P00_Home home = new P00_Home();
    P01_Register registerObj = new P01_Register();

    @Given("user go to register page")
    public void goRegisterPage() {
        home.registerLink().click();
    }

    @When("user select gender type")
    public void selectGender() {
        registerObj.selectGender();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enterFirstAndLastName(String first_name, String last_name) {
        registerObj.setFirstName(first_name);
        registerObj.setLastName(last_name);
    }

    @And("user enter date of birth")
    public void enterDOB()
    {
        registerObj.setDOB(17,11,"1997");
    }

    @And("^user enter email \"(.*)\" field and fills Password fields \"(.*)\" and \"(.*)\"$")
    public void enterEmailAndPasswords(String email, String password, String confirmPassword)
    {
        registerObj.setEmail(email);
        registerObj.setPasswordFields(password,confirmPassword);
    }

    @And("user clicks on register button")
    public void userClickRegisterButton() {
        registerObj.registerButton().click();
    }

    @Then("success message is displayed")
    public void userSuccessfullyRegistered()
    {
        SoftAssert soft = new SoftAssert();

        String actualMsg = "Your registration completed";
        String ExpectedMsg = registerObj.getSuccessMsg();

        soft.assertEquals(actualMsg.contains(ExpectedMsg), true, "Invalid Actual Registration Message!");

        String actualMsgColor = registerObj.getSuccessMsgColor();
        String expectedSuccessMsgColor = "rgba(76, 177, 124, 1)";

        soft.assertTrue(actualMsgColor.contains(expectedSuccessMsgColor), "Invalid rgba");

        soft.assertAll();
    }

}

