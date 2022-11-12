package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class P03_homePage {

    By registerLinkLocator = By.xpath("//a[contains(.,'Register')]");
    By loginLinkLocator = By.linkText("Log in");
    By myAccountLinkLocator = By.linkText("My account");
    By currencyDDL = By.id("customerCurrency");
    By products = By.xpath("//span[@class='price actual-price']");
    By searchFieldLocator = By.id("small-searchterms");
    By searchBtnLocator = By.xpath("//button[@class='button-1 search-box-button']");

    //Search Results Page
    By productNameLocator = By.xpath("//h2[@class='product-title']//a");
    //end search results page/

    //product detail Page
    By productSKULocator = By.xpath("//div[@class='sku']//span[@class='value']");
    //end product detail page/

    By mainCategoryLocator = By.cssSelector("ul[class='top-menu notmobile']>li>a");
    By subCategoryLocator = By.xpath("//ul[@class='sublist first-level']//li//a");

    Actions hover = new Actions(Hooks.driver);

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

    public String[] getProductsCurrency() {

        List<WebElement> productsPricesCurrency = Hooks.driver.findElements(products);
        String[] productPrice = new String[productsPricesCurrency.size()];

        for (int x = 0; x < productsPricesCurrency.size(); x++) {
            productPrice[x] = productsPricesCurrency.get(x).getText();
            System.out.println(productPrice);
        }

        return productPrice;
    }

    public void enterSearchValue(String searchKeyword) {
        Hooks.driver.findElement(searchFieldLocator).sendKeys(searchKeyword);
    }

    public WebElement clickSearchButton() {
        return Hooks.driver.findElement(searchBtnLocator);
    }

    public String[] getProductName() {

        List<WebElement> productsNames = Hooks.driver.findElements(productNameLocator);

        String[] product_name = new String[productsNames.size()];

        for (int x = 0; x < productsNames.size(); x++) {
            product_name[x] = productsNames.get(x).getText().toLowerCase();
            System.out.println(product_name);
        }

        return product_name;
    }

    public int getProductsCount()
    {
        return Hooks.driver.findElements(productNameLocator).size();
    }

    public WebElement openProductDetail() {
        return Hooks.driver.findElement(productNameLocator);
    }

    public String getProductSKU() {

       return Hooks.driver.findElement(productSKULocator).getText();
    }

    ///////Hovers/////////
    public void hoverRandomCategory() {

        List<WebElement> categories = Hooks.driver.findElements(mainCategoryLocator);

        int randomCategory = new Random().nextInt(3); // Select Random number from 0 to 2
        hover.moveToElement(categories.get(randomCategory)).perform();
    }

    public void clickRandomSubCategory()
    {
        List<WebElement> subCategories = Hooks.driver.findElements(subCategoryLocator);
        int randomSubCategory = new Random().nextInt(3); // Select Random number from 0 to 2
    }
    public List<WebElement> getCategories() {

        return Hooks.driver.findElements(mainCategoryLocator);
    }

    public List<WebElement> getSubCategories(int categoryNumber) {

        List<WebElement> subCategories = Hooks.driver.findElements(subCategoryLocator);
        int randomSubCategory = new Random().nextInt(3); // Select Random number from 0 to 2
        return Hooks.driver.findElements(subCategoryLocator);
    }

    ///////End Hovers/////

}

