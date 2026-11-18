package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();

        Thread.sleep(2000);

        boolean loginButton = driver.findElement(By.id("login-button")).isDisplayed();

        if (loginButton && driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Logout test PASSED");
        } else {
            System.out.println("Logout test FAILED");
        }

        driver.quit();
    }
}
