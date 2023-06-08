package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By loginButton = By.id("login2");
    private By userNameInput = By.id("loginusername");
    private By userPasswordInput = By.id("loginpassword");
    private By userLoginButton = By.xpath("//button[contains(@onclick, 'logIn()')]");
    private By welcomeMessage = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        waitForElementToBeClickable(loginButton).click();
    }

    public void enterName(String name) {
        waitForElementToBeVisible(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        waitForElementToBeVisible(userPasswordInput).sendKeys(password);
    }

    public void clickUserLoginButton() {
        waitForElementToBeClickable(userLoginButton).click();
    }

    // Get welcome text after successful login
    public String getWelcomeMessage() {
        return waitForElementToBeVisible(welcomeMessage).getText();
    }
}
