/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.helpers;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import com.pepsico.retail.runners.Hook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VisibilityHelper {

    @Autowired
    private Hook hooks;

    public void waitForVisibilityOf(WebElement element) {
        hooks.getWait().until(visibilityOf(element));
    }

    public void waitForPresenceOf(By by) {
        hooks.getWait().until(visibilityOfElementLocated(by));
    }

    public void waitForInvisibilityOf(WebElement element) {
        hooks.getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToVisible(WebElement locator) {
        hooks.getWait().until(ExpectedConditions.visibilityOf(locator));
    }


    public void waitForElementToBeClickable(WebElement element) {
        hooks.getWait().until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }


    public void waitForSeconds() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
