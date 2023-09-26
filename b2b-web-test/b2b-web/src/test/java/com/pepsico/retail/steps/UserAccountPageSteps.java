/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.helpers.FileUtils;
import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.models.web.UserAccount.LegalPolicy;
import com.pepsico.retail.models.web.UserAccount.Notification;
import com.pepsico.retail.models.web.UserAccount.YourProfile;
import com.pepsico.retail.pages.web.UserAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAccountPageSteps {

    @Autowired
    private UserAccountPage userAccountPage;

    @Autowired
    private Notification notification;

    @Autowired
    private LegalPolicy legalPolicy;

    @Autowired
    private YourProfile yourProfile;

    @Autowired
    LibraryHelper libraryHelper;



    @Then("user should be navigate to your account page")
    public void userShouldBeNavigateToYourAccountPage() {
        Assert.assertTrue(userAccountPage.isYourAccountPageDisplayed());
    }

    @And("user should see main {string} on user account page")
    public void userShouldSeeMainOnUserAccountPage(String category) throws InterruptedException {
        userAccountPage.verifyAllCategoryItemsPresent(category);
    }

    @And("user should see {string} within main category")
    public void userShouldSeeWithinMainCategory(String subCategory) throws InterruptedException {
        userAccountPage.verifyAllSubCategoryItemsPresent(subCategory);
    }

    @Then("user should be click on your profile sub category")
    public void userShouldBeClickOnYourProfileSubCategory() {
        userAccountPage.clickOnYourProfileButton();
    }

    @And("user can see personal details title texts")
    public void userCanSeePersonalDetailsTitleTexts() throws InterruptedException {
        Assert.assertTrue("personal details text elements not present", userAccountPage.personalDetailTitleText_IsPresent());
    }

    @And("user can see fields for entering personal details")
    public void userCanSeeFieldsForEnteringPersonalDetails() throws InterruptedException {
        Assert.assertTrue("fields for entering personal details does not exist", userAccountPage.personalDetailEnterField_IsPresent());
    }

    @And("user can see save changes disabled button")
    public void userCanSeeSaveChangesDisabledButton() throws InterruptedException {
        userAccountPage.saveChangesButton_IsDisabled();
    }

    @And("user can see profile pictures details")
    public void userCanSeeProfilePicturesDetails() {
        userAccountPage.imageContainerAndUploadButton_IsPresent();
    }

    @And("user can see details for deleting online account")
    public void userCanSeeDetailsForDeletingOnlineAccount() throws InterruptedException {
        userAccountPage.deleteAccountElementsIsVisible();
    }

    @And("user changes details in name field")
    public void userChangesDetailsInNameField() {
        userAccountPage.modifyNameFieldEntry();
    }

    @And("user clicks on save changed button")
    public void userClicksOnSaveChangedButton() throws InterruptedException {
        userAccountPage.clickSaveButton();
    }

    @Then("user can see personal details updated pop up")
    public void userCanSeePersonalDetailsUpdatedPopUp() {
        userAccountPage.personalDetailsUpdatedPopUp_IsVisible();
    }

    @And("user verify elements of the personal details updated pop up")
    public void userVerifyElementsOfThePersonalDetailsUpdatedPopUp() {
        userAccountPage.verifyPopUpElement();
    }

    @When("user click on close button on pop up")
    public void userClickOnCloseButtonOnPopUp() {
        userAccountPage.clickOnPopUpCloseButton();
    }

    @When("user click on cross icon on pop up")
    public void userClickOnCrossIconOnPopUp() {
        userAccountPage.clickOnPopUpCrossIcon();
    }

    @When("user click on log out sub category")
    public void userClickOnLogOutSubCategory() {
        userAccountPage.clickOnLogOutCategory();
    }

    @When("user click on yes button")
    public void userClickOnYesButton() {
        userAccountPage.clickOnYesButton();
    }

    @And("user should see elements of the log out screen")
    public void userShouldSeeElementsOfTheLogOutScreen() {
        userAccountPage.logOutScreenElementsVisible();
    }

    @And("user click on notification option")
    public void userClickOnNotificationOption() throws InterruptedException {
        userAccountPage.clickOnNotificationOption();
    }

    @And("notification toggle button should be turned off by default on notification page")
    public void notificationToggleButtonShouldBeTurnedOffByDefaultOnNotificationPage() {
        Assert.assertTrue("toggle button is not visible", notification.getTurnedOffToggleButton().isDisplayed());
    }

    @When("user turns on the toggle button on notification page")
    public void userTurnsOnTheToggleButtonOnNotificationPage() throws InterruptedException {
        userAccountPage.turnsOnToggleButton();
    }

    @Then("user will see the message {string} on notification page")
    public void userWillSeeTheMessageOnNotificationPage(String message) {
        Assert.assertEquals("Message is not displayed", message, notification.getTurnedOnNotificationTitle().getText());
    }

    @Then("user will see the message notification off {string} on notification page")
    public void userwillseethemessagenotificationoffOnNotificationPage(String message) {
        Assert.assertEquals("Message is not displayed", message, notification.getTurnedOffNotificationTitle().getText());
    }

    @When("user turns off the toggle button")
    public void userTurnsOffTheToggleButton() throws InterruptedException {
        userAccountPage.turnsOffToggleButton();
    }

    @Then("user should see notification title subtitles and toggle button on notification page")
    public void userShouldSeeNotificationTitleSubtitlesAndToggleButtonOnNotificationPage() {
        Assert.assertTrue("Notification title is not displayed", notification.getNotificationTitle().isDisplayed());
        Assert.assertTrue("Receive SMS title is not displayed", notification.getReceiveSmsTitle().isDisplayed());
        Assert.assertEquals("Receive SMS title is not matched", "Receive SMS", notification.getReceiveSmsTitle().getText());
        Assert.assertTrue("Receive SMS subtitle is not displayed", notification.getReceiveSmsSubTitle().isDisplayed());
        Assert.assertEquals("Receive SMS subtitle is not matched", "I want to receive SMS notifications.", notification.getReceiveSmsSubTitle().getText());
    }

    @And("user click on legal policy button")
    public void userClickOnLegalPolicyButton() throws InterruptedException {
        userAccountPage.clickLegalPolicyButton();
    }

    @Then("user should see title as {string} on legal policy page")
    public void userShouldSeeTitleAsOnLegalPolicyPage(String title) {
        Assert.assertEquals("legalPolicy title is not displayed", title, legalPolicy.getLegalPolicyTitle().getText());
    }

    @And("user should see download text and icon on legal policy page")
    public void userShouldSeeDownloadTextAndIconOnLegalPolicyPage() {
        Assert.assertTrue("Download Text is not displayed on legal policy page", legalPolicy.getDownloadText().isDisplayed());
        Assert.assertTrue("Download Icon is not displayed on legal policy page", legalPolicy.getDownloadIcon().isDisplayed());
    }

    @When("user click on download button")
    public void userClickOnDownloadButton() {
        userAccountPage.clickOnDownloadButtonOnLegalPolicy();
    }

    @Then("pdf file name {string} should be downloaded")
    public void pdfFileNameShouldBeDownloaded(String fileName) {
        Assert.assertTrue("file is not downloaded", FileUtils.isFileDownloaded(fileName));
    }

    @And("user should see {string} option on your profile screen")
    public void userShouldSeeOptionOnYourProfileScreen(String text) throws InterruptedException {
        libraryHelper.scrollIntoView(yourProfile.getDeleteAccountText());
        Assert.assertEquals("Delete Online account Text is not matched", text, yourProfile.getDeleteAccountText().getText());
        Assert.assertTrue("Delete Online account Text is not displayed", yourProfile.getDeleteAccountText().isDisplayed());
    }

    @When("user click on delete online account option")
    public void userClickOnDeleteOnlineAccountOption() {
        yourProfile.getDeleteAccountText().click();
    }

    @Then("delete account popup should be displayed")
    public void deleteAccountPopupShouldBeDisplayed() {
        Assert.assertTrue("popup is not displayed", yourProfile.getDeleteOnlineAccountPopUpIcon().isDisplayed());
    }

    @And("user should see title and subtitle on delete account popup")
    public void userShouldSeeTitleAndSubtitleOnDeleteAccountPopup() {
        Assert.assertTrue("popup title is not displayed", yourProfile.getDeleteAccountPopUpTitle().isDisplayed());
        Assert.assertTrue("popup subtitle is not displayed", yourProfile.getDeleteAccountPopUpSubTitle().isDisplayed());
    }

    @And("cancel button,confirm button and cross icon should be visible on delete account popup")
    public void cancelButtonConfirmButtonAndCrossIconShouldBeVisibleOnDeleteAccountPopup() {
        Assert.assertTrue("cancel button is not displayed", yourProfile.getDeleteAccountPopUpCancelButton().isDisplayed());
        Assert.assertTrue("confirm button is not displayed", yourProfile.getDeleteAccountPopUpConfirmButton().isDisplayed());
        Assert.assertTrue("cross button is not displayed", yourProfile.getDeleteAccountPopUpCloseButton().isDisplayed());

    }

    @And("user click on answer to your questions")
    public void userClickOnAnswerToYourQuestions() throws InterruptedException {
        userAccountPage.clickOnAnswerToYourQuestions();
    }

    @Then("user should see all title on the faq page")
    public void userShouldSeeAllTitleOnTheFaqPage() {
      Assert.assertTrue("Title is not visible",userAccountPage.verifyTitleOnFqaPage());

    }

    @And("user should see three sections under frequently asked questions")
    public void userShouldSeeThreeSectionsUnderFrequentlyAskedQuestions() {
        Assert.assertTrue("All sections are not visible",userAccountPage.isAllSectionsVisible());
    }

    @And("user will see each section expanded after clicking on each section on faq page")
    public void userWillSeeEachSubsectionExpandedAfterClickingOnEachSectionOnFaqPage() {
        Assert.assertTrue("Section is not expanded",userAccountPage.isSectionsExpanded());
    }

}
