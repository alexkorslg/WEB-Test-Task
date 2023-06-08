package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By productNameLabel = By.xpath("//tbody[@id='tbodyid']//td[2]");
    private By checkoutButton = By.xpath("//button[contains(text(), 'Place Order')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart(String productName) {
        return waitForElementToBeVisible(productNameLabel).getText().equals(productName);
    }

    public void clickCheckoutButton() {
        waitForElementToBeClickable(checkoutButton).click();
    }
}
