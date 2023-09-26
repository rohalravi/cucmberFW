/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.UserAccount.YourRewards;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YourRewardsUnhappyPath implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private YourRewards yourRewards;

    @Autowired
    private LibraryHelper libraryHelper;

    @FindBy(how = How.XPATH, using = "//*[@id='rewards_history_item_subtitle']/span[1]")
    private List<WebElement> orderDateText;

    @FindBy(how = How.XPATH, using = "//*[@id='rewards_history_item_subtitle']/span[2]")
    private List<WebElement> cardQuantityText;

    @FindBy(how = How.XPATH, using = "//*[@name='rewardsHistory_listItem_expandButton']")
    private List<WebElement> cardExpandArrow;

    @FindBy(how = How.XPATH, using = "//*[@id='rewardsHistory_listItem_title_title']")
    private List<WebElement> rewardCardTitleText;

    public boolean isOrderOnDateText_IsVisible() {
        for (WebElement orderOnText:orderDateText) {
            if(!visibilityHelper.isElementPresent(orderOnText)){
                return false;
            }
        }
        return true;
    }

    public boolean isRewardCardTitlePresent() {
        for (WebElement cardTitleText:rewardCardTitleText) {
            if (!visibilityHelper.isElementPresent(cardTitleText)){
                return false;
            }
        }
        return true;
    }

    public boolean isQuantityTextPresent() {
        for (WebElement quantityText:cardQuantityText) {
            if (!visibilityHelper.isElementPresent(quantityText)){
                return false;
            }
        }
        return true;
    }

    public boolean isCardExpandArrowPresent() {
        for (WebElement expandArrow:cardExpandArrow) {
            if (!visibilityHelper.isElementPresent(expandArrow)){
                return false;
            }
        }
        return true;
    }
}