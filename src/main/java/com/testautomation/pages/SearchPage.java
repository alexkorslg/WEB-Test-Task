package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private By headerSearchInput = By.cssSelector("header .search__input-container input");
    private By headerSearchButton = By.cssSelector("header button.search__action");
    private By searchResultsContainer = By.className("js-products");
    private By searchResultNames = By.cssSelector(".js-products .product-card__title a");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Fill the search input field with the specified text
    public void fillSearchInput(String text) {
        waitForElementToBeVisible(headerSearchInput).sendKeys(text);
    }

    // Click the header search button
    public void clickHeaderSearchButton() {
        waitForElementToBeClickable(headerSearchButton).click();
    }

    // Check if the search results are displayed
    public boolean areSearchResultsDisplayed() {
        return waitForElementToBeVisible(searchResultsContainer).isDisplayed();
    }

    // Get the name of the first search result
    public String getFirstSearchResultName() {
        return getFirstElementText(searchResultNames);
    }
}
