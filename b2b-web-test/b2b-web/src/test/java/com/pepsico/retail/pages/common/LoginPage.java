/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.pages.common;

import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.v102.security.model.VisibleSecurityState;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginPage implements BasePage {

    @Autowired
    String coPhoneNumber, coPassword, multiStorePhoneNumber, multiStorePassword;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='btnSignIn']")
    private WebElement login;

    @FindBy(xpath = "//button[@id='btnSignIn']")
    private WebElement loginButtonActive;

    @FindBy(how = How.XPATH, using = "(//*[@id='phoneNumberLabel']/following::span)[1]")
    private WebElement phoneNumber_validation_message;

    @FindBy(xpath = "//*[@id='undefined_title']")
    private List<WebElement> errorPopupText;

    @FindBy(xpath = "//button[@id='wrongLoginDialog_modal_dialog_main_close_btn']")
    private WebElement tryAgain;

    @FindBy(xpath = "//span[text()='You have reached the maximum log in attempts. Please, call our helpline for further assistance.']")
    private WebElement multiplAttemptsPopup;

    @FindBy(xpath = "//button[@id='wrongLoginDialog_modal_dialog_close_btn']")
    private WebElement closeIconPopup;

    @FindBy(xpath = "//span[contains(@class,\"makeStyles-modalHelpLine\")]")
    private List<WebElement> helplineBannerText;

    @FindBy(xpath = "//img[@alt='Modal Phone Image']")
    private WebElement helplineBannerImage;

    @FindBy(xpath = "(//*[@id='phoneNumber']/..//div)[1]")
    private WebElement crossIcon;

    public void login() {
        phoneNumber.sendKeys(coPhoneNumber);
        password.sendKeys(coPassword);
        login.click();
        visibilityHelper.waitForSeconds();
    }

    public void multiStoreLogin() {
        phoneNumber.sendKeys(multiStorePhoneNumber);
        password.sendKeys(multiStorePassword);
        login.click();
        visibilityHelper.waitForSeconds();
    }

    public void loginCredentials(String sPhoneNumber, String sLoginPassword) {
        phoneNumber.sendKeys(sPhoneNumber);
        password.sendKeys(sLoginPassword);
        visibilityHelper.waitForVisibilityOf(login);
        login.isEnabled();
    }

    public String getPhoneNumberValidationMessage() {
        return phoneNumber_validation_message.getText();
    }

    public boolean verifyPopUp(String[] message) {
        Boolean result = Boolean.TRUE;
        for (int i = 0; i < errorPopupText.size(); i++) {
            if (!errorPopupText.get(i).getText().equals(message[i])) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public String isMaximumAttemptPopupDisplayed() {
        return multiplAttemptsPopup.getText();
    }

    public boolean isCrossIconAndTryAgainButtonPesent() {
        return visibilityHelper.isElementPresent(closeIconPopup) &&
                visibilityHelper.isElementPresent(tryAgain);
    }

    public void enterPhoneNumberAndPassword(String coPnum, String coPassword) {
        phoneNumber.sendKeys(coPnum);
        password.sendKeys(coPassword);
        login.click();
        visibilityHelper.waitForSeconds();
    }

    public boolean isHelpineLineBannerOnPopUpVisible() {
        visibilityHelper.isElementPresent(helplineBannerImage);
        for (int i = 0; i < helplineBannerText.size(); i++) {
            if (!visibilityHelper.isElementPresent(helplineBannerText.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void clickOnLoginButton() {
        login.click();
    }

    public void clickOnPhoneNumberCrossIcon() {
        crossIcon.click();
    }

    public void enterUserName(String mPhoneNumber) {
        phoneNumber.sendKeys(mPhoneNumber);
    }

    public void enterPassword(String mPassword) {
        password.sendKeys(mPassword);
    }

}
