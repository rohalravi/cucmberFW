/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;


import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.UserAccount.YourStore;
import com.pepsico.retail.pages.web.YourStoresScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class YourStoreSteps {

    @Autowired
    private YourStoresScreen yourStoresScreen;

    @Autowired
    private YourStore yourStore;

    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @And("user click on your store option")
    public void userClickOnYourStoreOption() {
        yourStore.getTheYourStoreLinks().click();
        //visibilityHelper.waitForElementToVisible(yourStore.getTheYourStoreText());
        visibilityHelper.waitForSeconds();
    }

    @Then("user see {string} text")
    public void userSeeText(String yourStore) {
        Assert.assertEquals(yourStore, yourStoresScreen.getYourStoreText());
    }

    @And("user should see store image")
    public void userShouldSeeStoreImage() {
        Assert.assertTrue("store image is not available", yourStore.getStoreImage().isDisplayed());
    }

    @And("user should see store name with edit icon")
    public void userShouldSeeStoreNameWithEditIcon() {
        Assert.assertTrue("store name in not present", yourStore.getStoreName().isDisplayed());
        Assert.assertTrue("edit button is not present", yourStore.getEditButton().isDisplayed());
    }

    @And("user should see store address")
    public void userShouldSeeStoreAddress() {
        Assert.assertTrue("store address is not present", yourStore.getStoreAddressContainer().isDisplayed());
    }

    @And("user should see store ID number")
    public void userShouldSeeStoreIDNumber() {
        Assert.assertTrue(yourStoresScreen.isStoreIdDisplayed());
    }

    @And("user should see the message {string}")
    public void userShouldSeeTheMessage(String incorrectInformationMessage) {
        Assert.assertEquals(incorrectInformationMessage, yourStoresScreen.getIncorrectInformationMessage());
    }

    @And("user should see help center text button link")
    public void userShouldSeeHelpCenterTextButtonLink() {
        Assert.assertTrue(" help center text button in not present", yourStore.getStoreContactHelpCenterTextButton().isDisplayed());
    }

    @And("user see store points details, badge and trade point button")
    public void userSeeStorePointsDetailsBadgeAndTradePointButton() {
        yourStoresScreen.tradePointDetails_IsPresent();
    }

    @When("user click on see help center text button link")
    public void userClickOnSeeHelpCenterTextButtonLink() {
        yourStore.getStoreContactHelpCenterTextButton().click();
    }

    @Then("user can see call help center pop up appear on your store screen")
    public void userCanSeeCallHelpCenterPopUpAppearOnYourStoreScreen() {
        Assert.assertTrue("pop up title text is not visible", yourStore.getPopUpTitleText().isDisplayed());
    }

    @And("user can see store pop up image")
    public void userCanSeeStorePopUpImage() {
        Assert.assertTrue("pop up image is not displayed", yourStore.getPopUpImage().isDisplayed());
    }

    @And("user can see help line text details")
    public void userCanSeeHelpLineTextDetails() {
        Assert.assertTrue("help line text is not displayed", yourStoresScreen.isPopUpHelpLineText_Present());
    }

    @And("user should see close pop up button")
    public void userShouldSeeClosePopUpButton() {
        Assert.assertTrue("pop up close button is not displayed", yourStore.getPopUpCloseButton().isDisplayed());
    }

    @When("user click on close pop up button")
    public void userClickOnClosePopUpButton() {
        yourStore.getPopUpCloseButton().click();
    }

    @When("user click on cross button on help line pop up")
    public void userClickOnCrossButtonOnHelpLinePopUp() {
        yourStore.getPopUpCrossButton().click();
    }

    @When("user click on edit button on your store page")
    public void userClickOnEditButtonOnYourStorePage() {
        yourStore.getEditButton().click();
    }

    @Then("user can see store name edit pop up appear on your store screen")
    public void userCanSeeStoreNameEditPopUpAppearOnYourStoreScreen() {
        Assert.assertTrue("edit store name pop up not appeared", yourStore.getPopUpStoreName().isDisplayed());
    }

    @And("user can see edit store nickname field")
    public void userCanSeeEditStoreNicknameField() {
        Assert.assertTrue("edit store name field is not present", yourStore.getEditStoreName().isDisplayed());
    }

    @And("user can see cancel and save buttons")
    public void userCanSeeCancelAndSaveButtons() {
        yourStore.getPopUpCancelButton().isDisplayed();
        yourStore.getPopUpSaveButton().isDisplayed();
    }

    @When("user click on cancel button on store name popup")
    public void userClickOnCancelButtonOnStoreNamePopup() {
        yourStore.getPopUpCancelButton().click();
    }

    @And("user click on cross button on store name popup")
    public void userClickOnCrossButtonOnStoreNamePopup() {
        yourStore.getPopUpCrossButton().click();
    }

    @When("user click on contact help center link on your store page")
    public void userClickOnContactHelpCenterLinkOnYourStorePage() {
        yourStore.getStoreContactHelpCenterTextButton().click();
    }

    @Then("user can see help center pop up on store page")
    public void userCanSeeHelpCenterPopUpOnStorePage() {
        yourStore.getHelpLinePopUpTitleText().isDisplayed();
    }

    @Then("user will navigate to your store page")
    public void userWillNavigateToYourStorePage() {
        yourStore.getStoreName().isDisplayed();
    }

    @When("user click on close button on help line pop up")
    public void userClickOnCloseButtonOnHelpLinePopUp() {
        yourStore.getHelpLinePopUpCloseButton().click();
    }

    @And("user click on transfer your points")
    public void userClickOnTransferYourPoints() {
        libraryHelper.executeJS("window.scrollBy(0,600)","");
        visibilityHelper.waitForVisibilityOf(yourStore.getTransferYourPointsButton());
        yourStore.getTransferYourPointsButton().click();
        visibilityHelper.waitForElementToVisible(yourStore.getHowManyPointsTransferLabelField());
        libraryHelper.executeJS("window.scrollBy(0,-900)","");
        visibilityHelper.waitForElementToVisible(yourStore.getTransferDetailsTitle());
    }

    @Then("user should see Transfer points back button")
    public void userShouldSeeTransferPointsBackButton() {
        Assert.assertTrue("Transfer points back button is not displayed",yourStore.getTransferYourPointsBackButton().isDisplayed());
    }

    @And("user should see transfer details text")
    public void userShouldSeeTransferDetailsText() {
        Assert.assertTrue("transfer details text is not visible",yourStore.getTransferDetailsTitle().isDisplayed());
    }

    @And("user should see From text and corresponding text box")
    public void userShouldSeeFromTextAndCorrespondingTextBox() {
        Assert.assertTrue("From Text label field is not visible",yourStore.getTransferPointsFromLabelField().isDisplayed());
        Assert.assertTrue("From Text input field is not visible",yourStore.getTransferPointsFromInputField().isDisplayed());

    }

    @And("user should see To text and corresponding text box")
    public void userShouldSeeToTextAndCorrespondingTextBox() {
        Assert.assertTrue("To label field is not visible",yourStore.getTransferPointsToLabelField().isDisplayed());
        Assert.assertTrue("To Input field is not visible",yourStore.getTransferPointsToInputField().isDisplayed());

    }

    @And("user should see list to stores in to option")
    public void userShouldSeeListToStoresInToOption() {
        yourStore.getTransferPointsToInputField().click();
        visibilityHelper.waitForElementToVisible(yourStore.getTransferPointsToInputDropDownField().get(0));
        for(int i=0;i< yourStore.getTransferPointsToInputDropDownField().size();i++){
            Assert.assertFalse("Store name in dropdown is not visible",libraryHelper.isValueEmpty(yourStore.getTransferPointsToInputDropDownField().get(i).getText()));
        }
        yourStore.getTransferPointsToInputDropDownField().get(0).click();
    }

    @And("user should see how many points text and corresponding text box")
    public void userShouldSeeHowManyPointsTextAndCorrespondingTextBox() {
        Assert.assertTrue("How many points label is not visible",yourStore.getHowManyPointsTransferLabelField().isDisplayed());
        Assert.assertTrue("How many points input field is not visible",yourStore.getHowManyPointsTransferInputField().isDisplayed());

    }

    @And("user should see transfer your points button")
    public void userShouldSeeTransferYourPointsButton() {
        libraryHelper.executeJS("window.scrollBy(0,250)","");
        visibilityHelper.waitForElementToVisible(yourStore.getTransferPointsButton());
        Assert.assertTrue("Transfer your points button is not visible",yourStore.getTransferPointsButton().isDisplayed());
    }

    @And("user select one store from to dropdown")
    public void userSelectOneStoreFromToDropdown() {
        yourStore.getTransferPointsToInputField().click();
        yourStore.getTransferPointsToInputDropDownField().get(1).click();
    }

    @And("user enter {string} points in how many points shall we transfer")
    public void userEnterPointsInHowManyPointsShallWeTransfer(String value) {
        yourStore.getHowManyPointsTransferInputField().sendKeys(value);
    }

    @And("user click on transfer points button")
    public void userClickOnTransferPointsButton() {
        yourStore.getTransferPointsButton().click();
    }

    @Then("user should see popup with text and subtext")
    public void userShouldSeePopupWithTextAndSubtext() {
        Assert.assertTrue("Popup with Title is not visible",yourStore.getTransferYourPointsPopupTitle().isDisplayed());
        Assert.assertTrue("Popup with SUbtitle is not visible",yourStore.getTransferYourPointsPopupSubTitle().isDisplayed());


    }

    @And("user should see cancel and yes option")
    public void userShouldSeeCancelAndYesOption() {
        Assert.assertTrue("Cancel button is not visible",yourStore.getCancelTransferPointsButtonOnPopUp().isDisplayed());
        Assert.assertTrue("Yes button is not visible",yourStore.getYesTransferPointsButtonOnPopUp().isDisplayed());

    }

    @When("user clicks on Transfer points back button")
    public void userClicksOnTransferPointsBackButton() {
        libraryHelper.executeJS("window.scrollBy(0,-800)","");
        visibilityHelper.waitForElementToVisible(yourStore.getTransferYourPointsBackButton());
        yourStore.getTransferYourPointsBackButton().click();
        visibilityHelper.waitForElementToVisible(yourStore.getTransferYourPointsButton());
    }

    @Then("user should move back to your stores page")
    public void userShouldMoveBackToYourStoresPage() {
        Assert.assertTrue("Your store page is not displayed",yourStore.getTransferYourPointsButton().isDisplayed());
    }
}
