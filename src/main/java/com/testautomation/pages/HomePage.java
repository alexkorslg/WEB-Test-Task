package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickProduct(String productName) {
        By productLink = By.xpath("//*[contains(@class, 'card-title')]//a[contains(text(), '" + productName + "')]");
        waitForElementToBeClickable(productLink).click();
    }
}
