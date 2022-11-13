package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user click on facebook link from the footer")
    public void userClickOnFBLink() {
        home.fbLink().click();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }

    @Given("user click on twitter link from the footer")
    public void userClickOnTwitterLink() {
        home.twitterLink().click();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Given("user click on rss link from the footer")
    public void userClickOnRssLink() {
        home.rssLink().click();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Given("user click on youtube link from the footer")
    public void userClickOnYoutubeLink() {
        home.youtubeLink().click();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("{string} is opened in new tab")
    public void newTabIsOpenedWithTheClickedLinkURL(String url) {

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        String actualURL = Hooks.driver.getCurrentUrl();

        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(actualURL,url);
        sAssert.assertAll();

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }

}