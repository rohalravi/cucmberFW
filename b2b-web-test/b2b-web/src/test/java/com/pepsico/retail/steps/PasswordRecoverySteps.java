/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.pages.web.LandingPage;
import com.pepsico.retail.pages.web.PasswordRecoveryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordRecoverySteps {

    @Autowired
    private PasswordRecoveryPage passwordRecoveryPage;

    @Then("user should navigate to the password recovery page")
    public void userShouldNavigateToThePasswordRecoveryPage() {
        passwordRecoveryPage.forgetPasswordTitleText_IsPresent();
    }

    @Then("user can see the forget password title text on password recovery page")
    public void userCanSeeTheForgetPasswordTitleTextOnPasswordRecoveryPage() {
        passwordRecoveryPage.ForgetPasswordTitleText_IsPresent();

    }

    @When("user click on go back button on password recovery page")
    public void userClickOnGoBackButtonOnPasswordRecoveryPage() {
        passwordRecoveryPage.clickOnGoBackButton();
    }

    @And("user can see forget password sub text on password recovery page")
    public void userCanSeeForgetPasswordSubTextOnPasswordRecoveryPage() {
        passwordRecoveryPage.forgetPasswordSubText_IsPresent();
    }

    @And("user can see phone number text on password recovery page")
    public void userCanSeePhoneNumberTextOnPasswordRecoveryPage() {
        passwordRecoveryPage.phoneNumberTitleText_IsPresent();
    }

    @And("user can see field to enter phone number with text in it as {string}")
    public void userCanSeeFieldToEnterPhoneNumberWithTextInItAsEnterYourPhoneNumber() {
        Assert.assertEquals("Enter your phone number is not displayed","Enter your phone number",passwordRecoveryPage.EnterPhoneNumberText());
    }

    @And("user can see go back button with back arrow on it")
    public void userCanSeeGoBackButtonWithBackArrowOnIt() {
        passwordRecoveryPage.BackButtonElements_IsPresent();
    }

    @And("user can see disabled verify button with forward arrow")
    public void userCanSeeDisabledVerifyButtonWithForwardArrow() {
        passwordRecoveryPage.disabledVerifyButton_IsPresent();
    }

    @Then("user enter wrong phone number on password recovery page")
    public void userEnterWrongPhoneNumberOnPasswordRecoveryPage() {
        passwordRecoveryPage.enterWrongPhoneNumber();
    }

    @And("click on verify button on password recovery page")
    public void clickOnVerifyButtonOnPasswordRecoveryPage() {
        passwordRecoveryPage.clickOnVerifyButton();
    }

    @Then("user can see error pop up")
    public void userCanSeeErrorPopUp() {
        passwordRecoveryPage.errorPopUpIsDisplayed();
    }

    @And("user validate elements of error pop-up")
    public void userValidateElementsOfErrorPopUp() {
        passwordRecoveryPage.errorPopUpElements_ArePresent();
    }

    @When("user click on try again button on error pop up")
    public void userClickOnTryAgainButtonOnErrorPopUp() {
        passwordRecoveryPage.clickTryAgainButton();
    }
}
