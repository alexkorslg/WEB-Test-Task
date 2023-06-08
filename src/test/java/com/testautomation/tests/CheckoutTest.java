package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testautomation.pages.CartPage;
import com.testautomation.pages.CheckoutPage;
import com.testautomation.pages.HomePage;
import com.testautomation.pages.ProductPage;
import com.testautomation.utils.DriverManager;

public class CheckoutTest {
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setup() {
        DriverManager.getDriver();
        homePage = new HomePage(DriverManager.getDriver());
        productPage = new ProductPage(DriverManager.getDriver());
        cartPage = new CartPage(DriverManager.getDriver());
        checkoutPage = new CheckoutPage(DriverManager.getDriver());
    }

    @Test
    public void verifyCheckoutProcess() {
       return;
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
