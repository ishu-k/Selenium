package com.bdd.Step_Definitions;

import com.bdd.Driver.DriverFactory;
import com.bdd.pages.HomePage;
import com.bdd.pages.ProductDescriptionPage;
import com.bdd.pages.ResultPage;
import com.bdd.pages.TrolleyPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class BasketStepsNew {
    HomePage homePage = new HomePage();
    ResultPage resultsPage = new ResultPage();
    DriverFactory factory = new DriverFactory();
    TrolleyPage trolleyPage=new TrolleyPage();
    ProductDescriptionPage descriptionPage=new ProductDescriptionPage();

    @Given("^i search for a product nike$")
    public void i_search_for_a_product_nike() throws InterruptedException {
        homePage.doSearch("nike");
    }

    @When("^i collect all the nike products in to the list and randomly select a product$")
    public void i_collect_all_the_nike_products_in_to_the_list_and_randomly_select_a_product()  {
        String allProducts=resultsPage.selectAnyProduct();
    }

    @And("^ add the product to basket$")
    public void add_the_product_to_basket() throws InterruptedException {
        trolleyPage.goToTrolley();
        trolleyPage.addToTrolley();

    }

    @And("^i increase the number of products to 2$")
    public void i_increase_the_number_of_products_to_2() throws InterruptedException {
        descriptionPage.selectDropDown(1);
    }

    @Then("^i should be able to see the expected equal to actual$")
    public void iShouldBeAbleToSeeTheExpectedEqualToActual() throws InterruptedException {

        double expected= descriptionPage.priceCheckSingle();
        double actual= resultsPage.totalPrice();
        assertThat(actual,equalTo(expected));

    }

    @And("^i add the product to basket$")
    public void iAddTheProductToBasket() throws InterruptedException {
        trolleyPage.addToTrolley();
        trolleyPage.goToTrolley();

    }
}