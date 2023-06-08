package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closeCookiePopup() {
        By cookiePopup = By.cssSelector("form.js-cookie-notification__form");
        By cookieCloseButton = By.cssSelector("button[aria-label='Accept our cookies']");

        if (driver.findElement(cookiePopup).isDisplayed()) {
            waitForElementToBeClickable(cookieCloseButton).click();
        }
    }

    public void clickProduct(String productName) {
        By productLink = By.xpath("//*[contains(@class, 'card-title')]//a[contains(text(), '" + productName + "')]");
        waitForElementToBeClickable(productLink).click();
    }
}
