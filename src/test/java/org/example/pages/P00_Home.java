package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P00_Home {

    public WebElement registerLink() {
        return Hooks.driver.findElement(By.xpath("//a[contains(.,'Register')]"));
    }
}

