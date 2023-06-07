package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testautomation.pages.LoginPage;
import com.testautomation.utils.DriverManager;

public class LoginTest {
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        // Initialize the WebDriver instance
        DriverManager.getDriver();
        // Create a new instance of LoginPage with the WebDriver
        loginPage = new LoginPage(DriverManager.getDriver());
    }

    @Test
    public void loginTest() {
        String username = "demo";
        String password = "demo";

        // Open the initial page
        DriverManager.getDriver().get("https://www.demoblaze.com/");
        // Click on the login button
        loginPage.clickLoginButton();

        // Enter the name into the name input field
        loginPage.enterName(username);

        // Enter the password into the password input field
        loginPage.enterPassword(password);

        // Click on the user login button in modal window
        loginPage.clickUserLoginButton();

        String welcomeMessage = loginPage.getWelcomeMessage();
        String expectedWelcomeMessage = "Welcome " + username;
        // Assert welcome text matches the expected text
        Assert.assertEquals(welcomeMessage, expectedWelcomeMessage);
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        DriverManager.quitDriver();
    }
}
