/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalComponentsPage implements BasePage {
    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'globalFooterText')]")
    private WebElement copyRightMassage;

    @FindBy(how = How.XPATH, using = "(//*[@id='footer-container']//span)[2]")
    private WebElement needHelpButton;

    @FindBy(how = How.XPATH, using = "//*[@id='help_card_icon']")
    private WebElement phoneIcon;

    @FindBy(how = How.XPATH, using = "//span[@class='makeStyles-modalHelpLine-55']")
    private WebElement helpCardTitleText;

    @FindBy(how = How.XPATH, using = "(//*[@id='phone_image']/../..//span)[2]")
    private WebElement helpCardSubText;

    @FindBy(how = How.XPATH, using = "//*[@id='phone_image']")
    private WebElement helpCardPhoneIcon;

    @FindBy(how = How.XPATH, using = "(//*[@id='phone_image']/../..//span)[1]")
    private WebElement helpCardPhoneNumber;

    @FindBy(how = How.XPATH, using = "//*[@id='dismiss_message']")
    private WebElement hideMassageButton;

    @FindBy(how = How.XPATH, using = "//ul[starts-with(@class,'makeStyles-list-')]")
    private List<WebElement> headerAllOptions;
    @FindBy(how = How.XPATH, using = "//li[starts-with(@class,'makeStyles-active')]")
    private WebElement highlightedTab;
    @FindBy(how = How.XPATH, using = "//li[starts-with(@class,'makeStyles-active')]")
    private WebElement highlightedHomeTab;
    @FindBy(how = How.XPATH, using = "//input[@id='search-input']")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//div[@id='AvatarIconContainer']")
    private WebElement settingsIcon;

    @FindBy(how = How.XPATH, using = "//div[@id='notificationIconContainer']")
    private WebElement notificationIcon;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'makeStyles-backToTop')]//button")
    private WebElement backToTopButton;

    public WebElement getMenuItem(){
        return headerAllOptions.get(1);
    }

    public WebElement getBackToTopButton(){
        return backToTopButton;
    }

    public void clickBackToTopButton(){
        backToTopButton.click();
        visibilityHelper.waitForSeconds();
    }



    public boolean footerCopyRightMassage_IsDisplayed() throws InterruptedException {
        visibilityHelper.waitForSeconds();
        libraryHelper.scrollIntoView(copyRightMassage);
        return copyRightMassage.isDisplayed();
    }

    public boolean needHelpButton_IsDisplayed() {
        return needHelpButton.isDisplayed() && phoneIcon.isDisplayed();
    }

    public void clickOnNeedHelpButton() {
        needHelpButton.click();
    }

    public boolean helpCard_IsPresent() {
        visibilityHelper.waitForVisibilityOf(helpCardPhoneIcon);
        boolean helpCardElements = helpCardPhoneIcon.isDisplayed() && hideMassageButton.isDisplayed();
        return helpCardElements;
    }

    public void clickOnHideMassageButton() {
        hideMassageButton.click();
    }

    public void clickOnPhoneIcon() {
        phoneIcon.click();
    }

    public String helplineTitleAndPhoneNumber() {
        return helpCardPhoneNumber.getText();
    }

    public String helplineSubTitle() {
        return helpCardSubText.getText();
    }

    public boolean verifyMenuItemsName(String items) {
        visibilityHelper.waitForElementToVisible(highlightedHomeTab);
        for (int i = 0; i < headerAllOptions.size(); i++) {
            if (!headerAllOptions.get(i).getText().equals(items) &&
                    !headerAllOptions.get(i).isDisplayed()) {
                return false;
            }
        }
        return true;
    }


    public void clickOnActivitiesTab() {
        headerAllOptions.get(2).click();
    }

    public void clickOnRewardsTab() {
        headerAllOptions.get(1).click();
    }

    public void clickOnOrderTab() {
        headerAllOptions.get(3).click();
    }

    public void clickOnMenuItems(String menuItem) {
        if (menuItem.equals("Rewards")) {
            headerAllOptions.get(1).click();
        } else if (menuItem.equals("Activities")) {
            headerAllOptions.get(2).click();
        } else if (menuItem.equals("Order")) {
            headerAllOptions.get(3).click();
        }
    }

    public void userClickOnHeaderMainNavigationMenuItems(String menuItems) {
        clickOnMenuItems(menuItems);
    }

    public boolean isTabHighlighted() {
        return visibilityHelper.isElementPresent(highlightedTab);
    }

    public boolean isHomeTabHighlighted() {
        visibilityHelper.waitForSeconds();
        return highlightedHomeTab.isDisplayed();
    }

    public boolean isAllTabsHighlight(String item) {
        if (item.equals("Rewards")) {
            return isTabHighlighted();
        } else if (item.equals("Activities")) {
            return isTabHighlighted();
        } else if (item.equals("Order")) {
            return isTabHighlighted();
        }
        return false;
    }

    public boolean verifyAllTabsTabHighlighted(String menuItems) {
        return isAllTabsHighlight(menuItems);
    }

    public boolean isItemsVisible(){
      return visibilityHelper.isElementPresent(searchInput) && visibilityHelper.isElementPresent(notificationIcon)
              && visibilityHelper.isElementPresent(settingsIcon);
    }
}