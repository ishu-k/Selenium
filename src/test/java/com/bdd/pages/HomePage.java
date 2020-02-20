package com.bdd.pages;

import com.bdd.Driver.DriverFactory;
import org.openqa.selenium.By;

public class HomePage extends DriverFactory {

    public void doSearch(String searchTerm) throws InterruptedException {

        driver.findElement(By.cssSelector("input[data-test='search-input']")).sendKeys(searchTerm);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(4000);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();

    }
}

