package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pepsico.retail.runners.Hook;

import java.util.List;

@Component
public class LanguagePage implements BasePage {

    @Autowired
    VisibilityHelper visibilityHelper;

    @Autowired
    Hook hook;

    @Autowired
    GlobalComponentsPage globalComponentsPage;

    @FindBy(xpath = "//*[@id='language-en']//button")
    private WebElement selectButtonEnglish;

    @FindBy(xpath = "//*[@id='language-es']//button")
    private WebElement selectSelectButtonSpanish; 

    @FindBy(xpath = "//*[@id='language-zh']//button")
    private WebElement selectSelectButtonChinese; 

    @FindBy(xpath = "//*[@id='picker_button']")
    private WebElement displayedLanguageLanguagePicker;

    @FindBy(xpath = "(//*[@id='phoneNumberLabel']/..//span)[1]")
    private WebElement changedLanguageText;

    @FindBy(xpath = "//*[@id='language_picker_box']//div//b")
    private List<WebElement> languageCount;

    @FindBy(xpath = "//*[@id='language-en']//b")
    private WebElement englishLanguageText ;

    @FindBy(xpath = "//*[@id='language-es']//b")
    private WebElement spanishLanguageText ;

    @FindBy(xpath = "//*[@id='language-zh']//b")
    private WebElement chineseLanguageText ;

    @FindBy(xpath = "//*[@id='picker_button']//img")
    private WebElement Flag;

    @FindBy(xpath = "//button[@id='picker_button']")
    private WebElement languageSelectorButton;

    @FindBy(xpath = "(//*[@id='language_picker_select'])[1]")
    private WebElement languageSelectorButtonVerification;



    public boolean isSelectEnglishButtonDisplayed() {
        return selectSelectButtonSpanish.isDisplayed();
    }

    public boolean isSelectSpanishButtonDisplayed() {
        return selectButtonEnglish.isDisplayed();
    }
    public boolean isEnglishOptionFromDropDownDisplayed() {
        return selectSelectButtonSpanish.isDisplayed();
    }

    public boolean isSpanishOptionFromDropDownDisplayed() {
        return selectButtonEnglish.isDisplayed();
    }
    public boolean isEnglandFlagDisplayed() {
        displayedLanguageLanguagePicker.isDisplayed();
        return Flag.isDisplayed();
    }
    public boolean isColombianFlagDisplayed() {
        displayedLanguageLanguagePicker.isDisplayed();
        return Flag.isDisplayed();
    }

    public void clickEnglishSelection() {
        selectButtonEnglish.click();
    }

    public void clickSpanishSelection() {
        selectSelectButtonSpanish.click();
    }

    public String displayedLanguage() {
        return displayedLanguageLanguagePicker.getText();
    }

    public void clickLanguageSelector() {
        visibilityHelper.waitForSeconds();
        languageSelectorButton.click();
        visibilityHelper.waitForElementToVisible(languageSelectorButtonVerification);
        visibilityHelper.waitForSeconds();
    }

    public String changedLanguage(String language) {
        return changedLanguageText.getText();
    }
    
    public int getNumberOfLanguage() {
        return languageCount.size();
    }

    public void setSelectedLanguage(String language) {
        if(language.equals(englishLanguageText.getText()))
        {selectButtonEnglish.click();}
        else if(language.equals(spanishLanguageText.getText()))
        {selectSelectButtonSpanish.click();}
        else if(language.equals(chineseLanguageText.getText()))
        {selectSelectButtonChinese.click();}
    }
}