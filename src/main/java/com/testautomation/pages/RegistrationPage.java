package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private By signupButton = By.id("signin2");
    private By nameInput = By.id("sign-username");
    private By passwordInput = By.id("sign-password");
    private By registerButton = By.xpath("//button[contains(@onclick, 'register()')]");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignupButton() {
        waitForElementToBeClickable(signupButton).click();
    }

    public void enterName(String name) {
        waitForElementToBeVisible(nameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterButton() {
        waitForElementToBeClickable(registerButton).click();
    }

    // Get text of the alert popup
    public String getAlertText() {
        return waitForAlertIsPresent().getText();
    }

    public void acceptAlert() {
        waitForAlertIsPresent().accept();
    }
}
