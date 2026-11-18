package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(1000);

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Smith");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();

        Thread.sleep(2000);

        String total = driver.findElement(By.className("summary_total_label")).getText();
        System.out.println(total);

        if (total.equals("Total: $17.27")) {
            System.out.println("Total price is correct");
        } else {
            System.out.println("Total price is wrong");
        }

        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        String message = driver.findElement(By.className("complete-header")).getText();
        System.out.println(message);

        if (message.equals("Thank you for your order!")) {
            System.out.println("Checkout test PASSED");
        } else {
            System.out.println("Checkout test FAILED");
        }

        driver.quit();
    }
}
