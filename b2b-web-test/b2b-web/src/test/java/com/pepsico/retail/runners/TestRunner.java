/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "classpath:features", plugin = { "pretty", "html:target/results/cucumber-reports.html",
                "json:target/results/cucumber.json",
                "junit:target/results/cucumber.xml" }, glue = "com.pepsico.retail", tags = "@checkout_with_external_testdata ")

public class TestRunner {

}