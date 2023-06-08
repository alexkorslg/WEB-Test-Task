package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    private By userNameInput = By.id("name");
    private By purchaseButton = By.xpath("//button[contains(text(), 'Purchase')]");
    private By orderConfirmationMessage = By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]");

    /*
        Place order
        Name
        Country
        City
        Credit card
        Month
        Year
     */

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterOrderDetails(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public String getOrderConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).getText();
    }
}
