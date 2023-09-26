package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YourStore implements BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='sidebar-menu']")
    private List<WebElement> yourStoreLink;

    @FindBy(how = How.XPATH, using = "(//p[@id='undefined_title'])[1]")
    private WebElement yourStoreText;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@id='accountStores_image_placeholder'])[1]")
    private WebElement storeImage;

    @FindBy(how = How.XPATH, using = "//p[@id='accountStores_addressCard_title']")
    private WebElement storeName;

    @FindBy(how = How.XPATH, using = "//button[@id='accountStores_addressCard_editBtn']")
    private WebElement editButton;

    @FindBy(how = How.XPATH, using = "//div[@id='accountStores_addressCard_adress']")
    private WebElement storeAddressContainer;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiBox-root css-0']//p")
    private WebElement incorrectInformationMessage;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiBox-root css-0']//a")
    private WebElement storeContactHelpCenterTextButton;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@id='points_icon'])[1]")
    private WebElement badgeIcon;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item makeStyles-pointsLabelContainer-361 css-13i4rnv-MuiGrid-root']")
    private WebElement tradePointText;

    @FindBy(how = How.XPATH, using = "//button[@id='trade_pts_cancel']")
    private WebElement tradePointButton;

    @FindBy(how = How.XPATH, using = "//h5[@name='accountStores_callHelplineDialog_modal_dialog_title_text_title']")
    private WebElement popUpTitleText;

    @FindBy(how = How.XPATH, using = "//div[@id='accountStores_callHelplineDialog_modal_dialog_img']//*[name()='svg']")
    private WebElement popUpImage;

    @FindBy(how = How.XPATH, using = "//button[@id='accountStores_callHelplineDialog_modal_dialog_main_close_btn']")
    private WebElement popUpCloseButton;

    @FindBy(how = How.XPATH, using = "//button[@id='accountStores_callHelplineDialog_modal_dialog_close_btn']//*[name()='svg']")
    private WebElement popUpCrossButton;

    @FindBy(how = How.XPATH, using = "//h5[@id='updateStoreName_modal_dialog_title_text_title']")
    private WebElement popUpStoreName;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Edit store name']")
    private WebElement editStoreName;

    @FindBy(how = How.XPATH, using = "//button[@id='updateStoreName_modal_dialog_cancel_btn']")
    private WebElement popUpCancelButton;

    @FindBy(how = How.XPATH, using = "//button[@id='updateStoreName_modal_dialog_submit_btn']")
    private WebElement popUpSaveButton;

    @FindBy(how = How.XPATH, using = "//h5[@name='accountStores_callHelplineDialog_modal_dialog_title_text_title']")
    private WebElement helplinePopUpTitleText;

    @FindBy(how = How.XPATH, using = "//button[@id='accountStores_callHelplineDialog_modal_dialog_main_close_btn']")
    private WebElement helplinePopUpCloseButton;

    @FindBy(how = How.XPATH, using = "//button[@id='transfer_pts_cancel']")
    private WebElement transferYourPointsButton;

    @FindBy(how = How.XPATH, using = "//span[@id='Transfer_Points_back_button_text']")
    private WebElement transferYourPointsBackButton;

    @FindBy(how = How.XPATH, using = "//span[@name='Transfer_Points_title']")
    private WebElement transferDetailsTitle;

    @FindBy(how = How.XPATH, using = "//label[@name='Transfer_Points_from_label']")
    private WebElement transferPointsFromLabelField;

    @FindBy(how = How.XPATH, using = "//input[@name='Transfer_Points_from_input_field']")
    private WebElement transferPointsFromInputField;

    @FindBy(how = How.XPATH, using = "//label[@name='Transfer_Points_to_label']")
    private WebElement transferPointsToLabelField;

    @FindBy(how = How.XPATH, using = "//div[@id='Transfer_Points_select_drop_down']")
    private WebElement transferPointsToInputField;

    @FindBy(how = How.XPATH, using = "//ul//li[contains(@id,'Transfer_Points_menu_item')]/div/span")
    private List<WebElement> transferPointsToInputDropDownField;
    @FindBy(how = How.XPATH, using = "//label[@id='Transfer_Points_how_many_points_label']")
    private WebElement howManyPointsTransferLabelField;

    @FindBy(how = How.XPATH, using = "//input[@name='points']")
    private WebElement howManyPointsTransferInputField;

    @FindBy(how = How.XPATH, using = "//h5[@id='modal_dialog_title_text_title']")
    private WebElement transferYourPointsPopupTitle;
    @FindBy(how = How.XPATH, using = "//span[@id='modal_dialog_subtitle_text_title']")
    private WebElement transferYourPointsPopupSubTitle;

    @FindBy(how = How.XPATH, using = "//button[@id='Transfer_Points_transfer_button']")
    private WebElement transferPointsButton;

    @FindBy(how = How.XPATH, using = "//button[@id='modal_dialog_main_close_btn']")
    private WebElement yesTransferPointsButtonOnPopUp;

    @FindBy(how = How.XPATH, using = "//button[@id=\"modal_dialog_cancel_btn\"]")
    private WebElement cancelTransferPointsButtonOnPopUp;


    public WebElement getTransferYourPointsPopupTitle(){
        return transferYourPointsPopupTitle;
    }

    public WebElement getTransferYourPointsPopupSubTitle(){
        return transferYourPointsPopupSubTitle;
    }

    public WebElement getYesTransferPointsButtonOnPopUp(){
        return yesTransferPointsButtonOnPopUp;
    }

    public WebElement getCancelTransferPointsButtonOnPopUp(){
        return cancelTransferPointsButtonOnPopUp;
    }
    public WebElement getTransferYourPointsButton(){
        return  transferYourPointsButton;
    }

    public  WebElement getTransferDetailsTitle(){
        return transferDetailsTitle;
    }

    public WebElement getTransferYourPointsBackButton(){
        return transferYourPointsBackButton;
    }

    public  WebElement getTransferPointsFromLabelField(){
        return transferPointsFromLabelField;
    }

    public WebElement getTransferPointsFromInputField(){
        return transferPointsFromInputField;
    }

    public WebElement getTransferPointsToLabelField(){
        return transferPointsToLabelField;
    }

    public WebElement getTransferPointsToInputField(){
        return transferPointsToInputField;
    }
    public List<WebElement> getTransferPointsToInputDropDownField(){
        return transferPointsToInputDropDownField;
    }

    public WebElement getHowManyPointsTransferLabelField(){
        return howManyPointsTransferLabelField;
    }

    public WebElement getHowManyPointsTransferInputField(){
        return howManyPointsTransferInputField;
    }
    public WebElement getTransferPointsButton(){
        return transferPointsButton;
    }

    public WebElement getTheYourStoreLinks() {
        return yourStoreLink.get(1);
    }

    public WebElement getTheYourStoreText() {
        return yourStoreText;
    }

    public WebElement getStoreImage() {
        return storeImage;
    }

    public WebElement getStoreName() {
        return storeName;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getStoreAddressContainer() {
        return storeAddressContainer;
    }

    public WebElement getIncorrectInformationMessage() {
        return incorrectInformationMessage;
    }

    public WebElement getStoreContactHelpCenterTextButton() {
        return storeContactHelpCenterTextButton;
    }

    public WebElement getBadgeIcon() {
        return badgeIcon;
    }

    public WebElement getTradePointText() {
        return tradePointText;
    }

    public WebElement getTradePointButton() {
        return tradePointButton;
    }

    public WebElement getPopUpTitleText() {
        return popUpTitleText;
    }

    public WebElement getPopUpImage() {
        return popUpImage;
    }

    public WebElement getPopUpCloseButton() {
        return popUpCloseButton;
    }

    public WebElement getPopUpCrossButton() {
        return popUpCrossButton;
    }

    public WebElement getPopUpStoreName(){
        return popUpStoreName;
    }

    public WebElement getEditStoreName(){
        return editStoreName;
    }

    public WebElement getPopUpCancelButton(){
        return popUpCancelButton;
    }

    public WebElement getPopUpSaveButton() {
        return popUpSaveButton;
    }

    public WebElement getHelpLinePopUpTitleText(){
        return helplinePopUpTitleText;
    }

    public WebElement getHelpLinePopUpCloseButton(){
        return helplinePopUpCloseButton;
    }

}
