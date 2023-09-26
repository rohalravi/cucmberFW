/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.models.web.UserAccount.YourProfile;
import com.pepsico.retail.pages.web.UserAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordSteps {

    @Autowired
    private UserAccountPage userAccountPage;

    @Autowired
    private YourProfile yourProfile;

    @Autowired
    LibraryHelper libraryHelper;

    @And("user should see change password text on your profile page")
    public void userShouldSeeChangePasswordTextOnYourProfilePage() throws InterruptedException {
        Assert.assertTrue("Change password text not visible", userAccountPage.isChangePasswordTextVisible());
    }

    @When("user click on change password text option on your profile page")
    public void userClickOnChangePasswordTextOptionOnYourProfilePage() {
        userAccountPage.clickChangePasswordText();
    }

    @Then("popup title and subtitle should be visible")
    public void popShouldBeVisibleForChangePasswordPage() {
        Assert.assertTrue("PopUp title is not visible", yourProfile.getPopUpTitle().isDisplayed());
        Assert.assertTrue("PopUp subtitle is not visible", yourProfile.getChangePasswordPopUpSubTitle().isDisplayed());

    }

    @And("cancel and change Password button should be visible on change password popup")
    public void cancelAndChangePasswordButtonShouldBeVisibleOnChangePasswordPopup() {
        Assert.assertTrue("Cancel button is not visible", yourProfile.getCancelButton().isDisplayed());
        Assert.assertTrue("Change password button is not visible", yourProfile.getChangePasswordButton().isDisplayed());

    }

    @And("cross icon should be visible on change password popup")
    public void crossIconShouldBeVisibleOnChangePasswordPopup() {
        Assert.assertTrue("Cross icon is not visible", yourProfile.getCrossIcon().isDisplayed());
        libraryHelper.executeJS("window.scrollBy(0,500)", "");
    }

    @And("user enters {string} in current password field")
    public void userEntersInCurrentPasswordField(String password) {
        userAccountPage.enterCurrentPassword(password);
    }

    @And("user enters {string} in new password field")
    public void userEntersInNewPasswordField(String password) {
        userAccountPage.enterNewPassword(password);
    }

    @Then("okta requirement text highlight in red color")
    public void oktaRequirementTextHighlightInRedColor() {
        Assert.assertTrue("Okta requirement text not highlighted", yourProfile.getOktaReqText().isDisplayed());
    }

    @And("user enter same password {string} in confirm password field")
    public void userEnterSamePasswordInConfirmPasswordField(String password) throws InterruptedException {
        userAccountPage.enterPasswordInConfirmPasswordField(password);
    }

    @And("user enter password {string} in confirm password field")
    public void userEnterPasswordInConfirmPasswordField(String password) throws InterruptedException {
        userAccountPage.enterPasswordInConfirmPasswordField(password);
    }

    @Then("user shall see {string} on change password popup")
    public void userShallSeeMessageOnChangePasswordPopup(String message) {
        Assert.assertEquals("Message Both passwords must match is not displayed", message, yourProfile.getSamePasswordText().getText());
    }

    @And("user click on change password button")
    public void userClickOnChangePasswordButton() {
        userAccountPage.clickChangePasswordButton();
    }

    @Then("popup should be visible")
    public void popupShouldBeVisible() {
        Assert.assertEquals("Successful text is not displayed", "Your password has been updated", yourProfile.getSuccessTitle().getText());
        Assert.assertTrue("Close button is not visible", yourProfile.getCloseButton().isDisplayed());
    }

    @When("user clicks on eye icon on all the fields")
    public void userClicksOnEyeIconOnAllTheFields() {
        userAccountPage.clickOnEyeIcon();
    }

    @Then("password should be unmasked for all the fields")
    public void passwordShouldBeUnmaskedForAllTheFields() {
        Assert.assertEquals("Confirm Password is not unmasked", "text", yourProfile.getPopUpConfirmPasswordInput().getAttribute("type"));
        Assert.assertEquals("New Password is not unmasked", "text", yourProfile.getPopUpNewPasswordInput().getAttribute("type"));
        Assert.assertEquals("Current Password is not unmasked", "text", yourProfile.getPopUpCurrentPasswordInput().getAttribute("type"));

    }

    @Then("password should be masked for all the fields")
    public void passwordShouldBeMaskedForAllTheFields() {
        Assert.assertEquals("Confirm Password is not masked", "password", yourProfile.getPopUpConfirmPasswordInput().getAttribute("type"));
        Assert.assertEquals("New Password is not masked", "password", yourProfile.getPopUpNewPasswordInput().getAttribute("type"));
        Assert.assertEquals("Current Password is not masked", "password", yourProfile.getPopUpCurrentPasswordInput().getAttribute("type"));
    }

    @And("change password button should be enabled on popup")
    public void changePasswordButtonShouldBeEnabledOnPopup() {
        Assert.assertTrue("Change password button is not enabled", yourProfile.getChangePasswordButton().isEnabled());
    }

    @And("change password should not be enabled on change password popup")
    public void changePasswordButtonShouldNotBeEnabledOnPopup() throws InterruptedException {
        libraryHelper.scrollIntoView(yourProfile.getChangePasswordButton());
        Assert.assertFalse("Change password button is not enabled", yourProfile.getChangePasswordButton().isEnabled());
    }

}