/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.steps;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.web.GlobalComponentsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class GlobalComponentsSteps {

    @Autowired
    private GlobalComponentsPage globalComponentsPage;

    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Then("user scroll down to footer")
    public void userScrollDownToFooter() throws InterruptedException {
        globalComponentsPage.footerCopyRightMassage_IsDisplayed();
    }

    @And("user should see need help button and phone icon in footer")
    public void userShouldSeeNeedHelpButtonInFooter() {
        Assert.assertTrue("Need help? button not available", globalComponentsPage.needHelpButton_IsDisplayed());
    }

    @When("user click on need help button")
    public void userClickOnNeedHelpButton() {
        globalComponentsPage.clickOnNeedHelpButton();
    }

    @And("helpLine pop up is visible at bottom of screen")
    public void helplinePopUpIsVisibleAtBottomOfScreen() {
        Assert.assertTrue("help card is not visible on landing page", globalComponentsPage.helpCard_IsPresent());
        Assert.assertEquals("helpline title with number is not displayed", "Help Line 935478941", globalComponentsPage.helplineTitleAndPhoneNumber());
        Assert.assertEquals("helpline sub title is not displayed", "Our call center is here to support you Mon-Fri from 9am-5pm", globalComponentsPage.helplineSubTitle());
    }

    @When("user click on hide massage button on pop up")
    public void userClickOnHideMassageButtonOnPopUp() {
        globalComponentsPage.clickOnHideMassageButton();
    }

    @When("user click on phone icon in footer")
    public void userClickOnPhoneIconInFooter() {
        globalComponentsPage.clickOnPhoneIcon();
    }

    @Then("navigation menu items {string} should be available on the header section of the page.")
    public void navigationMenuItemsShouldBeAvailableOnTheHeaderSectionOfThePage(String names) {
        String[] menuItemNames = names.split(",");
        Assert.assertTrue("Menu item name is not displayed", globalComponentsPage.verifyMenuItemsName(Arrays.toString(menuItemNames)));
    }

    @Then("user should see home tab highlighted")
    public void userShouldSeeTabHighlighted() {
        Assert.assertTrue("Home tab is not highlighted", globalComponentsPage.isHomeTabHighlighted());
    }

    @When("user click on {string} in the header main navigation")
    public void userClickOnTheInTheHeaderMainNavigationString(String menuItems) {
        globalComponentsPage.userClickOnHeaderMainNavigationMenuItems(menuItems);
    }

    @Then("{string} in the header main navigation should be highlighted")
    public void menuItemInTheHeaderMainNavigationMenuShouldBeHighlighted(String menuItems) {
        Assert.assertTrue("All tabs are not highlighted", globalComponentsPage.verifyAllTabsTabHighlighted(menuItems));
    }

    @And("menu header should contain search products option,your profile,basket icon and notification icon")
    public void menuHeaderShouldContainSearchProductsOptionYourProfileBasketIconAndNotificationIcon() {
        Assert.assertTrue("Header menu items are not visible",globalComponentsPage.isItemsVisible());
    }

    @Then("user should see back to top button")
    public void userShouldSeeBackToTopButton() {
        Assert.assertTrue("Back to top button is not visible",globalComponentsPage.getBackToTopButton().isDisplayed());

    }

    @When("user clicks on back to top button")
    public void userClicksOnBackToTopButton() {
        globalComponentsPage.clickBackToTopButton();
    }

    @Then("back to top button should be visible while scrolling up")
    public void backToTopButtonShouldBeVisibleWhileScrollingUp() {
        Assert.assertTrue("back to top button is not visible while scrolling up",globalComponentsPage.getBackToTopButton().isDisplayed());
    }

    @And("user should scroll back up")
    public void userShouldScrollBackUp() {
        visibilityHelper.waitForElementToVisible(globalComponentsPage.getMenuItem());
        Assert.assertTrue("User is not scrolled back up",
                globalComponentsPage.getMenuItem().isDisplayed());

    }

    @When("user scroll down to back to top button")
    public void userScrollDownToBackToTopButton() throws InterruptedException {
        libraryHelper.executeJS("window.scrollBy(0,900)","");
        visibilityHelper.waitForSeconds();
    }
}


