package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private static final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(5);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Wait for an element to be clickable
    protected WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for an element to be visible
    protected WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Get the text of the first element found with the specified locator
    protected String getFirstElementText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        List<WebElement> searchResultElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        if (!searchResultElements.isEmpty()) {
            return searchResultElements.get(0).getText();
        }
        return null;
    }

    // Wait for an alert to be present
    protected Alert waitForAlertIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
}
