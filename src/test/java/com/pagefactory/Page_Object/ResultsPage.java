package com.pagefactory.Page_Object;

import com.pagefactory.Drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverManager {
    @FindBy(css = ".findability-facet__rating-label")
    private List<WebElement> ratingWebElements;

    @FindBy(css = "div[data-test='component-ratings']")
    private List<WebElement> ratingStars;

    public void selectFilter(String filterOption) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"), 5));

        for (WebElement review : ratingWebElements) {
            String availableFilter = review.getText();
            if (availableFilter.equalsIgnoreCase(filterOption)) {
                review.click();
                break;
            }
        }
    }

    public List<Double> getProductRating() {
        // TODO: 2020-02-22 change this to webdriver wait
        sleep(3000);
        List<Double> ratingList = new ArrayList<>();
        for (WebElement rating : ratingStars) {
            String ratingInString = rating.getAttribute("data-star-rating");
            double ratingInDouble = Double.parseDouble(ratingInString);
            ratingList.add(ratingInDouble);
        }
        return ratingList;
    }
}


    


