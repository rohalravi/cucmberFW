/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.FileUtils;
import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.UserAccount.*;
import com.pepsico.retail.pages.BasePage;
import com.pepsico.retail.runners.Hook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserAccountPage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private YourOrders yourOrders;
    @Autowired
    private LogoutSection logoutSection;

    @Autowired
    private YourProfile yourProfile;

    @Autowired
    AnswerToYourQuestionSection frequentlyAskQuestion;

    @FindBy(how = How.XPATH, using = "//li[starts-with(@class,'makeStyles-active')]")
    private WebElement highlightedHomeTab;

    private Notification notification;

    @Autowired
    private Hook hook;

    @Autowired
    private LegalPolicy legalPolicy;

    @FindBy(how = How.XPATH, using = "//div[@class='makeStyles-container-132 MuiBox-root css-0']//span")
    private List<WebElement> mainCategory;

    @FindBy(how = How.XPATH, using = "(//div[@name='sidebar-menu'])//h2")
    private List<WebElement> subCategoryElement;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'])[3]")
    private WebElement accountTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='makeStyles-formGap-200 MuiBox-root css-0']//label")
    private List<WebElement> personalDetailsTitleText;

    @FindBy(how = How.XPATH, using = "//div[@class='makeStyles-container-202 MuiBox-root css-0']//input")
    private List<WebElement> enterPersonalDetails;

    @FindBy(how = How.XPATH, using = "//div[@id='save-changes-button-container']/button")
    private WebElement saveChangesButton;

    @FindBy(how = How.XPATH, using = "//div[@id='Image-upload-container']//div")
    private List<WebElement> uploadImageElements;

    @FindBy(how = How.XPATH, using = "//*[@id='delete-button-container']/div")
    private WebElement deleteAccountLink;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='close']")
    private WebElement popUpCrossIcon;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-1equabv-MuiGrid-root']//*[name()='svg']")
    private WebElement markedCorrectIcon;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-1idn90j-MuiGrid-root']//h5")
    private WebElement personalDetailsUpdatedText;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing makeStyles-dialogActions-234 css-hlj6pa-MuiDialogActions-root']//button")
    private WebElement closePopButton;

    @FindBy(how = How.XPATH, using = "//div[@id='yes-logout-button-container-logout']//button")
    private WebElement yesButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Rewards history']")
    private WebElement rewardsHistoryOption;

    @FindBy(how = How.XPATH, using = "//h2[text()='Your rewards']")
    private WebElement yourRewards;

    @FindBy(how = How.XPATH, using = "//h2[text()='Notifications']")
    private WebElement notificationOption;

    @FindBy(how = How.XPATH, using = "//h2[text()='Your profile']")
    private WebElement yourProfileOption;

    @FindBy(how = How.XPATH, using = "//h2[text()='Legal Policy']")
    private WebElement legalPolicyText;

    @FindBy(how = How.XPATH, using = "//span[@id='change-password_title']")
    private WebElement changePasswordText;

    @FindBy(how = How.XPATH, using = "//span[@id='undefined_title']")
    private WebElement addProfilePicButton;

    @FindBy(how = How.XPATH, using = "//input[@type='file']")
    private WebElement addPicInput;

    @FindBy(how = How.XPATH, using = "//h2[text()='Answers to your questions']")
    private WebElement answerToYourQuestionText;


    public boolean isYourAccountPageDisplayed() {
        return accountTitle.isDisplayed();
    }

    private void isAllCategoryItemsPresent(String category) throws InterruptedException {
        if (category.equals("Account")) {
            mainCategory.get(0).isDisplayed();
        } else if (category.equals("Order history")) {
            mainCategory.get(1).isDisplayed();
        } else if (category.equals("Rewards history")) {
            mainCategory.get(2).isDisplayed();
        } else if (category.equals("Settings")) {
            libraryHelper.scrollIntoView(mainCategory.get(3));
            mainCategory.get(3).isDisplayed();
        } else if (category.equals("Need help?")) {
            libraryHelper.scrollIntoView(mainCategory.get(4));
            mainCategory.get(4).isDisplayed();
        }
    }

    public void verifyAllCategoryItemsPresent(String category) throws InterruptedException {
        isAllCategoryItemsPresent(category);
    }

    private void isAllSubCategoryItemsPresent(String subCategory) throws InterruptedException {
        if (subCategory.equals("Your Profile")) {
            subCategoryElement.get(0).isDisplayed();
        } else if (subCategory.equals("Your Stores")) {
            subCategoryElement.get(1).isDisplayed();
        } else if (subCategory.equals("Your Orders")) {
            subCategoryElement.get(2).isDisplayed();
        } else if (subCategory.equals("Your points breakdown")) {
            subCategoryElement.get(3).isDisplayed();
        } else if (subCategory.equals("Your rewards")) {
            libraryHelper.scrollIntoView(subCategoryElement.get(4));
            subCategoryElement.get(4).isDisplayed();
        } else if (subCategory.equals("Notifications")) {
            libraryHelper.scrollIntoView(subCategoryElement.get(5));
            subCategoryElement.get(5).isDisplayed();
        } else if (subCategory.equals("Legal Policy")) {
            libraryHelper.scrollIntoView(subCategoryElement.get(6));
            subCategoryElement.get(6).isDisplayed();
        } else if (subCategory.equals("Log out")) {
            libraryHelper.scrollIntoView(subCategoryElement.get(7));
            subCategoryElement.get(7).isDisplayed();
        } else if (subCategory.equals("Answers to your questions")) {
            libraryHelper.scrollIntoView(subCategoryElement.get(8));
            subCategoryElement.get(8).isDisplayed();
        }
    }

    public void verifyAllSubCategoryItemsPresent(String subCategory) throws InterruptedException {
        isAllSubCategoryItemsPresent(subCategory);
    }

    public void clickOnYourProfileButton() {
        subCategoryElement.get(0).click();
    }

    public boolean personalDetailTitleText_IsPresent() throws InterruptedException {

        for (WebElement titleText : personalDetailsTitleText) {
            libraryHelper.scrollIntoView(titleText);
            if (!titleText.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean personalDetailEnterField_IsPresent() throws InterruptedException {
        for (WebElement enterPersonalDetailsField : enterPersonalDetails) {
            libraryHelper.scrollIntoView(enterPersonalDetailsField);
            if (!enterPersonalDetailsField.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean saveChangesButton_IsDisabled() throws InterruptedException {
        if (!saveChangesButton.getAttribute("class").contains("disabled")) {
            libraryHelper.scrollIntoView(saveChangesButton);
            return true;
        }
        return false;
    }

    public boolean imageContainerAndUploadButton_IsPresent() {
        for (WebElement imageUpload : uploadImageElements) {
            if (!imageUpload.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public void deleteAccountElementsIsVisible() throws InterruptedException {
        libraryHelper.scrollIntoView(deleteAccountLink);
        deleteAccountLink.isDisplayed();
    }

    public void modifyNameFieldEntry() {
        enterPersonalDetails.get(0).sendKeys("Test4333");
    }

    public void clickSaveButton() throws InterruptedException {
        libraryHelper.scrollIntoView(saveChangesButton);
        saveChangesButton.click();
    }

    public boolean personalDetailsUpdatedPopUp_IsVisible() {
        return personalDetailsUpdatedText.isDisplayed();
    }

    public boolean verifyPopUpElement() {
        return markedCorrectIcon.isDisplayed() && personalDetailsUpdatedText.isDisplayed() && popUpCrossIcon.isDisplayed() && closePopButton.isDisplayed();
    }

    public void clickOnPopUpCloseButton() {
        closePopButton.click();
    }

    public void clickOnPopUpCrossIcon() {
        popUpCrossIcon.click();
    }

    public void clickOnLogOutCategory() {
        subCategoryElement.get(7).click();
    }

    public void clickOnYesButton() {
        yesButton.click();
    }

    public boolean logOutScreenElementsVisible() {
        visibilityHelper.waitForVisibilityOf(logoutSection.getLogoutText());
        return visibilityHelper.isElementPresent(logoutSection.getTitleText())
                && visibilityHelper.isElementPresent(logoutSection.getLogoutImage())
                && visibilityHelper.isElementPresent(logoutSection.getYesButton());
    }

    public void clickOnNotificationOption() throws InterruptedException {
        visibilityHelper.waitForSeconds();
        libraryHelper.scrollIntoView(rewardsHistoryOption);
        visibilityHelper.waitForSeconds();
        notificationOption.click();
        visibilityHelper.waitForSeconds();
        libraryHelper.executeJS("window.scrollBy(0,-750)", "");
        visibilityHelper.waitForSeconds();
    }

    public void turnsOnToggleButton() throws InterruptedException {
        notification.getToggleButton().click();
        libraryHelper.executeJS("window.scrollBy(0,600)", "");
        visibilityHelper.waitForVisibilityOf(notification.getTurnedOnNotificationTitle());
    }

    public void turnsOffToggleButton() throws InterruptedException {
        notification.getToggleButton().click();
        libraryHelper.executeJS("window.scrollBy(0,600)", "");
        visibilityHelper.waitForVisibilityOf(notification.getTurnedOffNotificationTitle());
    }

    public void clickLegalPolicyButton() throws InterruptedException {
        libraryHelper.scrollIntoView(rewardsHistoryOption);
        visibilityHelper.waitForSeconds();
        legalPolicyText.click();
        visibilityHelper.waitForSeconds();
        libraryHelper.scrollIntoView(yourProfileOption);
        libraryHelper.executeJS("window.scrollBy(0,-700)", "");
    }

    public void clickOnDownloadButtonOnLegalPolicy() {
        legalPolicy.getDownloadIcon().click();
        visibilityHelper.waitForSeconds();
    }

    public boolean isChangePasswordTextVisible() throws InterruptedException {
        libraryHelper.scrollIntoView(changePasswordText);
        return visibilityHelper.isElementPresent(changePasswordText);
    }

    public void clickChangePasswordText() {
        changePasswordText.click();
        visibilityHelper.waitForSeconds();
    }

    public void enterCurrentPassword(String password) {
        yourProfile.getPopUpCurrentPasswordInput().sendKeys(password);
    }

    public void enterNewPassword(String password) {
        yourProfile.getPopUpNewPasswordInput().sendKeys(password);
    }

    public void enterPasswordInConfirmPasswordField(String password) throws InterruptedException {
        yourProfile.getPopUpConfirmPasswordInput().sendKeys(password);
        libraryHelper.scrollIntoView(yourProfile.getSamePasswordText());
    }

    public void clickChangePasswordButton() {
        yourProfile.getChangePasswordButton().click();
        visibilityHelper.waitForElementToVisible(yourProfile.getSuccessTitle());
    }

    public void clickOnEyeIcon() {
        for (WebElement allEyes : yourProfile.getEyeIcon()) {
            allEyes.click();
        }
    }

    public void clickOnAnswerToYourQuestions() throws InterruptedException {
        libraryHelper.scrollIntoView(rewardsHistoryOption);
        answerToYourQuestionText.click();
        visibilityHelper.waitForSeconds();
        libraryHelper.executeJS("window.scrollBy(0,-1000)", "");
        visibilityHelper.waitForSeconds();
    }

    public boolean verifyTitleOnFqaPage() {
        Boolean result = Boolean.TRUE;
        for (WebElement title : frequentlyAskQuestion.getFaqTitle()) {
            if (!title.isDisplayed()) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }

    public void clickOnAddProfileButton() {
        yourProfile.getAddProfilePicButton().click();
        visibilityHelper.waitForSeconds();

    }

    public void addPicture(String path) throws IOException {
        fileUtils.uploadImage(path);
        visibilityHelper.waitForSeconds();
    }

    public void clickReplacePicButton() {
        yourProfile.getReplacePicButton().click();
        visibilityHelper.waitForSeconds();
    }

    public void clickOnUploadButtonAgain() {
        yourProfile.getUploadAgainButton().click();
    }


    public Boolean isAllSectionsVisible() {
        Boolean result = Boolean.TRUE;
        for (WebElement title : frequentlyAskQuestion.getAllSections()) {
            if (!title.isDisplayed()) {
                result = Boolean.FALSE;
            }
        }
        return result;
    }


    public boolean isSectionsExpanded() {
        libraryHelper.executeJS("window.scrollBy(0,250)", "");
        visibilityHelper.waitForSeconds();
        for (int i = 0; i < frequentlyAskQuestion.getAllSections().size(); i++) {
            frequentlyAskQuestion.getAllSections().get(i).click();
            visibilityHelper.waitForSeconds();
            if (!frequentlyAskQuestion.getAllSubSections().get(i).getAttribute("class").contains("expanded")) {
                return false;
            }

        }
        return false;
    }

    public boolean verifyOrdersDateAndCost(){
        for(int i=0;i<yourOrders.getOrderDate().size();i++){
            if(!yourOrders.getOrderDate().get(i).isDisplayed() && yourOrders.getOrderCosts().get(i).isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public boolean verifySortOrder(){
        visibilityHelper.waitForSeconds();
        List<WebElement> allOrderDates = yourOrders.getOrderDate();
        List<String> allOrderDates2 = new ArrayList<>();

        for (WebElement date : allOrderDates) {
            allOrderDates2.add(date.getText());
        }

        System.out.println("All orders date 2..."+allOrderDates2);
        List<String> allDate = new ArrayList<>(allOrderDates2);
        System.out.println("All date..."+allDate);
        Collections.sort(allOrderDates2, Collections.reverseOrder());
        if (!allOrderDates2.equals(allDate)) {
            return false;
        }
        else return true;
    }

    public boolean verifyOrderStatus(String[] status) {
        List<String> allStatus = Arrays.asList(status);

        Boolean result = Boolean.TRUE;
        for (int i = 0; i < yourOrders.getOrderStatusText().size(); i++) {
            if (!allStatus.contains(yourOrders.getOrderStatusText().get(i).getText())) {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
    public  boolean verifyOrderInfoBelowOrderDate(){

        Boolean result=Boolean.TRUE;
        for(int i=0;i<yourOrders.getOrderTotalProducts().size();i++){
            if(!yourOrders.getOrderTotalProducts().get(i).getText().isEmpty()&& yourOrders.getOrderType().get(i).getText().isEmpty() && yourOrders.getExpectedDelivery().get(i).getText().isEmpty()){
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }

}