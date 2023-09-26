/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.pages.common.LoginPage;
import com.pepsico.retail.pages.web.LandingPage;
import com.pepsico.retail.pages.web.LoginMultiStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginMultiStoreSteps {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private LandingPage landingPage;

    @Autowired
    LoginMultiStorePage loginMultiStorePage;

    @Then("user can see store selection screen")
    public void userCanSeeStoreSelectionScreen() {
        loginMultiStorePage.storeSelectionScreen_IsPresent();
    }



    @Then("user validate elements of store selection screen")
    public void userValidateElementsOfStoreSelectionScreen() {
        loginMultiStorePage.validateStoreSelectionScreenElements();
    }

    @Then("user click on the view all link on store selection screen")
    public void userClickOnTheViewAllLinkOnStoreSelectionScreen() {
        loginMultiStorePage.validateAndClickOnViewAllLink();
    }

    @Then("user validate the elements of the store selection pop up on store selection screen")
    public void userValidateTheElementsOfTheStoreSelectionPopUpOnStoreSelectionScreen() {
        loginMultiStorePage.validateStoreSelectionPopUpElements();
    }

    @And("user can close store pop up by click on close button")
    public void userCanCloseStorePopUpByClickOnCloseButton() {
        loginMultiStorePage.clickOnPopUpCloseButton();
    }

    @When("user selects and any one store on store selection screen")
    public void userSelectsAndAnyOneStoreOnStoreSelectionScreen() {
        loginMultiStorePage.selectFirstStoreRadioButton();
    }

    @And("user click on next step button")
    public void userClickOnNextStepButton() {
        loginMultiStorePage.clickOnNextStepButton();
    }
}
