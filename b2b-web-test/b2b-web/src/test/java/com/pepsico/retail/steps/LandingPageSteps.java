/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.pages.web.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class LandingPageSteps {


    @Autowired
    private LandingPage landingPage;

    @When("user navigate on the landing page")
    public void userNavigateOnTheLandingPage() {
        Assert.assertTrue("Welcome text is not visible", landingPage.verifyWelcomeContainerText());
    }

    @Then("user verify welcome container title on landing page")
    public void userVerifyWelcomeContainerTitleOnLandingPage() throws InterruptedException {
        Assert.assertTrue("Welcome text is not visible", landingPage.verifyWelcomeContainerText_IsPresent());
    }

    @And("user verify welcome container image on landing page")
    public void userVerifyWelcomeContainerImageOnLandingPage() {
        Assert.assertTrue("Welcome text is not visible", landingPage.verifyWelcomeContainerImage());
    }

    @And("user see title text for login on landing page")
    public void userSeeTitleTextForLogin() {
        Assert.assertTrue("Have an account? Please login text is not visible", landingPage.loginTitleText_IsPresent());
    }

    @Then("user see phone number and password text on landing page")
    public void userSeePhoneNumberAndPasswordText() {
        Assert.assertTrue("Phone Number and Password text are not visible", landingPage.phoneNumberAndPasswordText_IsPresent());
    }

    @And("user see fields for entering phone number and password on landing page")
    public void userSeeFieldsForEnteringPhoneNumberAndPassword() {
        Assert.assertTrue("Phone number and password fields are not visible", landingPage.phoneNumberAndPasswordEntryFields_IsPresent());
    }

    @And("user see login button")
    public void userSeeLoginButton() {
        Assert.assertTrue("login button is not visible", landingPage.loginButton_IsDisplayed());
    }

    @And("user can see did you forget your password text on landing page")
    public void userCanSeeDidYouForgetYourPasswordTextOnLandingPage() {
        Assert.assertTrue("did you forget you password? is not visible", landingPage.forgetPasswordHelp_IsPresent());
    }

    @And("user see remember me text with radio button")
    public void userSeeRememberMeTextWithRadioButton() throws InterruptedException {
        Assert.assertTrue("Welcome text is not visible", landingPage.rememberMeText_IsPresent());
        landingPage.radioButtonIsDisplayed();
    }

    @And("user should see new to PepsiConnect massage")
    public void userShouldSeeNewToPepsiConnectMassage() throws InterruptedException {
        Assert.assertTrue("new to pepsiConnect? not visible on landing page", landingPage.newToPepsiConnectText_IsPresent());
    }

    @And("user see register now button")
    public void userSeeRegisterNowButton() {
        Assert.assertTrue("register now button is not visible", landingPage.registerNowButton_IsPresent());
    }

    @And("user should see descriptive text on landing page")
    public void userShouldSeeDescriptiveTextOnLandingPage() throws InterruptedException {
        Assert.assertTrue("Description image and text is not visible", landingPage.descriptiveText_IsDisplayed());
    }

    @And("user should see descriptive image on landing page")
    public void userShouldSeeDescriptiveImageOnLandingPage() throws InterruptedException {
        Assert.assertTrue("Description image and text is not visible", landingPage.descriptiveImage_IsDisplayed());
    }

    @And("user scroll down to see discover brand title")
    public void userScrollDownToSeeDiscoverBrandTitle() throws InterruptedException {
        Assert.assertTrue("discover our brand title is not visible", landingPage.discoverBrandTitle_IsDisplayed());
    }

    @Then("user can see discover brand tiles")
    public void userCanSeeDiscoverBrandTiles() throws InterruptedException {
        Assert.assertTrue("brand tiles not present",landingPage.discoverBrandTiles_IsPresent());
    }

    @And("user can see discover brand images")
    public void userCanSeeDiscoverBrandImages() throws InterruptedException {
        Assert.assertTrue("brand tiles not present",landingPage.discoverBrandImages_IsPresent());
    }

    @And("user clicks on did you forget your password button on landing page")
    public void userClicksOnDidYouForgetYourPasswordButtonOnLandingPage() {
        landingPage.clickOnDidYouForgetPasswordLink();
    }

    @Then("user can see error pop up appear on landing page")
    public void userCanSeeErrorPopUpAppearOnLandingPage() {
        landingPage.errorPopUp_IsPresent();
    }

    @And("user validate elements of the error pop up")
    public void userValidateElementsOfTheErrorPopUp() {
        landingPage.verifyErrorPopUpElements();
    }

    @When("user click on try again button on wrong credential error pop up")
    public void userClickOnTryAgainButtonOnWrongCredentialErrorPopUp() {
        landingPage.clickTryAgainButtonOnPopUp();
    }

    @When("user click on cross button on wrong credential error pop up")
    public void userClickOnCrossButtonOnWrongCredentialErrorPopUp() {
        landingPage.clickOnCrossButtonOnPopUp();
    }

    @Then("password should be masked in password field on landing page")
    public void passwordShouldBeMaskedInPasswordFieldOnLandingPage() {
        Assert.assertEquals("Password is not masked", "password",landingPage.getMaskedPassword().getAttribute("type"));
    }

    @When("user clicks on eye icon of the password field on landing page")
    public void userClicksOnEyeIconOfThePasswordFieldOnLandingPage() {
        landingPage.clickOnPasswordEyeIcon();
    }

    @Then("password should be unmasked in the password fields on landing page")
    public void passwordShouldBeUnmaskedInThePasswordFieldsOnLandingPage() {
        Assert.assertEquals("Password is not unmasked","text", landingPage.getMaskedPassword().getAttribute("type"));
    }
    @When("user click on the register now button on landing page")
    public void userClickOnTheRegisterNowButtonOnLandingPage() {
        landingPage.clickOnRegisterNowButton();
    }
}
