package com.bdd.Step_Definitions;

import com.bdd.Driver.DriverFactory;
import com.bdd.pages.HomePage;
import com.bdd.pages.ResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLOutput;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class SearchSteps {

        HomePage homePage = new HomePage();
        ResultPage resultsPage = new ResultPage();
        DriverFactory factory=new DriverFactory();

        @Given("^I am on homepage$")
        public void i_am_on_homepage() {
            String actual = homePage.getCurrentUrl();
            assertThat(actual, endsWith("co.uk/"));
        }

        @When("^I search for product \"([^\"]*)\"$")
        public void i_search_for_product_nike(String strarg1) throws InterruptedException {
            // factory.wait(6000);
            Thread.sleep(5000);
            homePage.doSearch("nike");
        }

        @Then("^I should be able to see nike product$")
        public void i_should_be_able_to_see_nike_product() throws InterruptedException {
            Thread.sleep(5000);
            String actaulTitle = resultsPage.getSearchTitle();
            System.out.println(actaulTitle);
            List<String> allProductNames = resultsPage.getAllProductNames();
            assertThat(actaulTitle, is(equalToIgnoringWhiteSpace("nike")));
            for (String item : allProductNames) {
                assertThat(item.toLowerCase(),containsString("nike"));
            }
        }

    }
/*

@When("^I search for product \"([^\"]*)\"$")
public void iSearchForProduct(String item) throws InterruptedException {
        homePage.doSearch(item);

        }
        }
*/


