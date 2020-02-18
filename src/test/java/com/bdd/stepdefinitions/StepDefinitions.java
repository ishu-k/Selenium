package com.bdd.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
    @Given("^Im on homepage$")
    public void im_on_homepage()  {
        System.out.println("given step");
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void i_search_for_product(String arg1) {
        System.out.println("when step");
    }

    @Then("^I should able to see the nike product$")
    public void i_should_able_to_see_the_nike_product()
    {
        System.out.println("then step");
    }


}
