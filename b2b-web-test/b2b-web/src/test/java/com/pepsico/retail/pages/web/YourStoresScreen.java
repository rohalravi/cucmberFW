/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.UserAccount.*;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YourStoresScreen implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private YourStore yourStore;

    @FindBy(how = How.XPATH, using = "//div[@class='makeStyles-idSection-351 MuiBox-root css-0']//p")
    private List<WebElement> storeID;

    @FindBy(how = How.XPATH, using = "(//div[@class='MuiGrid-root MuiGrid-container css-1lym95h-MuiGrid-root'])//p")
    private List<WebElement> popUpHelpLineText;

    public String getYourStoreText() {
        return yourStore.getTheYourStoreText().getText();
    }

    public boolean isStoreIdDisplayed() {
        for (WebElement storeIDDetails:storeID) {
            return visibilityHelper.isElementPresent(storeIDDetails);
        }
        return visibilityHelper.isElementPresent(storeID.get(0));
    }

    public String getIncorrectInformationMessage() {
        return yourStore.getIncorrectInformationMessage().getText();
    }

    public boolean tradePointDetails_IsPresent() {
        return visibilityHelper.isElementPresent(yourStore.getBadgeIcon()) && visibilityHelper.isElementPresent(yourStore.getTradePointText())
                && visibilityHelper.isElementPresent(yourStore.getTradePointButton());
    }

    public boolean isPopUpHelpLineText_Present() {
        for (WebElement helpLineText:popUpHelpLineText) {
            if(!visibilityHelper.isElementPresent(helpLineText)){
                return false;
            }
        }
        return true;
    }
}