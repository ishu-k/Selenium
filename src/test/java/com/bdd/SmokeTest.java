package com.bdd;

import com.bdd.Driver.DriverFactory;
import com.bdd.pages.HomePage;
import com.bdd.pages.ResultPage;
import com.bdd.pages.TrolleyPage;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


    public class SmokeTest  {

         HomePage homePage = new HomePage();
        ResultPage resultsPage = new ResultPage();
        TrolleyPage trolleyPage= new TrolleyPage();
        DriverFactory factory=new DriverFactory();

        @Test
        public void searchTest() throws InterruptedException {
            String searchTerm="puma";
            homePage.doSearch(searchTerm);
            assertThat(homePage.getCurrentUrl(), endsWith(searchTerm));
            System.out.println(homePage.getCurrentUrl());
            List<String> actualProductList = resultsPage.getAllProductNames();
            for (String product: actualProductList){
                assertThat(product.toLowerCase(),containsString(searchTerm));
            }
            String actualTitle = resultsPage.getSearchTitle();
            assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
        }

        @Test
        public void basketTest() throws InterruptedException {
           String  SearchTerm="nike";
            homePage.doSearch(SearchTerm);
            String selectedProductName =resultsPage.selectAnyProduct();
            trolleyPage.addToTrolley();
            Thread.sleep(5000);
            trolleyPage.goToTrolley();
            String actual = trolleyPage.getProductInTrolley();
            System.out.println(actual);
            assertThat(actual,equalTo(selectedProductName));
        }
    }


