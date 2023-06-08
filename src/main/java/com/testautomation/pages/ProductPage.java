package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By addToCartButton = By.linkText("Add to cart");
    private By cartLink = By.id("cartur");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        waitForElementToBeClickable(addToCartButton).click();
    }

    public String getProductAddedToCart() {
        // Get text of the alert popup
        return waitForAlertIsPresent().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void navigateToCart() {
        waitForElementToBeClickable(cartLink).click();
    }
}
