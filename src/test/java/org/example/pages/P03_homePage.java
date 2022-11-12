package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_homePage {

    By registerLinkLocator = By.xpath("//a[contains(.,'Register')]");
    By loginLinkLocator = By.linkText("Log in");
    By myAccountLinkLocator = By.linkText("My account");
    By currencyDDL = By.id("customerCurrency");
    By products = By.xpath("//span[@class='price actual-price']");

    public WebElement registerLink() {
        return Hooks.driver.findElement(registerLinkLocator);
    }

    public WebElement loginLink() {
        return Hooks.driver.findElement(loginLinkLocator);
    }

    public WebElement myAccountTab() {
        return Hooks.driver.findElement(myAccountLinkLocator);
    }

    public void selectCurrency(String currency) {

        Select select = new Select(Hooks.driver.findElement(currencyDDL));
        select.selectByVisibleText(currency);
    }

    public String[] getProductsCurrency()
    {
        List<WebElement> productsPricesCurrency = Hooks.driver.findElements(products);
        String[] productPrice = new String[productsPricesCurrency.size()];

        for (int x = 0; x < productsPricesCurrency.size(); x++) {
            productPrice[x] = productsPricesCurrency.get(x).getText();
            System.out.println(productPrice);
        }
        return productPrice;
    }

}

