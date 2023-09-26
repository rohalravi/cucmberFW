package com.pepsico.retail.steps;

import com.pepsico.retail.models.web.ProductCatalogueTile;
import com.pepsico.retail.models.web.RewardsTile;
import com.pepsico.retail.models.web.VideoAnnouncementCarouselComponent;
import com.pepsico.retail.pages.web.GlobalComponentsPage;
import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.PromotionCarouselComponent;
import com.pepsico.retail.pages.web.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageSteps {

    @Autowired
    private HomePage homePage;

    @Autowired
    private RewardsTile rewardsTile;

    @Autowired
    GlobalComponentsPage globalComponentsPage;

    @Autowired
    LibraryHelper libraryHelper;

    @Autowired
    VisibilityHelper visibilityHelper;

    @Autowired PromotionCarouselComponent promotionCarouselComponent;

    @Autowired ProductCatalogueTile productCatalogueTile;

    @Autowired VideoAnnouncementCarouselComponent videoAnnouncementCarouselComponent;


    @Then("user should see welcome message")
    public void userShouldSeeWelcomeMessage() {
        Assert.assertTrue("Message is not displayed", homePage.verifyWelcomeMessage());
    }

    @And("user should see cta buttons")
    public void userShouldSeeCtaButtons() {
        Assert.assertTrue("cta buttons are not displayed", homePage.verifyCTAButtons());
    }


    @And("user navigate to promotion section")
    public void userNavigateToPromotionSection() {
        visibilityHelper.waitForSeconds();
        libraryHelper.executeJS("window.scrollBy(0,760)","");
    }

    @Then("user should see promotion title and seeAll text")
    public void userShouldSeePromotionTitleAndSeeAllText() {
        Assert.assertTrue("Promotion title and see all text is not visible",
                homePage.isPromotionTitleAndSeeAllTextPresent());
    }

    @And("user should see both arrow button")
    public void userShouldSeeBothArrowButton() {
        Assert.assertTrue("Both arrows are present", homePage.isBothArrowsPresent());
    }

    @When("user click on navigation dots button")
    public void userClickOnNavigationDotsButton() {
        visibilityHelper.waitForSeconds();
        homePage.clickOnNavigationDotButton();
    }

    @Then("different image and text should be displayed")
    public void differentImageShouldBeDisplayed() {
        String activeImg = promotionCarouselComponent.getImages().get(2).getAttribute("src");
        String activeText = promotionCarouselComponent.getActiveText().get(1).getText();
        visibilityHelper.waitForSeconds();
        String currentImg = promotionCarouselComponent.getImages().get(0).getAttribute("src");
        String currentText = promotionCarouselComponent.getCurrentText().get(0).getText();
        Assert.assertNotEquals(" Both images are not equal", activeImg, currentImg);
        Assert.assertNotEquals("Both texts is not same", activeText, currentText);
    }

    @When("user click on previous arrow")
    public void userClickOnPreviousArrow() {
        homePage.clickOnPreviousArrow();
    }

    @Then("previous image should be displayed")
    public void previousImageShouldBeDisplayed() {
        String activeImg = promotionCarouselComponent.getImages().get(0).getAttribute("src");
        String activeText = promotionCarouselComponent.getActiveText().get(0).getText();
        visibilityHelper.waitForSeconds();
        String currentImg = promotionCarouselComponent.getImages().get(1).getAttribute("src");
        String currentText = promotionCarouselComponent.getCurrentText().get(1).getText();
        Assert.assertEquals(" Both images are not equal", activeImg, currentImg);
        Assert.assertEquals("Both texts is not same", activeText, currentText);
    }

    @When("user click on right arrow till until last item")
    public void userClickOnRightArrowTillUntilLastItem() {
        for (int i = 0; i < promotionCarouselComponent.getImages().size(); i++) {
            promotionCarouselComponent.getNextArrow().click();
        }
    }

    @Then("user should see last arrow greyed out")
    public void userShouldSeeLastArrowGreyedOut() {
        Assert.assertTrue("Lasr arrow is greyed out", visibilityHelper.isElementPresent(promotionCarouselComponent.getNextArrow()));
    }

    @When("user click on left arrow until first item")
    public void userClickOnLeftArrowUntilFirstItem() {
        for (int i = 0; i < promotionCarouselComponent.getImages().size(); i++) {
            promotionCarouselComponent.getPreviousArrow().click();
        }
    }

    @Then("user should see first arrow greyed out")
    public void userShouldSeeFirstArrowGreyedOut() {
        Assert.assertTrue("First arrow is greyed out",
                visibilityHelper.isElementPresent(promotionCarouselComponent.getPreviousArrow()));

    }

    @And("user click on next arrow button")
    public void userClickOnNextArrowButton() {
        promotionCarouselComponent.clickOnNextArrow();
    }

    @Then("user should be presented on home page")
    public void userShouldBePresentedOnHomePage() {
        globalComponentsPage.isHomeTabHighlighted();
    }

    @Then("user navigates to rewards section on home page")
    public void userNavigatesToRewardsSectionOnHomePage() {
        rewardsTile.navigateToRewardsSection();
    }

    @And("user should see title subtitle and see all option in rewards section")
    public void userShouldSeeTitleSubtitleAndSeeAllOptionInRewardsSection() {
        Assert.assertTrue("Title, subtitle and see all button is not visible",
                homePage.verifyTitleSubTitleAndSeeALLButton());
    }

    @And("user should see rewards name image and points to redeem under reward section on homepage")
    public void userShouldSeeRewardsNameImageAndPointsToRedeemUnderRewardSectionOnHomepage() {
        Assert.assertTrue("Rewards Images are not displayed",
                homePage.verifyRewardImage());
        Assert.assertTrue("Rewards Card Title is not displayed",
                homePage.verifyRewardCardTitle());
        Assert.assertTrue("Rewards card points are not displayed",
                homePage.verifyRewardCardPoints());
        Assert.assertTrue("Rewards Images are not displayed",
                homePage.verifyRewardCardReedemNowButton());

    }
    @When("user click on the profile icon on home page")
    public void userClickOnTheProfileIconOnHomePage() {
        homePage.clickOnProfileIcon();
    }

    @And("user navigate to announcement section")
    public void userNavigateToAnnouncementSection() {
        visibilityHelper.waitForSeconds();
        libraryHelper.executeJS("window.scrollBy(0,380)","");
    }

    @Then("user should see announcement title")
    public void userShouldSeeAnnouncementTitle() {
        Assert.assertTrue("Promotion title is not visible",
                homePage.isAnnouncementTitlePresent());
    }

    @And("user should see both arrow button for announcement section")
    public void userShouldSeeBothArrowButtonForAnnouncementSection() {
        Assert.assertTrue("Both arrows are present", homePage.isBothArrowsForAnnouncementPresent());
    }

    @When("user click on announcement navigation dots button")
    public void userClickOnAnnouncementNavigationDotsButton() {
        visibilityHelper.waitForSeconds();
        homePage.clickOnAnnouncementNavigationDotButton();
    }

    @Then("different image and text should be displayed in announcement section")
    public void differentImageAndTextShouldBeDisplayedInAnnouncementSection() {
        Assert.assertTrue("Video announcement image and texts not visible",homePage.getAnnouncementImages());
    }

    @And("user click on announcement next arrow button")
    public void userClickOnAnnouncementNextArrowButton() {
        videoAnnouncementCarouselComponent.clickOnNextArrow();
    }

    @When("user click on announcement previous arrow")
    public void userClickOnAnnouncementPreviousArrow() {
        videoAnnouncementCarouselComponent.clickOnPreviousArrow();
    }

    @Then("previous image of announcement should be displayed")
    public void previousImageOfAnnouncementShouldBeDisplayed() {
        String activeImg = videoAnnouncementCarouselComponent.getImages().get(0).getAttribute("src");
        String activeText = videoAnnouncementCarouselComponent.getActiveText().get(0).getText();
        visibilityHelper.waitForSeconds();
        String currentImg = videoAnnouncementCarouselComponent.getImages().get(1).getAttribute("src");
        String currentText = videoAnnouncementCarouselComponent.getCurrentText().get(1).getText();
        Assert.assertEquals(" Both images are not equal", activeImg, currentImg);
        Assert.assertEquals("Both texts is not same", activeText, currentText);
    }

    @When("user click on announcement right arrow till until last item")
    public void userClickOnAnnouncementRightArrowTillUntilLastItem() {
        for (int i = 0; i < videoAnnouncementCarouselComponent.getImages().size(); i++) {
            videoAnnouncementCarouselComponent.getNextArrow().click();
        }
    }

    @Then("user should see announcement last arrow greyed out")
    public void userShouldSeeAnnouncementLastArrowGreyedOut() {
        Assert.assertTrue("Lasr arrow is greyed out", visibilityHelper.isElementPresent(videoAnnouncementCarouselComponent.getNextArrow()));

    }

    @When("user click on announcement left arrow until first item")
    public void userClickOnAnnouncementLeftArrowUntilFirstItem() {
        for (int i = 0; i < videoAnnouncementCarouselComponent.getImages().size(); i++) {
            videoAnnouncementCarouselComponent.getPreviousArrow().click();
        }
    }

    @Then("user should see announcement first arrow greyed out")
    public void userShouldSeeAnnouncementFirstArrowGreyedOut() {
        Assert.assertTrue("First arrow is greyed out",
                visibilityHelper.isElementPresent(videoAnnouncementCarouselComponent.getPreviousArrow()));
    }

    @Then("user navigates to product catalogue section on home page")
    public void userNavigatesToProductCatalogueSectionOnHomePage() {
        productCatalogueTile.navigateToProductCatalogueSection();
    }

    @And("user should see title subtitle and see all option in product catalogue section")
    public void userShouldSeeTitleSubtitleAndSeeAllOptionInProductCatalogueSection() {
        Assert.assertTrue("Title, subtitle and see all button is not visible",
                homePage.verifyProductCatalogueTitleSubTitleAndSeeALLButton());
    }

    @And("user should see product name image and points to redeem under product catalogue section on homepage")
    public void userShouldSeeProductNameImageAndPointsToRedeemUnderProductCatalogueSectionOnHomepage() {
        Assert.assertTrue("Product Images are not displayed",
                homePage.verifyProductImage());
        Assert.assertTrue("Product Card Title is not displayed",
                homePage.verifyProductCardTitle());
        Assert.assertTrue("Product card price are not displayed",
                homePage.verifyProductCardPrice());
        Assert.assertTrue("Add to basket button are not displayed",
                homePage.verifyProductCardAddToBasketButton());
    }
}