package com.pagefactory.Page_Object;

import com.pagefactory.Drivers.DriverManager;
import com.pagefactory.Utils.Helpers;
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
    @FindBy(className = "search-title__term")
    WebElement searchTitle;
    @FindBy(css = "div.Summary__subTotalLabel__2GphY")
    WebElement productPrice;
    @FindBy(xpath = "//header[@id='haas-v2']//a[4]/span[1]")
    WebElement numberofProducts;


    public void selectFilter(String filterOption) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"), 5));

        for (WebElement review : ratingWebElements) {
            String availableFilter = review.getText();
            System.out.println(availableFilter);
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
            System.out.println(ratingInDouble);
            ratingList.add(ratingInDouble);
        }
        return ratingList;
    }
        public List<String> getAllProductNames()              //get the list of product elements as a string into list
        {
            List<String> productNamesList = new ArrayList<String>();  // collecting in to arraylist
            List<WebElement> productWebElements = isProductsAvailable();
            for (WebElement indProduct : productWebElements) {
                String actual = indProduct.getText();
                productNamesList.add(actual);
            }
            return productNamesList;

        }

        public String getSearchTitle() {
            return searchTitle.getText();

        }
        public String selectAnyProduct(){
            List<WebElement> productWebElements = isProductsAvailable();
            int productSize = productWebElements.size();
            int randomNumber = new Helpers().randomNumberGenerator(productSize);
            WebElement selectedElement = productWebElements.get(randomNumber);
            String selectedProductName = selectedElement.getText();
            selectedElement.click();
            return selectedProductName;
        }

        private List<WebElement> isProductsAvailable() {
            List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(productWebElements.size()==0){
                // fail("Zero products found .....");
                //throw new RuntimeException("zero products found");
                throw new RuntimeException("Zero products found .....");
            }
            return productWebElements;

        }
        public double totalPrice()
        {
            String price1=productPrice.getText();
            System.out.println(price1);
            String actual=price1.replaceAll("£"," ");
            //converting string to double
            double actual1=Double.parseDouble(actual);
            System.out.println(actual1);
            return actual1;
        }
        public int numberofProductsInBasket()
        {
            String expected= numberofProducts.getText();
            System.out.println(expected);
            int actual1=Integer.parseInt(expected);
            return actual1;
        }

    }




    


