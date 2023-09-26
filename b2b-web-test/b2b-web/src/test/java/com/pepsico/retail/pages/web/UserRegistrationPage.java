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
public class UserRegistrationPage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private LibraryHelper libraryHelper;

    @FindBy(how = How.XPATH, using = "//*[@name='title_title']")
    private WebElement welcomeTitleText;

    @FindBy(how = How.XPATH, using = "//*[@name='description_first_title']")
    private WebElement welcomeSubTextOne;

    @FindBy(how = How.XPATH, using = "//*[@name='description_second_title']")
    private WebElement welcomeSubTextSecond;

    @FindBy(how = How.XPATH, using = "//label[contains(@name,'number')]")
    private List<WebElement> fieldTitleTexts;

    @FindBy(how = How.XPATH, using = "//*[@id='VAT_number_input']")
    private WebElement enterVATNumber;

    @FindBy(how = How.XPATH, using = "//*[@id='phone_number_input']")
    private WebElement enterPhoneNumber;

    @FindBy(how = How.XPATH, using = "//*[@id='btn_back']")
    private WebElement goBackButton;

    @FindBy(how = How.XPATH, using = "//*[@tabindex='-1']")
    private WebElement nextStepInactiveButton;

    public boolean userIsOnRegistrationPage() {
        return visibilityHelper.isElementPresent(welcomeTitleText);
    }

    public boolean isRegistrationTitleTextPresent() {
        return welcomeTitleText.isDisplayed();
    }

    public boolean isRegistrationSubTextPresent() {
        return welcomeSubTextOne.isDisplayed() && welcomeSubTextSecond.isDisplayed();
    }

    public boolean isFieldTitleTextPresent() {
        for (WebElement VATAndPhoneNumberTitleText:fieldTitleTexts) {
            if(!visibilityHelper.isElementPresent(VATAndPhoneNumberTitleText)){
                return false;
            }
        }
        return true;
    }

    public boolean isVATNumberInputFieldPresent() {
        return visibilityHelper.isElementPresent(enterPhoneNumber);
    }

    public boolean isPhoneNumberFieldPresent() {
        return visibilityHelper.isElementPresent(enterPhoneNumber);
    }

    public boolean goBackButtonIsPresent() {
        return visibilityHelper.isElementPresent(goBackButton);
    }

    public boolean isNextStepButton_Inactive() {
        return visibilityHelper.isElementPresent(nextStepInactiveButton);
    }

    public void clickOnGoBackButton() {
        goBackButton.click();
    }
}