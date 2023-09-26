/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.pages.common.LoginPage;
import com.pepsico.retail.pages.web.GlobalComponentsPage;
import com.pepsico.retail.pages.web.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private LandingPage landingPage;

    @Autowired
    GlobalComponentsPage globalComponentsPage;

    @When("user provides the credentials as {string} and {string} on login page")
    public void user_provides_the_credentials_as_and_on_login_page(String sPhoneNumber, String sLoginPassword) {
        loginPage.loginCredentials(sPhoneNumber, sLoginPassword);
    }

    @Then("user should see login button gets active")
    public void userShouldSeeLoginButtonGetsActive() {
        landingPage.loginButtonActive_IsPresent();
    }

    @Then("user should see login button gets active and clickable")
    public void userShouldSeeLoginButtonGetsActiveAndCLickable() {
        landingPage.loginButtonActive_Click();
    }

    @Then("user should see {string} message for phoneNumber")
    public void userShouldSeeMessageForPhoneNumber(String message) {
        String actial_message = loginPage.getPhoneNumberValidationMessage();
       Assert.assertEquals(message,actial_message);
    }

    @Then("user should see pop up with message {string}")
    public void userShouldSeePopUpWithMessage(String message) {
        String[] messages=message.split(":");
        Assert.assertTrue("Popup is not visible",loginPage.verifyPopUp(messages));
    }

    @Then("user should see maximum attempt pop up with message {string}")
    public void userShouldSeeMaximumAttemptPopUpWithMessage(String message) {
        Assert.assertEquals("Maximum login attempts popup is not displayed",
                message,loginPage.isMaximumAttemptPopupDisplayed());
    }

    @And("user should see cross icon and try again button on popup")
    public void userShouldSeeCrossIconAndImageOnPopup() {
        Assert.assertTrue("Cross Icon and Image is not visible",loginPage.isCrossIconAndTryAgainButtonPesent());
    }

    @When("user enters login credential to see popup {string} and {string} on login page")
    public void userEntersLoginCredentialToSeePopupAndOnLoginPage(String phone, String password) {
        loginPage.enterPhoneNumberAndPassword(phone,password);
    }

    @And("helpLine banner pop up is visible at popup")
    public void helplineBannerPopUpIsVisibleAtPopup() {
        Assert.assertTrue("Popup is not visible",loginPage.isHelpineLineBannerOnPopUpVisible());
    }

    @And("user click on login button on landing page")
    public void userClickOnLoginButtonOnLandingPage() {
        loginPage.clickOnLoginButton();
    }


    @When("user click on cross button in login field to reset phone number field")
    public void userClickOnCrossButtonInPhoneNumberField() {
        loginPage.clickOnPhoneNumberCrossIcon();
    }

    @Then("user should not see {string} message for phoneNumber")
    public void userShouldNotSeeMessageForPhoneNumber(String message) {
        String actual_message = loginPage.getPhoneNumberValidationMessage();
        Assert.assertNotEquals(message, actual_message);
    }

    @When("user enter username as {string}")
    public void userEnterUsernameAs(String mPhoneNumber) {
        loginPage.enterUserName(mPhoneNumber);
    }

    @And("user enter password as {string}")
    public void userEnterPasswordAs(String mPassword) {
        loginPage.enterPassword(mPassword);
    }
}
