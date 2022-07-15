package com.TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/fetureFiles/homePageMenus.feature",
glue = {"stepDefinitions","appHooks"},monochrome= true,
plugin = {"pretty"},publish = true) 

public class TestRunner {

}
