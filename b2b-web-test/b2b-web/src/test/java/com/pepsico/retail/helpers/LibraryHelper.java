/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.helpers;

import com.pepsico.retail.runners.Hook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryHelper {

    @Autowired
    private Hook hooks;

    public void scrollIntoView(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) hooks.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(700);
    }

    public Object executeJS(String javascript, Object... objects) {
        Object returnObj = null;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) hooks.getDriver();
        try {
            returnObj = jsExecutor.executeScript(javascript, objects);
        } catch (Exception e) {
        }
        return returnObj;
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(hooks.getDriver());
        action.moveToElement(element).perform();
    }

    public Select select(WebElement element, int intex) {
        Select dropDown = new Select(element);
        dropDown.selectByIndex(intex);
        return dropDown;
    }

    public boolean isValueEmpty(String elementText) {
        try {
            return elementText.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
