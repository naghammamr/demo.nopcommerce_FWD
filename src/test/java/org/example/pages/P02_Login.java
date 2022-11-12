package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_Login {

    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginBtn = By.xpath("//button[@class='button-1 login-button']");
    By failedLoginErrorMsg = By.xpath("//div[@class='message-error validation-summary-errors']");

    public String getFailedLoginErrorMsg() {
        String Message = Hooks.driver.findElement(failedLoginErrorMsg).getText();
        return Message;
    }

    public String getFailedLoginErrorMsgColor()
    {
        String errorMsgColor = Hooks.driver.findElement(failedLoginErrorMsg).getCssValue("color");
        return errorMsgColor;
    }

    public void enterEmailAndPassword(String email, String password) {
        Hooks.driver.findElement(emailField).sendKeys(email);
        Hooks.driver.findElement(passwordField).sendKeys(password);
    }

    public WebElement clickLoginButton() {
        return Hooks.driver.findElement(loginBtn);
    }


}
