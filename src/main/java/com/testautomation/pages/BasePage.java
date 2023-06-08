package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private static final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(5);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected Alert waitForAlertIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
}
