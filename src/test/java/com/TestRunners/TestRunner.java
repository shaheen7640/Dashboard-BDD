package com.TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/fetureFiles",
glue = {"stepDefinitions","appHooks"},monochrome= true,
plugin = {"pretty"},publish = true,tags="not @ignore") 

public class TestRunner {

}
