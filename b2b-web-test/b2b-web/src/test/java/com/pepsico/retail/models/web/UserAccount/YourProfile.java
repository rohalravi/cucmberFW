package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YourProfile implements BasePage {

    @FindBy(how = How.XPATH, using = "//p[@id='change-password_title']")
    private WebElement PopUpTitle;
    @FindBy(how = How.XPATH, using = "//p[@name='change-password-subTitle_title']")
    private WebElement PopUpSubTitle;
    @FindBy(how = How.XPATH, using = "//p[@name='CP_profile_password_label']")
    private WebElement PopUpCurrentPasswordLabel;
    @FindBy(how = How.XPATH, using = "//input[@name='currentPassword']")
    private WebElement PopUpCurrentPasswordInput;
    @FindBy(how = How.XPATH, using = "//p[@name='CP_profile_password_label']")
    private WebElement PopUpUpNewPasswordLabel;
    @FindBy(how = How.XPATH, using = "//input[@name='newPassword']")
    private WebElement PopUpUpNewPasswordInput;
    @FindBy(how = How.XPATH, using = "//p[@id=\"CP_enter_confirm_password_label\"]")
    private WebElement PopUpConfirmPasswordLabel;
    @FindBy(how = How.XPATH, using = "//input[@id='confirmPassword']")
    private WebElement PopUpConfirmPasswordInput;
    @FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
    private WebElement PopUpCancelButton;
    @FindBy(how = How.XPATH, using = "//button[@name='change-password-btn']")
    private WebElement changePasswordButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'disabled')]")
    private WebElement changePasswordButtonDisabled;
    @FindBy(how = How.XPATH, using = "//button[@aria-label='close']")
    private WebElement crossIcon;
    @FindBy(how = How.XPATH, using = "//li[contains(@class,'inputLabelError')]")
    private WebElement oktaReqText;

    @FindBy(how = How.XPATH, using = "//p[@name='CP_password_match_label']")
    private WebElement samePasswordText;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'makeStyles-unionContainer')]")
    private List<WebElement> eyeIcon;

    @FindBy(how = How.XPATH, using = "//p[contains(@class,'successTitle')]")
    private WebElement successTitle;

    @FindBy(how = How.XPATH, using = "//button[text()=\"Close\"]")
    private  WebElement closeButton;

    @FindBy(how = How.XPATH, using = "//span[@id='delete-button_title']")
    private  WebElement deleteAccountOption;

    @FindBy(how = How.XPATH, using = "//h5[@id='delete_Account_modal_dialog_title_text_title']")
    private  WebElement deleteAccountPopUpTitle;

    @FindBy(how = How.XPATH, using = "//p[@id='delete_Account_modal_dialog_subTitle_text_title']")
    private  WebElement deleteAccountPopUpSubTitle;

    @FindBy(how = How.XPATH, using = "//button[@id='delete_Account_modal_dialog_cancel_btn']")
    private  WebElement deleteAccountPopUpCancelButton;

    @FindBy(how = How.XPATH, using = "//button[@id='delete_Account_modal_dialog_submit_btn']")
    private  WebElement deleteAccountPopUpConfirmButton;

    @FindBy(how = How.XPATH, using = "//button[@id='delete_Account_modal_dialog_close_btn']")
    private  WebElement deleteAccountPopUpCloseButton;

    @FindBy(how = How.XPATH, using = "//span[@id='delete-button_title']")
    private  WebElement deleteOnlineAccountText;

    @FindBy(how = How.XPATH, using = "//div[@id='delete_Account_modal_dialog_icon']")
    private  WebElement deleteOnlineAccountPopUpIcon;

    @FindBy(how = How.XPATH, using = "//h5[@name='modal_dialog_title_text_title']")
    private  WebElement picUpdatedPopUpText;

    @FindBy(how = How.XPATH, using = "//span[@id='modal_dialog_subtitle_text_title']    ")
    private  WebElement picUpdatedPopUpTextSubTitle;

    @FindBy(how = How.XPATH, using = "//span[@id='modal_dialog_subtitle_text_title']    ")
    private  WebElement picUpdatedPopUpUploadAgainButton;

    @FindBy(how = How.XPATH, using = "//button[@id='modal_dialog_cancel_btn']")
    private  WebElement picUpdatedCloseButtonPopUp;

    @FindBy(how = How.XPATH, using = "//button[@id='modal_dialog_close_btn']")
    private  WebElement picUpdatedCrossButtonPopUp;

    @FindBy(how = How.XPATH, using = "//div[@id='modal_dialog_failed_icon']")
    private  WebElement picUpdateFailedIcon;

    @FindBy(how = How.XPATH, using = "//span[@id='undefined_title']")
    private WebElement addProfilePicButton;

    @FindBy(how = How.XPATH, using = "//span[@id='undefined_title']")
    private WebElement replacePicButton;

    @FindBy(how = How.XPATH, using = "//button[@id='modal_dialog_main_close_btn']")
    private WebElement uploadAgainButton;

    @FindBy(how = How.XPATH, using = "//div[@name='Image-upload-camera-icon']")
    private WebElement cameraIcon;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'supportedTypesMessage')]")
    private List<WebElement> supportedFileFormatText;

    @FindBy(how = How.XPATH, using = "//div[@id='modal_dialog_success_icon']")
    private WebElement successIcon;

    @FindBy(how = How.XPATH, using = "//h5[@name='modal_dialog_title_text_title']")
    private WebElement successText;

    @FindBy(how = How.XPATH, using = "//button[@id='modal_dialog_main_close_btn']")
    private WebElement picUpdatedPopUpCloseButton;

    public WebElement getSuccessIcon(){
        return successIcon;
    }

    public  WebElement getSuccessText(){
        return successText;
    }

    public WebElement getPicUpdatedPopUpCloseButton(){
        return picUpdatedPopUpCloseButton;
    }



    public List<WebElement> getSupportedFileFormatText(){
        return supportedFileFormatText;
    }
    public WebElement getCameraIcon(){
        return cameraIcon;
    }
    public WebElement getAddProfilePicButton(){
        return addProfilePicButton;
    }

    public WebElement getPopUpTitle() {
        return PopUpTitle;
    }

    public WebElement getChangePasswordPopUpSubTitle() {
        return PopUpSubTitle;
    }

    public WebElement getPopUpCurrentPasswordLabel() {
        return PopUpCurrentPasswordLabel;
    }

    public WebElement getPopUpCurrentPasswordInput() {
        return PopUpCurrentPasswordInput;
    }

    public WebElement getPopUpNewPasswordInput() {
        return PopUpUpNewPasswordInput;
    }

    public WebElement getPopUpNewPasswordLabel() {
        return PopUpUpNewPasswordLabel;
    }

    public WebElement getPopUpConfirmPasswordLabel() {
        return PopUpConfirmPasswordLabel;
    }

    public WebElement getPopUpConfirmPasswordInput() {
        return PopUpConfirmPasswordInput;
    }

    public WebElement getCancelButton() {
        return PopUpCancelButton;
    }

    public WebElement getChangePasswordButton() {
        return changePasswordButton;
    }

    public WebElement getCrossIcon() {
        return crossIcon;
    }

    public WebElement getOktaReqText() {
        return oktaReqText;
    }

    public WebElement getSamePasswordText() {
        return samePasswordText;
    }

    public List<WebElement> getEyeIcon() {
        return eyeIcon;
    }

    public WebElement getSuccessTitle() {
        return successTitle;
    }

    public WebElement getCloseButton() {
        return closeButton;
    }
    public WebElement getChangePasswordButtonDisabled() {
        return changePasswordButtonDisabled;
    }


    public WebElement getDeleteAccountPopUpTitle(){
        return deleteAccountPopUpTitle;
    }

    public WebElement getDeleteAccountPopUpSubTitle(){
        return deleteAccountPopUpSubTitle;
    }

    public WebElement getDeleteAccountPopUpCancelButton(){
        return deleteAccountPopUpCancelButton;
    }

    public WebElement getDeleteAccountPopUpConfirmButton(){
        return deleteAccountPopUpConfirmButton;
    }

    public WebElement getDeleteAccountPopUpCloseButton(){
        return deleteAccountPopUpCloseButton;
    }

    public WebElement getDeleteAccountText(){
        return deleteOnlineAccountText;
    }

    public WebElement getDeleteOnlineAccountPopUpIcon(){
        return deleteOnlineAccountPopUpIcon;
    }

    public WebElement getPicUpdatedPopUpText(){
        return picUpdatedPopUpText;
    }

    public WebElement getPicUpdatedCrossButtonPopUp(){
        return picUpdatedCrossButtonPopUp;
    }

    public WebElement getPicUpdatedCloseButtonPopUp(){
        return picUpdatedCloseButtonPopUp;
    }

    public WebElement getPicUpdatedPopUpTextSubTitle(){
        return picUpdatedPopUpTextSubTitle;
    }
    public WebElement getPicUpdatedPopUpUploadAgainButton(){
        return picUpdatedPopUpUploadAgainButton;
    }

    public WebElement getReplacePicButton(){
        return replacePicButton;
    }

    public WebElement getUploadAgainButton(){
        return uploadAgainButton;
    }



}
