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
    By productNameLocator = By.xpath("//h2[@class='product-title']//a");
    By productSKULocator = By.xpath("//div[@class='sku']//span[@class='value']");


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

    public int getProductsCount() {
        return Hooks.driver.findElements(productNameLocator).size();
    }

    public WebElement openProductDetail() {
        return Hooks.driver.findElement(productNameLocator);
    }

    public String getProductSKU() {

        return Hooks.driver.findElement(productSKULocator).getText();
    }

    //////////Sliders////////////////

    By firstSliderLinkLocator = By.xpath("//div[@id='nivo-slider']//a[@href][1]");
    By secondSliderIconLocator = By.xpath("//div[@class='nivo-controlNav']//a[contains(.,2)]");
    By secondSliderLinkLocator = By.xpath("//div[@id='nivo-slider']//a[@href][2]");

    public WebElement firstSliderLink() {
        return Hooks.driver.findElement(firstSliderLinkLocator);
    }

    public WebElement changeToSecondSlider() {
        return Hooks.driver.findElement(secondSliderIconLocator);
    }

    public WebElement secondSliderLink() {
        return Hooks.driver.findElement(secondSliderLinkLocator);
    }

//    public List<WebElement> getCurrentSlider() {
//
//        return Hooks.driver.findElements(By.className("nivo-slider"));
//    }

    // Follow Us
    public WebElement fbLink() {
        return Hooks.driver.findElement(By.xpath("//li[@class='facebook']//a"));
    }

    public WebElement twitterLink() {
        return Hooks.driver.findElement(By.xpath("//li[@class='twitter']//a"));
    }

    public WebElement rssLink() {
        return Hooks.driver.findElement(By.xpath("//li[@class='rss']//a"));
    }

    public WebElement youtubeLink() {
        return Hooks.driver.findElement(By.xpath("//li[@class='youtube']//a"));
    }

    /// wishlist
    By wishListButtonLocator = By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]");
    By successMsgLocator = By.xpath("//div[@class='bar-notification success']");
    By messageBarLocator = By.cssSelector("span[title=\"Close\"]");
    By wishlistLinkLocator = By.cssSelector("span[class='wishlist-label']");
    By wishlistQTY = By.className("qty-input");

    public List<WebElement> getProductsWishlistButton() {
        return Hooks.driver.findElements(wishListButtonLocator);
    }

    public String successMsg() {
        return Hooks.driver.findElement(successMsgLocator).getText();
    }

    public Boolean successMsgDisplay() {
        return Hooks.driver.findElement(successMsgLocator).isDisplayed();
    }

    public String getSuccessMsgColor() {
        String MsgColor = Hooks.driver.findElement(successMsgLocator).getCssValue("background-color");
        System.out.println(MsgColor);
        return MsgColor;
    }

    public WebElement closeNotificationIcon() {
        return Hooks.driver.findElement(messageBarLocator);
    }

    public WebElement wishListLink() {
        return Hooks.driver.findElement(wishlistLinkLocator);
    }

    public String getWishlistProductsQTY() {
        return Hooks.driver.findElement(wishlistQTY).getAttribute("value");
    }


    ///////Hovers/////////

    public void hoverRandomCategory()
    {
        By mainCategoryLocator = By.cssSelector("ul[class='top-menu notmobile']>li>a");
        List<WebElement> categories = Hooks.driver.findElements(mainCategoryLocator);

        int randomNumber = new Random().nextInt(3); // Select Random number from 0 to 2

        Actions hover = new Actions(Hooks.driver);
        hover.moveToElement(categories.get(randomNumber)).perform();

        String selectedCategoryTxt = categories.get(randomNumber).getText();
        System.out.println("Selected Category: " + selectedCategoryTxt);
        //Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickRandomSubCategory() {
        int randomSubCategory = new Random().nextInt(2); // Select Random number from 0 to 1
        randomSubCategory += 1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)[" + randomSubCategory + "]//li//a";
        List<WebElement> subCategories = Hooks.driver.findElements(By.xpath(locator));

        String selectedSubCategoryText = subCategories.get(randomSubCategory).getText().toLowerCase().trim();
        System.out.println("Selected Sub-Category: " + selectedSubCategoryText);

        subCategories.get(randomSubCategory).click();
    }

    public String getOpenedProductTitle() {
        By productPageTitleLocator = By.xpath("//div[@class='page-title']//h1");
        return Hooks.driver.findElement(productPageTitleLocator).getText().toLowerCase().trim();
    }


}