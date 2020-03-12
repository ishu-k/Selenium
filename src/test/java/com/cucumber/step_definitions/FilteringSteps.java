package com.cucumber.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;


public class FilteringSteps {

   public static WebDriver driver;

    @Given("^Im on homepage$")
    public void im_on_homepage()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver() ;

    }

    @Given("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String arg1) {
        driver.get("https://www.argos.co.uk/");
        WebElement element=driver.findElement(By.id("searchTerm"));
        element.sendKeys("nike");
        element.sendKeys(Keys.ENTER);
        System.out.println("homepage");
    }

    @When("^I apply the (\\d+) filters$")
    public void i_apply_the_filters(int filters, List<Map<String,String>> filter) throws InterruptedException {
        System.out.println("there are "+filters+" filters" + filter.toString());
        //String s=driver.findElement(By.xpath("//div[@class='Drawerstyles__Content-mvyw7g-5 cGMixZ filter-panel--static filter-panel lg-3--none-content']")).getText();
        // int string=elements.size();
        List<WebElement>  elements= driver.findElements(By.xpath("//div[@class='Drawerstyles__Content-mvyw7g-5 cGMixZ filter-panel--static filter-panel lg-3--none-content']"));
        Thread.sleep(3000);
        System.out.println(elements);

       // System.out.println(s);
    }

    @Then("^I should get the desired Product$")
    public void i_should_get_the_desired_Product()
    {

    }
    
}




