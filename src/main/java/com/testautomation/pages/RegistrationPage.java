package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    private By signupButton = By.id("signin2");
    private By nameInput = By.id("sign-username");
    private By passwordInput = By.id("sign-password");
    private By registerButton = By.xpath("//button[contains(@onclick, 'register()')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public void enterName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement nameInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        nameInputElement.sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // Get text of the alert popup
    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
