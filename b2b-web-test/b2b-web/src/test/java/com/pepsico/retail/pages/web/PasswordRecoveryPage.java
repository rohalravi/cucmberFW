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
public class PasswordRecoveryPage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//span[@name='undefined_title']")
    private WebElement popUpSubText;

    @FindBy(how = How.XPATH, using = "(//*[name()='rect'])[1]")
    private WebElement redCrossIcon;

    @FindBy(how = How.XPATH, using = "//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root']")
    private WebElement tryAgainButton;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement phoneNumberText;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement enterPhoneNumberText;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement backButton;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement backButtonText;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement backArrowOnVerify;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement forgetPasswordTitle;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement forgetPasswordSubTitleText;

    @FindBy(how = How.XPATH, using = "//button[@class='makeStyles-btn-59 makeStyles-btn-60']")
    private WebElement goBackButton;
    
    @FindBy(how = How.XPATH, using = "//*[@class='MuiGrid-root MuiGrid-container css-11lq3yg-MuiGrid-root']//button")
    private List<WebElement> buttons;

    @FindBy(how = How.XPATH, using = "//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root']")
    private List<WebElement> helpLineText;

    @FindBy(how = How.XPATH, using = "//h5[@name='undefined_title']")
    private WebElement errorPopUpTitleText;

    @FindBy(how = How.XPATH, using = "(//img[@alt='Modal Phone Image'])[1]")
    private WebElement phoneIcon;

    public void forgetPasswordTitleText_IsPresent() {
        forgetPasswordTitle.isDisplayed();
    }

    public void clickOnGoBackButton() {
        goBackButton.click();
    }

    public void ForgetPasswordTitleText_IsPresent() {
        forgetPasswordTitle.isDisplayed();
    }

    public void forgetPasswordSubText_IsPresent() {
        forgetPasswordSubTitleText.isDisplayed();
    }

    public void phoneNumberTitleText_IsPresent() {
        phoneNumberText.isDisplayed();
    }

    public boolean EnterPhoneNumberText() {
        return enterPhoneNumberText.isDisplayed();
    }

    public boolean BackButtonElements_IsPresent() {
        return backButton.isDisplayed() && backButtonText.isDisplayed() && backArrowOnVerify.isDisplayed();
    }

    public boolean disabledVerifyButton_IsPresent() {
        return buttons.get(1).isDisplayed();
    }

    public void enterWrongPhoneNumber() {
        enterPhoneNumberText.sendKeys("1234567890");
    }

    public void clickOnVerifyButton() {
        buttons.get(1).click();
    }

    public boolean errorPopUpIsDisplayed() {
        return visibilityHelper.isElementPresent(errorPopUpTitleText);
    }

    public boolean errorPopUpElements_ArePresent() {
        return visibilityHelper.isElementPresent(buttons.get(2)) &&
                errorPopUpTitleText.isDisplayed() && errorPopUpTitleText.isDisplayed()
                && popUpSubText.isDisplayed() && redCrossIcon.isDisplayed() &&
                helpLineText.get(0).isDisplayed() && helpLineText.get(1).isDisplayed()
                && phoneIcon.isDisplayed() && tryAgainButton.isDisplayed();
    }

    public void clickTryAgainButton() {
        tryAgainButton.click();
    }
}