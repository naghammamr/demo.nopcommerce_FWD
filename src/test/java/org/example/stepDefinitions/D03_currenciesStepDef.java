package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D03_currenciesStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user open the currency drop down at home page and select Euro option")
    public void userSelectEuroOption() {
        home.selectCurrency("Euro");
    }

    @Then("Euro symbol is displayed on all products")
    public void productsCurrencyIsEuro()
    {
        for(String priceCurrency : home.getProductsCurrency())
        {
            Assert.assertTrue(priceCurrency.contains("€"),"Invalid Currency");
        }
    }


}