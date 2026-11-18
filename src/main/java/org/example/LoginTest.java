package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        System.out.println("Current url is: " + url);

        if (url.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Login test PASSED");
        } else {
            System.out.println("Login test FAILED");
        }

        String title = driver.findElement(By.className("title")).getText();
        if (title.equals("Products")) {
            System.out.println("Products page is opened");
        } else {
            System.out.println("Products page is NOT opened");
        }

        driver.quit();
    }
}
