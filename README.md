# Selenium Exercises

My selenium practice project. Tests are for https://www.saucedemo.com/

## What you need

- Java 20
- Maven
- Google Chrome

## How to run

Open project in IntelliJ IDEA and run any test class (right click -> Run).

Or from terminal:

```
mvn compile exec:java -Dexec.mainClass=org.example.LoginTest
```

## Tests

- LoginTest - login with correct user
- InvalidLoginTest - login with wrong user and empty fields
- LockedUserTest - login with locked user
- AddToCartTest - add 2 products to cart
- RemoveFromCartTest - remove product from cart
- CheckoutTest - buy a product
- SortProductsTest - sort products by price and name
- LogoutTest - logout

## Users

username: standard_user
password: secret_sauce
