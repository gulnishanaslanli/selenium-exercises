package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SortProductsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText("Price (low to high)");

        Thread.sleep(2000);

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        boolean sorted = true;
        for (int i = 0; i < prices.size() - 1; i++) {
            double price1 = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            double price2 = Double.parseDouble(prices.get(i + 1).getText().replace("$", ""));
            System.out.println(price1 + " <= " + price2);
            if (price1 > price2) {
                sorted = false;
            }
        }

        if (sorted) {
            System.out.println("Sort low to high test PASSED");
        } else {
            System.out.println("Sort low to high test FAILED");
        }

        select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText("Name (Z to A)");

        Thread.sleep(2000);

        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        String first = names.get(0).getText();
        System.out.println("First product: " + first);

        if (first.equals("Test.allTheThings() T-Shirt (Red)")) {
            System.out.println("Sort Z to A test PASSED");
        } else {
            System.out.println("Sort Z to A test FAILED");
        }

        driver.quit();
    }
}
