package com.pepsico.retail.steps;

import com.pepsico.retail.helpers.UIConstants;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.UserAccount.YourProfile;
import com.pepsico.retail.pages.web.UserAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class AddProfilePictureStepDefs {

    @Autowired
    UserAccountPage userAccountPage;

    @Autowired
    YourProfile yourProfile;

    @Autowired
    VisibilityHelper visibilityHelper;

    @And("user click on add profile picture button")
    public void userClickOnAddProfilePictureButton() {
        userAccountPage.clickOnAddProfileButton();
    }

    @And("user add picture more than ten mb in size")
    public void userAddPictureMbInSize() throws IOException {
        userAccountPage.addPicture(UIConstants.Image_MORE_THAN_10_MB_PATH);
    }

    @When("user clicks on close button")
    public void userClicksOnCancelButton() {
        yourProfile.getPicUpdatedCloseButtonPopUp().click();
    }

    @Then("user navigate back to your profile page")
    public void userNavigateBackToYourProfilePage() {
        Assert.assertTrue("user is not navigated back to your profile page",yourProfile.getAddProfilePicButton().isDisplayed());
    }

    @When("user add picture in other format than jpg and png")
    public void userAddPictureInOtherFormatThanJpgAndPng() throws IOException {
        userAccountPage.addPicture(UIConstants.File_IN_OTHER_FORMAT);
    }

    @And("user click on replace profile picture button")
    public void userClickOnReplaceProfilePictureButton() {
        userAccountPage.clickReplacePicButton();
    }

    @And("user add picture ten mb in size")
    public void userAddPicturetenMbInSize() throws IOException {
        userAccountPage.addPicture(UIConstants.Image_10_MB_PATH);
    }


    @Then("user shall see message {string}")
    public void userShallSeeMessage(String message) {
        Assert.assertEquals("Your profile pic added message not displayed",message,yourProfile.getPicUpdatedPopUpText().getText());
    }

    @And("user shall see close button and cancel popup on your profile picture popup")
    public void userShallSeeCloseButtonAndCancelPopupOnYourProfilePicturePopup() {
        Assert.assertTrue("close button is not visible",yourProfile.getPicUpdatedCloseButtonPopUp().isDisplayed());
        Assert.assertTrue("cross button is not visible",yourProfile.getPicUpdatedCrossButtonPopUp().isDisplayed());

    }

    @And("user should see pop up with message on adding incorrrect picture")
    public void userShouldSeePopUpWithMessageOnAddingPicture() {
        Assert.assertTrue("Your profile pic failed message not displayed",yourProfile.getPicUpdatedPopUpText().isDisplayed());
        Assert.assertTrue("Your profile size more than 10mb message not displayed",yourProfile.getPicUpdatedPopUpTextSubTitle().isDisplayed());
    }

    @Then("add a profile picture text should display")
    public void addAProfilePictureTextShouldDisplay() {
        Assert.assertTrue("Add a profile pic text is not displayed",yourProfile.getAddProfilePicButton().isDisplayed());
    }

    @And("user should see supported file format text")
    public void userShouldSeeSupportedFileFormatText() {
        for(int i=0;i<yourProfile.getSupportedFileFormatText().size();i++) {
            Assert.assertTrue("Supported file format text is not displayed", yourProfile.getSupportedFileFormatText().get(i).isDisplayed());
        }
    }

    @And("image upload camera icon should display")
    public void imageUploadCameraIconShouldDisplay() {
        Assert.assertTrue("Supported file format text is not displayed",yourProfile.getCameraIcon().isDisplayed());
    }

    @When("user clicks on upload again button")
    public void userClicksOnUploadAgainButton() {
     userAccountPage.clickOnUploadButtonAgain();
    }

    @Then("user should see pop up for updating pic with message {string}")
    public void userShouldSeePopUpForUpdatingPicWithMessage(String message){
        visibilityHelper.waitForSeconds();
        Assert.assertTrue("Success Icon is not displayed",yourProfile.getSuccessIcon().isDisplayed());
        Assert.assertTrue("Pic Updated text is not displayed",yourProfile.getSuccessText().isDisplayed());
        Assert.assertTrue("Pic Updated close button is not displayed",yourProfile.getPicUpdatedPopUpCloseButton().isDisplayed());
        Assert.assertEquals("Pic updated text is not correct",message,yourProfile.getSuccessText().getText());
    }
}
