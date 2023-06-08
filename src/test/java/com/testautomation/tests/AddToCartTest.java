package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testautomation.pages.HomePage;
import com.testautomation.pages.ProductPage;
import com.testautomation.pages.CartPage;
import com.testautomation.utils.DriverManager;

public class AddToCartTest {
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeClass
    public void setup() {
        DriverManager.getDriver();
        homePage = new HomePage(DriverManager.getDriver());
        productPage = new ProductPage(DriverManager.getDriver());
        cartPage = new CartPage(DriverManager.getDriver());
    }

    @Test
    public void verifyAddToCartFunctionality() {
        String productName = "Samsung galaxy s6";

        DriverManager.getDriver().get("https://www.demoblaze.com/");
        homePage.clickProduct(productName);
        productPage.addToCart();

        // Get the text from the alert window
        String alertText = productPage.getProductAddedToCart();
        // Define the expected alert text
        String expectedAlertText = "Product added";
        // Assert that the alert text matches the expected text
        Assert.assertEquals(alertText, expectedAlertText);

        // Accept (close) the alert window
        productPage.acceptAlert();

        productPage.navigateToCart();
        Assert.assertTrue(cartPage.isProductInCart(productName));
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
