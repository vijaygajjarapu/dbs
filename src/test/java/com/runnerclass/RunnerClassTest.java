package com.runnerclass;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import com.dbs.stepDefinitions.*;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "pretty:STDOUT", "html:format","pretty", "json:target/cucumber.json",
		"html:target/index.html" }, features = {"src/test/resources/com/dbs/features"}, tags = {
				"@CompareCards" },glue = { "com.dbs.stepDefinitions" })

public class RunnerClassTest {	
	
}