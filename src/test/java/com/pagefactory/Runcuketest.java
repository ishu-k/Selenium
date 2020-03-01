package com.pagefactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions( features = .)
@CucumberOptions(features = "C:\\Users\\ishuk\\IdeaProjects\\pagefactory\\src\\test\\resources", plugin = {"json:target/cucumber-reports/CucumberTestReport.json"})
public class Runcuketest {

}
