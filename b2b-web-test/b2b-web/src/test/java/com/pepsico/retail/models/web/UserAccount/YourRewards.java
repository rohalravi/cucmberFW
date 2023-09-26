package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;
import org.w3c.dom.html.HTMLInputElement;

import javax.xml.stream.XMLStreamReader;

@Component
public class YourRewards implements BasePage {

    @FindBy(how = How.XPATH, using = "//h2[text()='Your rewards']")
    private WebElement yourRewardsLink;

    @FindBy(how = How.XPATH, using = "//*[@name='undefined_title']")
    private WebElement yourRewardsTitleText;

    @FindBy(how = How.XPATH, using = "//*[@id='user_points']/div[1]")
    private WebElement rewardBadgeIcon;

    @FindBy(how = How.XPATH, using = "//*[@id='points_msg']")
    private WebElement rewardPointMessageText;

    @FindBy(how = How.XPATH, using = "//*[@name='trade_pts_cancel']")
    private WebElement rewardTradePointButton;

    @FindBy(how = How.XPATH, using = "//*[@id='yourRewards_placeholder_placeholder_image']")
    private WebElement placeHolderImage;

    @FindBy(how = How.XPATH, using = "//*[@id='yourRewards_placeholder_placeholder_title']")
    private WebElement placeHolderTitleText;

    @FindBy(how = How.XPATH, using = "//*[@id='yourRewards_placeholder_placeholder_subtitle']") //*[@id="yourRewards_placeholder_placeholder_primaryButton"]
    private WebElement placeHolderSubTitleText;

    @FindBy(how = How.XPATH, using = "//*[@id='yourRewards_placeholder_placeholder_primaryButton']")
    private WebElement rewardCatalogueButton;

    public WebElement getYourRewardsLink() {
        return yourRewardsLink;
    }

    public WebElement yourRewardsText() {
        return yourRewardsTitleText;
    }

    public WebElement getRewardBadgeIcon() {
        return rewardBadgeIcon;
    }

    public WebElement getRewardTradePointText() {
        return rewardPointMessageText;
    }

    public WebElement getRewardTradePointButton() {
        return rewardTradePointButton;
    }

    public WebElement placeHolderImage_IsVisible() {
        return placeHolderImage;
    }

    public WebElement getPlaceHolderTitleText() {
        return placeHolderTitleText;
    }

    public WebElement getPlaceHolderSubTitleText() {
        return placeHolderSubTitleText;
    }

    public WebElement getRewardCatalogueButton() {
        return  rewardCatalogueButton;
    }

}
