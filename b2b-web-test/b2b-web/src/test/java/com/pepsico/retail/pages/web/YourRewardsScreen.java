/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.UserAccount.YourRewards;
import com.pepsico.retail.models.web.UserAccount.YourStore;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YourRewardsScreen implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private YourRewards yourRewards;

    @Autowired
    private LibraryHelper libraryHelper;

    @FindBy(how = How.XPATH, using = "//div[@class='makeStyles-idSection-351 MuiBox-root css-0']//p")
    private List<WebElement> storeID;

    @FindBy(how = How.XPATH, using = "(//div[@class='MuiGrid-root MuiGrid-container css-1lym95h-MuiGrid-root'])//p")
    private List<WebElement> popUpHelpLineText;

    public boolean rewardPointDetails_IsPresent() {
        return visibilityHelper.isElementPresent(yourRewards.getRewardBadgeIcon()) && visibilityHelper.isElementPresent(yourRewards.getRewardTradePointText())
                && visibilityHelper.isElementPresent(yourRewards.getRewardTradePointButton());
    }
}