package com.pepsico.retail.steps;

import com.pepsico.retail.pages.web.LoginMultiStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchYourStoresSteps {

    @Autowired
    LoginMultiStorePage loginMultiStorePage;

    @And("user should see your stores title text on store selection screen")
    public void userShouldSeeYourStoresTitleTextOnStoreSelectionScreen() {
        Assert.assertTrue("Your stores title text is not visible", loginMultiStorePage.getYourstoreTitleText().isDisplayed());
    }

    @And("user should see search store option store selection screen")
    public void userShouldSeeSearchStoreOptionStoreSelectionScreen() {
        Assert.assertTrue("Search store option is not visible", loginMultiStorePage.getYourstoreTitleText().isDisplayed());

    }

    @And("user should see all list of store store selection screen")
    public void userShouldSeeAllListOfStoreStoreSelectionScreen() {
        Assert.assertTrue("All stores list is not visible", loginMultiStorePage.isAllStoreListDisplayed());

    }

    @And("user should see select store and close options on store selection screen")
    public void userShouldSeeSelectStoreAndCloseOptionStoreSelectionScreen() {
        Assert.assertTrue("Select Store is not visible", loginMultiStorePage.getSelectStore().isDisplayed());
        Assert.assertTrue("Close option is not visible", loginMultiStorePage.getClosePopUpButton().isDisplayed());


    }

    @When("user enters {string} text in search your stores")
    public void userEntersWordInSearchYourStores(String text) {
        loginMultiStorePage.enterTextInSearchStore(text);
    }

    @Then("user should see {string} results corresponding to search made")
    public void userShouldSeeSearchResultsCorrespondingToSearchMade(String text) {
        Assert.assertTrue("Search results doesnot contain search criteria", loginMultiStorePage.verifySearchResult(text));
    }

    @When("user enters {string} incorrect search criteria in search your stores")
    public void userEntersIncorrectSearchCriteriaInSearchYourStores(String text) {
        loginMultiStorePage.enterTextInSearchStore(text);
    }

    @Then("user should see Sorry message on store selection screen")
    public void userShouldSeeSorryMessageOnStoreSelectionScreen() {
        Assert.assertTrue("Sorry message is not displayed", loginMultiStorePage.getNoResultText().isDisplayed());
        Assert.assertTrue("Sorry sub text message is not displayed", loginMultiStorePage.getNoResultSubText().isDisplayed());


    }

    @When("user click on close button")
    public void userClickOnCloseButton() {
        loginMultiStorePage.clickOnPopUpCloseButton();
    }

    @Then("store selection screen popup should be closed")
    public void storeSelectionScreenPopupShouldBeClosed() {
        Assert.assertTrue("Store selection screen is not closed", loginMultiStorePage.getViewAllButton().isDisplayed());
    }


}
