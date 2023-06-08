package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    private By userNameInput = By.id("name");
    private By countryInput = By.id("country");
    private By cityInput = By.id("city");
    private By creditСardInput = By.id("card");
    private By monthInput = By.id("month");
    private By yearInput = By.id("year");
    private By purchaseButton = By.xpath("//button[contains(text(), 'Purchase')]");
    private By orderConfirmationMessage = By.cssSelector(".sweet-alert h2");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterOrderDetails(String userName, String country, String city, String creditСard, String month, String year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));

        driver.findElement(userNameInput).sendKeys(userName);
        driver.findElement(countryInput).sendKeys(country);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(creditСardInput).sendKeys(creditСard);
        driver.findElement(monthInput).sendKeys(month);
        driver.findElement(yearInput).sendKeys(year);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public String getOrderConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).getText();
    }
}
