package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.ProductCatalogueTile;
import com.pepsico.retail.models.web.PromotionCarouselComponent;
import com.pepsico.retail.models.web.RewardsTile;
import com.pepsico.retail.models.web.VideoAnnouncementCarouselComponent;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomePage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private RewardsTile rewardsTile;

    @Autowired
    private PromotionCarouselComponent promotionCarouselComponent;

    @Autowired
    private VideoAnnouncementCarouselComponent videoAnnouncementCarouselComponent;

    @Autowired
    private ProductCatalogueTile productCatalogueTile;

    @FindBy(how = How.XPATH, using = "//h5[contains(text(),'Hi')]")
    private WebElement welcomeMessage;

    @FindBy(how = How.XPATH, using = "//*[local-name()='svg' and @name='points_icon']")
    private WebElement userBadge;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'howManyPoints') ]")
    private WebElement accumulatedPoints;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'makeStyles-tradePointsBtn')]")
    private WebElement tradePointsButton;

    @FindBy(how = How.XPATH, using = "//a[@name='order_link']")
    private WebElement orderProductsCTA;

    @FindBy(how = How.XPATH, using = "//a[@name='rewards_link']")
    private WebElement viewRewardsCTA;

    @FindBy(how = How.XPATH, using = "//*[@id='AvatarIconContainer']/a")
    private WebElement profileIcon;

    @FindBy(xpath = "//img[@class='makeStyles-image-182']")
    private List<WebElement> images;

    @FindBy(how = How.XPATH, using = "//span[@id='profileTitle_title']")
    private WebElement profileTitle;

    public void clickOnProfileIcon() {
        visibilityHelper.waitForVisibilityOf(profileIcon);
        profileIcon.click();
        visibilityHelper.waitForVisibilityOf(profileTitle);
    }

    public boolean verifyWelcomeMessage() {
        visibilityHelper.waitForElementToVisible(welcomeMessage);
        return visibilityHelper.isElementPresent(welcomeMessage) && visibilityHelper.isElementPresent(userBadge)
                && visibilityHelper.isElementPresent(accumulatedPoints);
    }

    public boolean verifyCTAButtons() {
        return visibilityHelper.isElementPresent(tradePointsButton) && visibilityHelper.isElementPresent(orderProductsCTA) &&
                visibilityHelper.isElementPresent(viewRewardsCTA);
    }

    public boolean isPromotionTitleAndSeeAllTextPresent() {
        return visibilityHelper.isElementPresent(promotionCarouselComponent.getPromotionTitle()) &&
                visibilityHelper.isElementPresent(promotionCarouselComponent.getSeeAllText());
    }

    public boolean isBothArrowsPresent() {
        return visibilityHelper.isElementPresent(promotionCarouselComponent.getPreviousArrow()) &&
                visibilityHelper.isElementPresent(promotionCarouselComponent.getNextArrow());
    }

    public void clickOnPreviousArrow() {
        promotionCarouselComponent.getPreviousArrow().click();
    }

    public void clickOnNavigationDotButton() {
        promotionCarouselComponent.getNavDots().get(1).click();
    }


    public boolean verifyTitleSubTitleAndSeeALLButton() {
        visibilityHelper.waitForVisibilityOf(rewardsTile.getSeeALLOption());
        return visibilityHelper.isElementPresent(rewardsTile.getRewardsTitle())
                && visibilityHelper.isElementPresent(rewardsTile.getRewardsSubTitle()) &&
                visibilityHelper.isElementPresent(rewardsTile.getSeeALLOption());
    }

    public boolean verifyRewardImage() {
        boolean result = Boolean.TRUE;
        for (WebElement rewardImageList : rewardsTile.getRewardsImage()) {
            if (!visibilityHelper.isElementPresent(rewardImageList)) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public boolean verifyRewardCardTitle() {
        Boolean result = Boolean.TRUE;
        for (WebElement rewardCardTitle : rewardsTile.getRewardsCardTitle()) {
            if (!visibilityHelper.isElementPresent((rewardCardTitle))) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public boolean verifyRewardCardPoints() {
        Boolean result = Boolean.TRUE;
        for (WebElement rewardCardPoints : rewardsTile.getRewardsCardPoints()) {
            if (!visibilityHelper.isElementPresent((rewardCardPoints))) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public boolean verifyRewardCardReedemNowButton() {
        Boolean result = Boolean.TRUE;
        for (WebElement reedemNowButton : rewardsTile.getRedeemNowButton()) {
            if (!visibilityHelper.isElementPresent((reedemNowButton))) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }


    public boolean isAnnouncementTitlePresent() {
        return visibilityHelper.isElementPresent(videoAnnouncementCarouselComponent.getVideoAnnouncementTitle());
    }

    public boolean isBothArrowsForAnnouncementPresent() {
        return visibilityHelper.isElementPresent(videoAnnouncementCarouselComponent.getPreviousArrow()) &&
                visibilityHelper.isElementPresent(videoAnnouncementCarouselComponent.getNextArrow());
    }

    public void clickOnAnnouncementNavigationDotButton() {
        videoAnnouncementCarouselComponent.getNavDots().get(1).click();
    }

    public boolean getAnnouncementImages() {
        for (WebElement announcementImage:images) {
            if(!visibilityHelper.isElementPresent(announcementImage)){
                return true;
            }
        }
        return false;

    }

    public boolean verifyProductCatalogueTitleSubTitleAndSeeALLButton() {
        visibilityHelper.waitForVisibilityOf(productCatalogueTile.getSeeALLOption());
        return visibilityHelper.isElementPresent(productCatalogueTile.getProductTitle())
                && visibilityHelper.isElementPresent(productCatalogueTile.getSeeALLOption());
    }

    public boolean verifyProductImage() {
        boolean result = Boolean.TRUE;
        for (WebElement productImageList : productCatalogueTile.getProductImage()) {
            if (!visibilityHelper.isElementPresent(productImageList)) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public boolean verifyProductCardTitle() {
        Boolean result = Boolean.TRUE;
        for (WebElement productCardTitle : productCatalogueTile.getProductCardTitle()) {
            if (!visibilityHelper.isElementPresent((productCardTitle))) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public boolean verifyProductCardPrice() {
        Boolean result = Boolean.TRUE;
        for (WebElement productCardPrice : productCatalogueTile.getProductCardPrice()) {
            if (!visibilityHelper.isElementPresent((productCardPrice))) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public boolean verifyProductCardAddToBasketButton() {
        Boolean result = Boolean.TRUE;
        for (WebElement addToBasketButton : productCatalogueTile.getAddToBasketButton()) {
            if (!visibilityHelper.isElementPresent((addToBasketButton))) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }
}
