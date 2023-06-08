# Automated Testing for E-commerce Website

This repository contains automated tests for various functionalities of a demo e-commerce website. The tests are implemented using Selenium WebDriver and organized using the Page Object Model (POM) design pattern.

## Requirements

To run the tests, make sure you have the following components set up:

- Java 8

## Test Cases

The following test cases are implemented:

1. Verify user registration and login
2. Verify product search functionality
3. Verify add-to-cart functionality
4. Verify the checkout process

## Project Structure

#### DriverManager
The `DriverManager` class is responsible for managing the WebDriver instance. It provides methods to get and quit the WebDriver instance.

#### POM classes
The project follows the Page Object Model (POM) design pattern. It consists of the following classes:

- `BasePage`: Acts as a base class for other pages and contains common methods and utilities.
- `HomePage`: Represents the home page and contains methods to navigate to different products.
- `RegistrationPage`: Represents the registration page and contains methods to interact with the registration form.
- `LoginPage`: Represents the login page and contains methods to interact with the login form.
- `ProductPage`: Represents the product page and contains methods to interact with the product details and add it to the cart.
- `CartPage`: Represents the cart page and contains methods to interact with the cart and perform add-to-cart operations.
- `CheckoutPage`: Represents the checkout page and contains methods to enter order details and complete the purchase.
- `SearchPage`: Represents the search page and contains methods to perform search operations and retrieve search results.

## How to Run the Tests

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Install the necessary dependencies using Maven.
4. Run the test classes to execute the test cases.

## Test Results
![vscode tests results](https://github.com/alexkorslg/WEB-Test-Task/blob/main/screenshot.jpg?raw=true)


