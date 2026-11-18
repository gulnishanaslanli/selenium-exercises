package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveFromCartTest {
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
        Thread.sleep(1000);

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        Thread.sleep(1000);

        int items = driver.findElements(By.className("cart_item")).size();
        System.out.println("Items in cart: " + items);

        if (items == 0) {
            System.out.println("Remove from cart test PASSED");
        } else {
            System.out.println("Remove from cart test FAILED");
        }

        int badge = driver.findElements(By.className("shopping_cart_badge")).size();
        if (badge == 0) {
            System.out.println("Badge is gone");
        } else {
            System.out.println("Badge is still there");
        }

        driver.quit();
    }
}
