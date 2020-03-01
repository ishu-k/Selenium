package com.pagefactory.Step_definitions;

import com.pagefactory.Page_Object.HomePage;
import com.pagefactory.Page_Object.ProductDescriptionPage;
import com.pagefactory.Page_Object.ResultsPage;
import com.pagefactory.Page_Object.TrolleyPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class Task2Steps {
    private HomePage homePage=new HomePage();
    private ResultsPage resultPage=new ResultsPage();
    private TrolleyPage trolleyPage=new TrolleyPage();
    ProductDescriptionPage descriptionPage=new ProductDescriptionPage();

    @Given("^I search for a product$")
    public void i_search_for_a_product() throws InterruptedException {
        homePage.doSearch("nike");
    }

    @And("^I add that product  trolley$")
    public void i_add_that_product_trolley() throws InterruptedException {
        trolleyPage.addToTrolley();

    }

    @And("^I click on continue shopping$")
    public void i_click_on_continue_shopping() throws InterruptedException {
        trolleyPage.setContinueShopping();

    }

    @And("^again i search for a product  add random product$")
    public void again_i_search_for_a_product_add_random_product() throws InterruptedException {
        homePage.doSearch("puma");

    }

    @And("^i should ale to see the trolley got 2 products$")
    public void i_should_ale_to_see_the_trolley_got_2_products()  {
        int actual= resultPage.numberofProductsInBasket();
        int  expected=2;
        assertThat(expected,is(equalTo(actual))) ;

    }



    @Then("^I add that product to basket and goto trolley$")
    public void iAddThatProductToBasketAndGotoTrolley() throws InterruptedException {
        trolleyPage.addToTrolley();
        trolleyPage.goToTrolley();
    }

    @When("^I select all the products in list and on one product randomly$")
    public void iSelectAllTheProductsInListAndOnOneProductRandomly() {
        String all=resultPage.selectAnyProduct();
    }
}


