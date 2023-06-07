package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;

import com.testautomation.pages.RegistrationPage;
import com.testautomation.utils.DriverManager;

public class RegistrationTest {
    private RegistrationPage registrationPage;

    @BeforeClass
    public void setup() {
        // Initialize the WebDriver instance
        DriverManager.getDriver();
        // Create a new instance of RegistrationPage with the WebDriver
        registrationPage = new RegistrationPage(DriverManager.getDriver());
    }

    @Test
    public void registrationTest() {
        String username = "newdemo2023_";
        String password = "demo";

        // Open the initial page
        DriverManager.getDriver().get("https://www.demoblaze.com/");
        // Click on the signup button
        registrationPage.clickSignupButton();

        // Generate a random alphanumeric string of length 5
        String randomString = RandomStringUtils.randomAlphanumeric(5);
        // Enter the generated name into the name input field
        registrationPage.enterName(username + randomString);

        // Enter the password into the password input field
        registrationPage.enterPassword(password);

        // Click on the register button
        registrationPage.clickRegisterButton();

        // Get the text from the alert window
        String alertText = registrationPage.getAlertText();
        // Define the expected alert text
        String expectedAlertText = "Sign up successful.";
        // Assert that the alert text matches the expected text
        Assert.assertEquals(alertText, expectedAlertText);

        // Accept (close) the alert window
        registrationPage.acceptAlert();
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        DriverManager.quitDriver();
    }
}
