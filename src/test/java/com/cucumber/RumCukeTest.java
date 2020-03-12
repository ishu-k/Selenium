package com.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ishuk\\IdeaProjects\\CucumberProject\\src\\test\\resources",plugin = {"json:target/cucumber.json"})
public class RumCukeTest {
}
