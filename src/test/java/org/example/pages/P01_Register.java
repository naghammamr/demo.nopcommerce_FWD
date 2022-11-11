package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_Register {

    // Define locators
    private By genderRadioBtnLocator = By.id("gender-female");
    private By firstNameLocator = By.id("FirstName");
    private By lastNameLocator = By.id("LastName");
    private By DOBDayLocator = By.name("DateOfBirthDay");
    private By DOBMonthLocator = By.name("DateOfBirthMonth");
    private By DOBYearLocator = By.name("DateOfBirthYear");
    private By emailLocator = By.id("Email");
    private By passwordLocator = By.id("Password");
    private By confirmPassLocator = By.id("ConfirmPassword");
    private By registerBtn = By.id("register-button");

    private By successMsgLocator = By.className("result");


    public String getSuccessMsg() {
        String Message = Hooks.driver.findElement(successMsgLocator).getText();
        return Message;
    }

    public String getSuccessMsgColor()
    {
        String MsgColor = Hooks.driver.findElement(successMsgLocator).getCssValue("color");
        System.out.println(MsgColor);
        return MsgColor;
    }

    public void selectGender() {
        Hooks.driver.findElement(genderRadioBtnLocator).click();
    }

    public void setFirstName(String FirstName) {
        Hooks.driver.findElement(firstNameLocator).sendKeys(FirstName);
    }

    public void setLastName(String LastName) {
        Hooks.driver.findElement(lastNameLocator).sendKeys(LastName);
    }

    public void setDOB(int Day, int Month, String Year) {

        Select select = new Select(Hooks.driver.findElement(DOBDayLocator));
        select.selectByIndex(Day);

        select = new Select(Hooks.driver.findElement(DOBMonthLocator));
        select.selectByIndex(Month);

        select = new Select(Hooks.driver.findElement(DOBYearLocator));
        select.selectByValue(Year);
    }

    public void setEmail(String Email) {
        Hooks.driver.findElement(emailLocator).sendKeys(Email);
    }

    public void setPasswordFields(String Password,String confirmPassword) {
        Hooks.driver.findElement(passwordLocator).sendKeys(Password);
        Hooks.driver.findElement(confirmPassLocator).sendKeys(confirmPassword);
    }

    public WebElement registerButton()
    {
       return Hooks.driver.findElement(registerBtn);
    }

}