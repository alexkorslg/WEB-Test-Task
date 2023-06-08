package com.testautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;
    private static final String WINDOW_SIZE = "--window-size=1024,768";

    /**
     * Get the WebDriver instance
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(WINDOW_SIZE);
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    // Quit the WebDriver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
