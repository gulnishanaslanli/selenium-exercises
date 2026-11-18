package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(1000);

        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(errorText);

        if (errorText.contains("Username and password do not match")) {
            System.out.println("Invalid login test PASSED");
        } else {
            System.out.println("Invalid login test FAILED");
        }

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(1000);

        String errorText2 = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(errorText2);

        if (errorText2.equals("Epic sadface: Username is required")) {
            System.out.println("Empty login test PASSED");
        } else {
            System.out.println("Empty login test FAILED");
        }

        driver.quit();
    }
}
