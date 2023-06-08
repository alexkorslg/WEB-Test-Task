package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testautomation.pages.HomePage;
import com.testautomation.pages.SearchPage;
import com.testautomation.utils.DriverManager;

public class SearchTest {
    private HomePage homePage;
    private SearchPage searchPage;

    @BeforeClass
    public void setup() {
        DriverManager.getDriver();
        searchPage = new SearchPage(DriverManager.getDriver());
        homePage = new HomePage(DriverManager.getDriver());
    }

    @Test
    public void verifyProductSearchFunctionality() {
        String productName = "Samsung Galaxy Tab S6 Lite";

        DriverManager.getDriver().get("https://www.coolblue.nl/en");
        homePage.closeCookiePopup();

        // Perform product search
        searchPage.fillSearchInput(productName);
        searchPage.clickHeaderSearchButton();

        // Verify search results are displayed
        boolean areSearchResultsDisplayed = searchPage.areSearchResultsDisplayed();
        Assert.assertTrue(areSearchResultsDisplayed, "Search results are not displayed");

        // Verify the searched product is present in the first search result
        String firstSearchResultName = searchPage.getFirstSearchResultName();
        Assert.assertTrue(firstSearchResultName.contains(productName), "Searched product is not present in the first search result");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
