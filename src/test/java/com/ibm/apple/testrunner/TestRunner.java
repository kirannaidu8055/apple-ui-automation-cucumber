package com.ibm.apple.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features"},
		glue = {"com.ibm.apple.steps"},
		plugin = {"pretty","html:Reports/Report.html"},
		dryRun = false,
		monochrome = true
	//	tags = "@P1"
	  //name = "password"
		)
public class TestRunner {

}
