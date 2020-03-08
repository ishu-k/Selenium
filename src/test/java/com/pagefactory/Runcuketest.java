package com.pagefactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions( features = .)
@CucumberOptions(features = "C:\\Users\\ishuk\\IdeaProjects\\pagefactory\\src\\test\\resources",plugin = {""pretty","json:target/cucumber.json","html:target/site/cucumber-html"})
public class Runcuketest {

}
