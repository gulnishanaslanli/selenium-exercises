package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LockedUserTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(1000);

        String error = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        if (error.equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("Locked user test PASSED");
        } else {
            System.out.println("Locked user test FAILED");
            System.out.println("Actual error: " + error);
        }

        driver.quit();
    }
}
