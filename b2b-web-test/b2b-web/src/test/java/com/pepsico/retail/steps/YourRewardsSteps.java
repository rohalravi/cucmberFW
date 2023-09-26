/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.models.web.UserAccount.YourRewards;
import com.pepsico.retail.models.web.UserAccount.YourStore;
import com.pepsico.retail.pages.web.YourRewardsScreen;
import com.pepsico.retail.pages.web.YourRewardsUnhappyPath;
import com.pepsico.retail.pages.web.YourStoresScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class YourRewardsSteps {

    @Autowired
    private YourStoresScreen yourStoresScreen;

    @Autowired
    private YourRewards yourRewards;

    @Autowired
    private YourRewardsScreen yourRewardsScreen;

    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private YourRewardsUnhappyPath yourRewardsUnhappyPath;

    @And("user click on your rewards option")
    public void userClickOnYourRewardsOption() throws InterruptedException {
         libraryHelper.scrollIntoView(yourRewards.getYourRewardsLink());
        yourRewards.getYourRewardsLink().click();
    }

    @Then("user see {string} text as title of reward page")
    public void userSeeTextAsTitleOfRewardPage(String YourRewards) {
        Assert.assertEquals(YourRewards,yourRewards.yourRewardsText().getText());
    }

    @And("user see reward points details, badge and trade point button")
    public void userSeeRewardPointsDetailsBadgeAndTradePointButton() {
        yourRewardsScreen.rewardPointDetails_IsPresent();
    }

    @And("user can see unhappy path image")
    public void userCanSeeUnhappyPathImage() {
        Assert.assertTrue("unhappy path image is not present", yourRewards.placeHolderImage_IsVisible().isDisplayed());
    }

    @And("user can see text message for unhappy path")
    public void userCanSeeTextMessageForUnhappyPath() {
            Assert.assertTrue("place holder message title text is not visible",yourRewards.getPlaceHolderTitleText().isDisplayed());
            Assert.assertTrue("place holder message subtext is not visible", yourRewards.getPlaceHolderSubTitleText().isDisplayed());
    }

    @And("user can see reward catalogue button")
    public void userCanSeeRewardCatalogueButton() {
        Assert.assertTrue("Reward catalogue button is not visible",yourRewards.getRewardCatalogueButton().isDisplayed());
    }

    @Then("user can see reward cards title text and card images")
    public void userCanSeeRewardCardsTitleTextAndCardImages() {
        Assert.assertTrue("reward card title text is not present", yourRewardsUnhappyPath.isRewardCardTitlePresent());


    }

    @And("user can see order on and quantity texts")
    public void userCanSeeOrderOnAndQuantityTexts() {
        Assert.assertTrue("Order on text is not present", yourRewardsUnhappyPath.isOrderOnDateText_IsVisible());
    }

    @And("user validate date of the reward card and expand arrow")
    public void userValidateDateOfTheRewardCardAndExpandArrow() {
        Assert.assertTrue("Quantity of reward card text is not present",yourRewardsUnhappyPath.isQuantityTextPresent());
        Assert.assertTrue("Expand arrow is not present",yourRewardsUnhappyPath.isCardExpandArrowPresent());
    }
}
