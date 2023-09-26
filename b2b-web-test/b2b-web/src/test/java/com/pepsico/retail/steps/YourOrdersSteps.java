package com.pepsico.retail.steps;

import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.UserAccount.YourOrders;
import com.pepsico.retail.pages.web.UserAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class YourOrdersSteps {

    @Autowired
    private YourOrders yourOrders;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private UserAccountPage userAccountPage;

    @And("user click on your orders")
    public void userClickOnYourOrders() {
        yourOrders.getAllCategories().get(2).click();
        visibilityHelper.waitForVisibilityOf(yourOrders.getYourOrderTitle());
    }

    @Then("user should see header as {string}")
    public void userShouldSeeHeaderAs(String headerText) {
        Assert.assertEquals(yourOrders.getYourOrderTitle().getText(), headerText);
    }

    @And("user should see all prices with vat text")
    public void userShouldSeeAllPricesWithVatText() {
        Assert.assertTrue("vat text is not displayed", yourOrders.getAllPricesWithVatText().isDisplayed());
    }

    @And("user should see total orders")
    public void userShouldSeeTotalOrders() {
        Assert.assertTrue("Total orders values is not displayed", yourOrders.getYourOrderCountTitle().isDisplayed());
    }

    @And("user should see order date and costs")
    public void userShouldSeeOrderDetails() {
        Assert.assertTrue("Order date and cost is not visible", userAccountPage.verifyOrdersDateAndCost());
    }

    @And("user should see order info below order date")
    public void userShouldSeeOrderInfoBelowOrderDate() {
        Assert.assertTrue("Order date and cost is not visible", userAccountPage.verifyOrderInfoBelowOrderDate());
    }

    @And("user should see view order button")
    public void userShouldSeeViewOrderButton() {
        for(int i=0;i<yourOrders.getViewOrderButton().size();i++) {
            Assert.assertTrue("View order button is not visible",visibilityHelper.isElementPresent(yourOrders.getViewOrderButton().get(i)));
        }
    }

    @And("user should see orders data in descending order")
    public void userShouldSeeOrdersDataInDescendingOrder() {
        Assert.assertTrue("orders data is not sorted", userAccountPage.verifySortOrder());
    }

    @And("user should see order status text {string}")
    public void userShouldSeeOrderStatusText(String status) {
        String[] allStatus = status.split(",");
        Assert.assertTrue("Order status is not correct", userAccountPage.verifyOrderStatus(allStatus));
    }
}
