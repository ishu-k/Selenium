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

public class Basketsteps {
    HomePage homePage=new HomePage();
    ResultsPage resultsPage=new ResultsPage();
    TrolleyPage trolleyPage=new TrolleyPage();
    ProductDescriptionPage descriptionPage=new ProductDescriptionPage();
    @Given("^i search for a product nike$")
    public void i_search_for_a_product_nike() {
        homePage.doSearch("nike");
    }

    @When("^i collect all the nike products in to the list and randomly select a product$")
    public void i_collect_all_the_nike_products_in_to_the_list_and_randomly_select_a_product() {
        String allProducts=resultsPage.selectAnyProduct();
    }
    @And("^i add the product to basket$")
    public void iAddTheProductToBasket() {
        trolleyPage.addToTrolley();
        trolleyPage.goToTrolley();
    }
    @And("^i increase the number of products to 2$")
    public void i_increase_the_number_of_products_to_2() throws InterruptedException {
        descriptionPage.selectDropDown(1);
    }

    @Then("^i should be able to see the expected equal to actual$")
    public void i_should_be_able_to_see_the_expected_equal_to_actual()  {
        double expected= descriptionPage.priceCheckSingle();
        double actual= resultsPage.totalPrice();
        assertThat(actual,equalTo(expected));
       
    }

}
