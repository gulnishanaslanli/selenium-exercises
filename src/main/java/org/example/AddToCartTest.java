package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(500);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(500);

        String count = driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Cart count: " + count);

        if (count.equals("2")) {
            System.out.println("Cart badge is correct");
        } else {
            System.out.println("Cart badge is wrong");
        }

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        String item1 = driver.findElements(By.className("inventory_item_name")).get(0).getText();
        String item2 = driver.findElements(By.className("inventory_item_name")).get(1).getText();
        System.out.println(item1);
        System.out.println(item2);

        if (item1.equals("Sauce Labs Backpack") && item2.equals("Sauce Labs Bike Light")) {
            System.out.println("Add to cart test PASSED");
        } else {
            System.out.println("Add to cart test FAILED");
        }

        driver.quit();
    }
}
