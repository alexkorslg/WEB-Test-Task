package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testautomation.pages.CartPage;
import com.testautomation.pages.CheckoutPage;
import com.testautomation.utils.DriverManager;

public class CheckoutTest {
    private AddToCartTest addToCartTest;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setup() {
        DriverManager.getDriver();
        cartPage = new CartPage(DriverManager.getDriver());
        checkoutPage = new CheckoutPage(DriverManager.getDriver());
    }

    @BeforeMethod
    public void addProductToCart() {
        addToCartTest = new AddToCartTest();
        addToCartTest.setup();
        addToCartTest.verifyAddToCartFunctionality();
    }

    @Test
    public void verifyCheckoutProcess() {
        // Proceed to checkout
        cartPage.clickCheckoutButton();

        // Fill in the order information
        checkoutPage.enterOrderDetails("demo", "US", "New York", "12345", "June", "2023");

        // Proceed to payment
        checkoutPage.clickPurchaseButton();

        // Verify that the order is placed successfully
        String orderConfirmationMessage = checkoutPage.getOrderConfirmationMessage();
        Assert.assertTrue(orderConfirmationMessage.contains("Thank you for your purchase!"));
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
