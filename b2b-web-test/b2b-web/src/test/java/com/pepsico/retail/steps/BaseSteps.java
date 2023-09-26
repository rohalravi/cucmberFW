/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import static org.openqa.selenium.support.PageFactory.initElements;

import com.pepsico.retail.pages.BasePage;
import com.pepsico.retail.pages.common.LoginPage;
import com.pepsico.retail.runners.Hook;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSteps.class);

    @Autowired
    private Hook hooks;

    @Autowired
    private List<BasePage> pages;

    @Autowired
    private LoginPage loginPage;

    @Before(order = 1)
    public void logBeforeScenario(final Scenario scenario) {
        LOGGER.debug(StringUtils.rightPad("Starting scenario:", 20) + "[{}] - [{}]",
                getFeatureName(scenario),
                scenario.getName());
    }

    @Before(order = 2)
    public void initializeDriver() {
        final WebDriver driver = hooks.getDriver();
        pages.forEach(p -> initElements(driver, p));
    }

    @After(order = 1)
    public void closeDriver(final Scenario scenario) {
        hooks.tearDown(scenario);
        hooks.closeDriver();
    }

    @After(order = Integer.MAX_VALUE)
    public void logAfterScenario(final Scenario scenario) {
        LOGGER.debug(StringUtils.rightPad("Finished scenario:", 20) + "[{}] - [{}] [{}]",
                getFeatureName(scenario),
                scenario.getName(),
                scenario.getStatus());
    }

    private String getFeatureName(Scenario scenario) {
        String featureName = scenario.getId();

        featureName = StringUtils.substringBeforeLast(featureName, ".feature");
        featureName = StringUtils.substringAfterLast(featureName, "/");
        return featureName;
    }
}
