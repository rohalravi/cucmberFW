package com.pepsico.retail.steps;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.ProductCatalogueTile;
import com.pepsico.retail.models.web.PromotionCarouselComponent;
import com.pepsico.retail.models.web.RewardsTile;
import com.pepsico.retail.models.web.VideoAnnouncementCarouselComponent;
import com.pepsico.retail.pages.web.GlobalComponentsPage;
import com.pepsico.retail.pages.web.HomePage;
import com.pepsico.retail.pages.web.UserRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRegistrationSteps {

    @Autowired
    private UserRegistrationPage userRegistrationPage;


    @Then("user will navigate to the registration page")
    public void userWillNavigateToTheRegistrationPage() {
        Assert.assertTrue("registration page is not present",userRegistrationPage.userIsOnRegistrationPage());
    }

    @And("user can see registration title text and subtext")
    public void userCanSeeRegistrationTitleTextAndSubtext() {
        Assert.assertTrue("registration title text is not present",userRegistrationPage.isRegistrationTitleTextPresent());
        Assert.assertTrue("registration sub title text is not present",userRegistrationPage.isRegistrationSubTextPresent());
    }

    @And("user see Your VAT number and phone number field title texts on registration page")
    public void userSeeYourVATNumberAndPhoneNumberFieldTitleTextsOnRegistrationPage() {
        Assert.assertTrue("VAT number and Phone number title texts not present", userRegistrationPage.isFieldTitleTextPresent());
    }

    @And("user see fields for entering Your VAT number and phone number on registration page")
    public void userSeeFieldsForEnteringYourVATNumberAndPhoneNumberOnRegistrationPage() {
        Assert.assertTrue("VAT number entering field is not present",userRegistrationPage.isVATNumberInputFieldPresent());
        Assert.assertTrue("phone number entering field is not present", userRegistrationPage.isPhoneNumberFieldPresent());
    }

    @And("user see Go back button")
    public void userSeeGoBackButton() {
        Assert.assertTrue("Go back button does not exist",userRegistrationPage.goBackButtonIsPresent());
    }

    @And("user can see inactive Next step button")
    public void userCanSeeInactiveNextStepButton() {
        Assert.assertTrue("Next step inactive button is not present",userRegistrationPage.isNextStepButton_Inactive());
    }

    @When("user click on go button on registration page")
    public void userClickOnGoButtonOnRegistrationPage() {
        userRegistrationPage.clickOnGoBackButton();
    }
}