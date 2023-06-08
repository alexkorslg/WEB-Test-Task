package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private By userNameInput = By.id("name");
    private By countryInput = By.id("country");
    private By cityInput = By.id("city");
    private By creditСardInput = By.id("card");
    private By monthInput = By.id("month");
    private By yearInput = By.id("year");
    private By purchaseButton = By.xpath("//button[contains(text(), 'Purchase')]");
    private By orderConfirmationMessage = By.cssSelector(".sweet-alert h2");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterOrderDetails(String userName, String country, String city, String creditСard, String month, String year) {
        waitForElementToBeVisible(userNameInput).sendKeys(userName);
        waitForElementToBeVisible(countryInput).sendKeys(country);
        waitForElementToBeVisible(cityInput).sendKeys(city);
        waitForElementToBeVisible(creditСardInput).sendKeys(creditСard);
        waitForElementToBeVisible(monthInput).sendKeys(month);
        waitForElementToBeVisible(yearInput).sendKeys(year);
    }

    public void clickPurchaseButton() {
        waitForElementToBeClickable(purchaseButton).click();
    }

    public String getOrderConfirmationMessage() {
        return waitForElementToBeVisible(orderConfirmationMessage).getText();
    }
}
