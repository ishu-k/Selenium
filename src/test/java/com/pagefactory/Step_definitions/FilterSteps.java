package com.pagefactory.Step_definitions;

import com.pagefactory.Page_Object.HomePage;
import com.pagefactory.Page_Object.ResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Every.everyItem;

public class FilterSteps {
    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String actual = homePage.getCurrentUrl();
        assertThat(actual, endsWith("co.uk/"));
    }
    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String searchTerm)  {
        homePage.doSearch(searchTerm);
    }

    @And("^I apply filter review \"([^\"]*)\"$")
    public void iApplyFilterReview(String filter) {
        resultsPage.selectFilter(filter);
    }
    @Then("^I should be able to see product rating \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeProductRating(Double expected) {
        List<Double> actual = resultsPage.getProductRating();
        assertThat(actual, everyItem(is(greaterThanOrEqualTo(expected))));
    }
}

