package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class Notification implements BasePage {

    @FindBy(how = How.XPATH, using = "//span[@name='notificationTitle_title']")
    private WebElement notificationTitle;

    @FindBy(how = How.XPATH, using = "//span[@name='receiveSMSTitle_title']")
    private WebElement receiveSmsTitle;

    @FindBy(how = How.XPATH, using = "//span[@name='switchNotificationDescription_title']")
    private WebElement receiveSmsSubTitle;

    @FindBy(how = How.XPATH, using = "//input[@class=\"PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3\"]//parent::span[contains(@class,'MuiSwitch')]")
    private WebElement toggleButton;

    @FindBy(how = How.XPATH, using = "//input[@class=\"PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3\"]//parent::span[contains(@class,'MuiSwitch')]")
    private WebElement turnOffToggleButton;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Mui-checked')]")
    private WebElement turnOnToggleButton;

    @FindBy(how = How.XPATH, using = "//div[text()=\"SMS Notification Turned On\"]")
    private WebElement turnedOnNotification;

    @FindBy(how = How.XPATH, using = "//div[text()=\"SMS Notification Turned OFF\"]")
    private WebElement turnedOffNotification;

    public WebElement getNotificationTitle() {
        return notificationTitle;
    }

    public WebElement getTurnedOnNotificationTitle() {
        return turnedOnNotification;
    }

    public WebElement getTurnedOffNotificationTitle() {
        return turnedOffNotification;
    }

    public WebElement getReceiveSmsTitle() {
        return receiveSmsTitle;
    }

    public WebElement getReceiveSmsSubTitle() {
        return receiveSmsSubTitle;
    }

    public WebElement getToggleButton() {
        return toggleButton;
    }

    public WebElement getTurnOnToggleButton() {
        return turnOnToggleButton;
    }

    public WebElement getTurnedOffToggleButton() {
        return turnOffToggleButton;
    }

}
