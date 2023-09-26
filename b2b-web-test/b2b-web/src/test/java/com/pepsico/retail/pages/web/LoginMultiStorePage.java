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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginMultiStorePage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private LibraryHelper libraryHelper;

    @FindBy(xpath = "//div[@name='store-select-message-header']")
    private WebElement storeScreenTitleText;

    @FindBy(xpath = "//*[local-name()='svg' and @name='store-icon']")
    private WebElement storeIcon;

    @FindBy(xpath = "//*[local-name()='div' and @name='store-selection-header-text']")
    private WebElement yourStoreText;

    @FindBy(xpath = "//div[@name='store-select-message']")
    private WebElement storeScreenSubText;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item makeStyles-storeName-66 css-13i4rnv-MuiGrid-root']")
    private List<WebElement> storeName;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item makeStyles-storeAddress-64 css-13i4rnv-MuiGrid-root']")
    private List<WebElement> storeNameSubText;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item makeStyles-logo-67 css-13i4rnv-MuiGrid-root']")
    private List<WebElement> storeTagName;

    @FindBy(xpath = "//input[contains(@id,'Store_List_radio')]")
    private List<WebElement> storeSelectionRadioButton;

    @FindBy(xpath = "//*[@name='view-all-button']")
    private WebElement viewAllButton;

    @FindBy(xpath = "//input[@name='search-input']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='right-arrow-button']")
    private WebElement nextStepButton;

    @FindBy(xpath = "//div[@name='drawer-top']//div")
    private List<WebElement> storePopUpTitleElements;

    @FindBy(xpath = "//*[@class='MuiGrid-root MuiGrid-item makeStyles-storeDetails-81 css-13i4rnv-MuiGrid-root']//div")
    private List<WebElement> storeTitleSubTitleRadioButton;

    @FindBy(xpath = "//div[@name='drawer-close-button-label']")
    private WebElement closePopUpButton;

    @FindBy(xpath = "//div[@id='drawer-title']")
    private WebElement yourstoreTitleText;

    @FindBy(xpath = "//div[@id='drawer-title']")
    private WebElement selectStore;

    @FindBy(xpath = "//input[@name='search-input']")
    private WebElement searchStores;

    @FindBy(xpath = "//div[contains(@id,'Title')]")
    private List<WebElement> allStoreNames;

    @FindBy(xpath = "//div[contains(@id,'Address')]")
    private List<WebElement> allStoreAddress;

    @FindBy(xpath = "//p[@id='body-title_title']")
    private WebElement noResultText;

    @FindBy(xpath = "//p[@id='body-description_title']")
    private WebElement noResultSubText;

    @FindBy(xpath = "//button[@name='right-arrow-button']")
    private WebElement nextStep;


    public WebElement getNextStep(){
        return nextStep;
    }

    public WebElement getNoResultText() {
        return noResultText;
    }

    public WebElement getViewAllButton() {
        return viewAllButton;
    }

    public WebElement getNoResultSubText() {
        return noResultSubText;
    }

    public WebElement getYourstoreTitleText() {
        return yourstoreTitleText;
    }

    public void enterTextInSearchStore(String text) {
        visibilityHelper.waitForElementToVisible(searchStores);
        searchStores.sendKeys(text);
    }

    public boolean verifySearchResult(String text) {
        List<String> stores = new ArrayList<>();
        for (int i = 0; i < allStoreNames.size(); i++) {
            stores.add(allStoreNames.get(i).getText());
            stores.add(allStoreAddress.get(i).getText());
        }

        String allStoredNamesAndAddress = stores.toString();
        if (!allStoredNamesAndAddress.contains(text)) {
            return false;
        } else return true;
    }

    public WebElement getSelectStore() {
        return selectStore;
    }

    public WebElement getClosePopUpButton() {
        return closePopUpButton;
    }

    public void storeSelectionScreen_IsPresent() {
        visibilityHelper.isElementPresent(storeScreenTitleText);
    }

    public boolean validateStoreSelectionScreenElements() {
        visibilityHelper.isElementPresent(storeScreenTitleText);
        for (WebElement nameOfStore : storeName) {
            return visibilityHelper.isElementPresent(nameOfStore);
        }
        for (WebElement subTextStoreName : storeNameSubText) {
            return visibilityHelper.isElementPresent(subTextStoreName);
        }
        for (WebElement storeTagNameTitle : storeTagName) {
            return visibilityHelper.isElementPresent(storeTagNameTitle);
        }
        for (WebElement storeRadioButton : storeSelectionRadioButton) {
            return visibilityHelper.isElementPresent(storeRadioButton);
        }
        return visibilityHelper.isElementPresent(storeIcon) && visibilityHelper.isElementPresent(yourStoreText);
    }

    public void validateAndClickOnViewAllLink() {
        libraryHelper.executeJS("window.scrollBy(0,500)", "");
        visibilityHelper.waitForElementToVisible(viewAllButton);
        visibilityHelper.isElementPresent(viewAllButton);
        viewAllButton.click();
        visibilityHelper.waitForElementToVisible(yourStoreText);
    }

    public boolean validateStoreSelectionPopUpElements() {
        for (WebElement popUpStoreDetails : storeTitleSubTitleRadioButton) {
            return visibilityHelper.isElementPresent(popUpStoreDetails);
        }
        return visibilityHelper.isElementPresent(storePopUpTitleElements.get(0)) && visibilityHelper.isElementPresent(storePopUpTitleElements.get(1))
                && visibilityHelper.isElementPresent(searchField);
    }

    public void clickOnPopUpCloseButton() {
        closePopUpButton.click();
    }

    public void selectFirstStoreRadioButton() {
        visibilityHelper.waitForSeconds();
        storeSelectionRadioButton.get(0).click();
        libraryHelper.executeJS("window.scrollBy(0,900)","");
        visibilityHelper.waitForSeconds();
        nextStep.click();
        visibilityHelper.waitForSeconds();
    }

    public void clickOnNextStepButton() {
        visibilityHelper.isElementPresent(nextStepButton);
        nextStepButton.click();
    }

    public boolean isAllStoreListDisplayed() {
        return true;
    }

}

