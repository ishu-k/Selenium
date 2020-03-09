package com.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ishuk\\IdeaProjects\\bddproject\\src\\test\\resouces", plugin = {"pretty","json:target/cucumber-reports/CucumberTestReport.json","html:target/site/cucumber-html"})
public class RuncukeTest {
}
