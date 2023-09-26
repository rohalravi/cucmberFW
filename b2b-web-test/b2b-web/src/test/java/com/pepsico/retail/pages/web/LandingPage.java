/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.DynamicMBean;
import java.util.List;

@Component
public class LandingPage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private LibraryHelper libraryHelper;

    @FindBy(how = How.XPATH, using = "//*[@id='btnSignIn']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//span[@id='welcome-page-heading-text']")
    private WebElement welcomeContainerTexts;

    @FindBy(how = How.XPATH, using = "//span[@id='welcome-page-sub-title-text']")
    private WebElement welcomeContainerSubTitleText;

    @FindBy(how = How.XPATH, using = "//div[@id='welcome-page-img']")
    private WebElement welcomeContainerImage;

    @FindBy(how = How.XPATH, using = "//*[@id='btn_register']")
    private List<WebElement> registerNowButton;

    @FindBy(how = How.XPATH, using = "(//*[@id='password']/following::*//span/..)[1]")
    private WebElement forgetPasswordHelpText;

    @FindBy(how = How.XPATH, using = "//*[@id='password']/following::*//span/..//div")
    private WebElement forgetPasswordHelpIcon;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-container makeStyles-container-92 css-11lq3yg-MuiGrid-root']//div//p")
    private List<WebElement> descriptiveText;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-container makeStyles-container-92 css-11lq3yg-MuiGrid-root']//div//img")
    private List<WebElement> descriptiveImage;

    @FindBy(how = How.XPATH, using = "//*[@id='brand-card-0']/../..//h6")
    private WebElement discoverBrandTitle;

    @FindBy(how = How.XPATH, using = "//*[@id='brand-card-0']")
    private List<WebElement> brandTiles;

    @FindBy(how = How.XPATH, using = "//*[@id='brand-card-0']//div")
    private List<WebElement> brandImages;

    @FindBy(how = How.XPATH, using = "//*[@id='have_account']")
    private WebElement pleaseLoginText;

    @FindBy(how = How.XPATH, using = "(//*[@id='btnSignIn']/../..//span)[3]")
    private WebElement rememberMeText;

    @FindBy(how = How.XPATH, using = "//*[@id='btnSignIn']/../..//input")
    private WebElement radioButton;

    @FindBy(how = How.XPATH, using = "(//*[@id='btn_register']/../..//span)[1]")
    private WebElement newToWebSiteText;

    @FindBy(how = How.XPATH, using = "//div[@class='makeStyles-container-84 MuiBox-root css-0']//label")
    private List<WebElement> loginFieldTexts;

    @FindBy(how = How.XPATH, using = "//div[@class='makeStyles-container-84 MuiBox-root css-0']//input")
    private List<WebElement> enterLoginCredentials;

    @FindBy(how = How.XPATH, using = "//*[@id='btnSignIn']")
    private WebElement loginButtonActive;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-17 css-1idn90j-MuiGrid-root']//h5")
    private WebElement weCanNotRecogniseYouText;

    @FindBy(how = How.XPATH, using = "//*[@id='wrongLoginDialog_modal_dialog_close_btn']")
    private WebElement popUpCrossIcon;

    @FindBy(how = How.XPATH, using = "//*[@id='wrongLoginDialog_modal_dialog_close_btn']")
    private WebElement crossMarkedIcon;

    @FindBy(how = How.XPATH, using = "//*[@id='wrongLoginDialog_modal_dialog_main_close_btn']")
    private WebElement pleaseTryAgainText;

    @FindBy(how = How.XPATH, using = "//*[@id='wrongLoginDialog_modal_dialog_main_close_btn']")
    private WebElement tryAgainButton;

    @FindBy(how = How.XPATH, using = "//div[@id='undefined-button-container-logout']//button")
    private WebElement crossButton;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement maskedPassword;

    @FindBy(how = How.XPATH, using = "//input[@id='password']/..//div")
    private WebElement passwordEyeIcon;

    @FindBy(how = How.XPATH, using = "//*[@id='btn_register']")
    private WebElement registerButton;

    public boolean loginButton_IsDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean registerNowButton_IsPresent() {
        for (WebElement registerNowElement : registerNowButton) {
            if (!registerNowElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean descriptiveText_IsDisplayed() throws InterruptedException {
        for (WebElement descriptiveTextElement : descriptiveText) {
            libraryHelper.scrollIntoView(descriptiveTextElement);
            if (!descriptiveTextElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean descriptiveImage_IsDisplayed() throws InterruptedException {
        for (WebElement descriptiveImagesElement : descriptiveImage) {
            libraryHelper.scrollIntoView(descriptiveImagesElement);
            if (!descriptiveImagesElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean discoverBrandTitle_IsDisplayed() throws InterruptedException {
        visibilityHelper.waitForSeconds();
        return discoverBrandTitle.isDisplayed();
    }

    public boolean discoverBrandTiles_IsPresent(){
        for (WebElement tilesOfBrand : brandTiles) {
            if (!tilesOfBrand.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyWelcomeContainerText() {
        visibilityHelper.waitForVisibilityOf(welcomeContainerTexts);
        return welcomeContainerTexts.isDisplayed();
    }

    public boolean loginTitleText_IsPresent() {
        visibilityHelper.waitForVisibilityOf(pleaseLoginText);
        return pleaseLoginText.isDisplayed();
    }

    public boolean rememberMeText_IsPresent() throws InterruptedException {
        libraryHelper.scrollIntoView(rememberMeText);
        return rememberMeText.isDisplayed();
    }

    public void radioButtonIsDisplayed() {
        radioButton.isDisplayed();
    }

    public boolean phoneNumberAndPasswordText_IsPresent() {
        for (WebElement phoneNumberAndPasswordText : loginFieldTexts) {
            if (!phoneNumberAndPasswordText.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean phoneNumberAndPasswordEntryFields_IsPresent() {
        for (WebElement enterPhoneNumberAndPassword : enterLoginCredentials) {
            if (!enterPhoneNumberAndPassword.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean newToPepsiConnectText_IsPresent() throws InterruptedException {
        libraryHelper.scrollIntoView(newToWebSiteText);
        return newToWebSiteText.isDisplayed();
    }

    public boolean verifyWelcomeContainerText_IsPresent(){
        boolean welcomeContainerElements = welcomeContainerTexts.isDisplayed() && welcomeContainerSubTitleText.isDisplayed();
        return welcomeContainerElements;
    }

    public boolean verifyWelcomeContainerImage() {
        return welcomeContainerImage.isDisplayed();
    }

    public boolean forgetPasswordHelp_IsPresent() {
        boolean forgetPasswordElements = forgetPasswordHelpText.isDisplayed() && forgetPasswordHelpIcon.isDisplayed();
        return forgetPasswordElements;
    }

    public boolean discoverBrandImages_IsPresent() throws InterruptedException {
        for (WebElement tileBrandImage : brandImages) {
            libraryHelper.scrollIntoView(tileBrandImage);
            if (!tileBrandImage.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean loginButtonActive_IsPresent() {
        if (!loginButtonActive.isEnabled()) {
            return false;
        }
        return true;
    }

    public boolean loginButtonActive_Click() {
        if (loginButtonActive.isEnabled()) {
            loginButtonActive.click();    
        }
        return false;
    }

    public void clickOnDidYouForgetPasswordLink() {
        forgetPasswordHelpText.click();
    }

    public void errorPopUp_IsPresent() {
        weCanNotRecogniseYouText.isDisplayed();
    }

    public boolean verifyErrorPopUpElements() {
        return crossMarkedIcon.isDisplayed() && pleaseTryAgainText.isDisplayed()
                && popUpCrossIcon.isDisplayed() && tryAgainButton.isDisplayed();
    }

    public void clickTryAgainButtonOnPopUp() {
        tryAgainButton.click();
    }

    public void clickOnCrossButtonOnPopUp() {
        crossMarkedIcon.click();
    }

    public WebElement getMaskedPassword() {
        visibilityHelper.waitForSeconds();
        return maskedPassword;
    }

    public void clickOnPasswordEyeIcon() {
        passwordEyeIcon.click();
    }

    public void clickOnRegisterNowButton() {
        visibilityHelper.waitForVisibilityOf(registerButton);
        registerButton.click();
    }
}