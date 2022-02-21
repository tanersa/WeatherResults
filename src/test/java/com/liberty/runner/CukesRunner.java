package com.liberty.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports", //generates every time we run the cukes runner
				"json:target/cucumber.json"
		
		},		
		tags="@temp",
		features= {"src/test/resources/features"}, 
		glue= {"com/liberty/step_definitions" }
		,dryRun = false
		)

public class CukesRunner {}

