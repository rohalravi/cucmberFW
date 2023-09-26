package com.pepsico.retail.models.web;

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
public class RewardsTile implements BasePage {

    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//p[@name='rewards_container_title']")
    private WebElement rewardsTitle;

    @FindBy(how = How.XPATH, using = "//a[@id='rewards_container_title_link']")
    private WebElement seeALLOption;


    @FindBy(how = How.XPATH, using = "//p[@name='rewards_container_description']")
    private WebElement rewardsSubTitle;


    @FindBy(how = How.XPATH, using = "//img[contains(@id,'itemCard_image')]")
    private List<WebElement> rewardsImage;

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'reward_container_card_content_title')]")
    private List<WebElement> rewardsCardTitle;


    @FindBy(how = How.XPATH, using = "//div[contains(@id,'reward_container_card_content_title')]")
    private List<WebElement> rewardsCardPoints;

    @FindBy(how = How.XPATH, using = "//button[contains(@name,'itemCard_primaryBtn')]")
    private List<WebElement> redeemNowButton;

    public void navigateToRewardsSection() {
        libraryHelper.executeJS("window.scrollBy(0,900)", "");

    }
    public WebElement getRewardsTitle() {
        return rewardsTitle;
    }

    public WebElement getRewardsSubTitle() {
        return rewardsSubTitle;
    }
    public WebElement getSeeALLOption() {
        return seeALLOption;
    }

    public List<WebElement> getRewardsImage() {
        return rewardsImage;
    }

    public List<WebElement> getRewardsCardTitle() {
        return rewardsCardTitle;
    }

    public List<WebElement> getRewardsCardPoints() {
        return rewardsCardPoints;
    }

    public List<WebElement> getRedeemNowButton() {
        return redeemNowButton;
    }


}
