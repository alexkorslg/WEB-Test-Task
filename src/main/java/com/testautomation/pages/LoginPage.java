package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By loginButton = By.id("login2");
    private By userNameInput = By.id("loginusername");
    private By userPasswordInput = By.id("loginpassword");
    private By userLoginButton = By.xpath("//button[contains(@onclick, 'logIn()')]");
    private By welcomeMessage = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userNameInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        userNameInputElement.sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(userPasswordInput).sendKeys(password);
    }

    public void clickUserLoginButton() {
        driver.findElement(userLoginButton).click();
    }

    // Get welcome text after successful login
    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement welcomeMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        return welcomeMessageElement.getText();
    }
}
