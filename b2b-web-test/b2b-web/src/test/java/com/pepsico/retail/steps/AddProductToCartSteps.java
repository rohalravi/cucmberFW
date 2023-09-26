package com.pepsico.retail.steps;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pepsico.retail.helpers.ExcelReaderHelper;
import com.pepsico.retail.pages.web.ShoppingBillingDetailPage;
import com.pepsico.retail.pages.web.ShoppingCartPage;
import com.pepsico.retail.pages.web.ShoppingConfirmOrderPage;
import com.pepsico.retail.pages.web.ShoppingLoginPage;
import com.pepsico.retail.pages.web.ShoppingPaymentDetailPage;
import com.pepsico.retail.pages.web.ShoppingProductPage;
import com.pepsico.retail.pages.web.ShoppingHomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductToCartSteps {

    @Autowired
    private ShoppingHomePage homePage;

    @Autowired
    private ShoppingProductPage productPage;

    @Autowired
    private ShoppingCartPage cartPage;

    @Autowired
    private ShoppingLoginPage loginPage;

    @Autowired
    private ShoppingBillingDetailPage billingPage;

    @Autowired
    private ShoppingPaymentDetailPage paymentDetailPage;

    @Autowired
    private ShoppingConfirmOrderPage confirmOrderPage;

    // @Autowired
    // ExcelReaderHelper excelReaderHelper;

    @Given("user navigate to home page")
    public void userNavigateToHomePage() {

    }

    @Given("user on the home page and login successfully")
    public void user_navigated_to_homepage_login_successfully(){
        homePage.navigateToHomePage();
        //homePage.clickLoginLink();
        //loginPage.enterUsername();
        //loginPage.enterPassword();
        //loginPage.clickLoginIn();
    }

    @When("user search for HTC")
    public void user_search_for_htc() {
        homePage.searchProduct("HTC");

    }

    @And("user add {string} to cart")
    public void userAddProductToCart(String a) {
        homePage.clickHTCOne();
        productPage.clickAddToCart();
        productPage.checkProductAddedSuccessMsg();
        productPage.closeSuccessMsg();
        homePage.clickCartIcon();
    }

    @And("user click checkout button")
    public void user_click_checkout() {
        cartPage.check_termsOfService();
        cartPage.click_checkOut();

    }

    @And("user click checkout as a guest")
    public void checkout_as_guest(){
        cartPage.click_checkOutAsGuest();
    }

    @Then("^user fill the billing details and click continue$")
    public void user_fill_billing_detail(DataTable dataTable) throws InterruptedException{
        List<List<String>> data = dataTable.asLists(String.class);
        Thread.sleep(2000);
        billingPage.enter_firstName(data.get(0).get(1));
        billingPage.enter_lastName(data.get(1).get(1));
        billingPage.enter_email(data.get(2).get(1));
        Thread.sleep(2000);
        billingPage.select_country(data.get(3).get(1));
        Thread.sleep(2000);
        billingPage.select_state(data.get(4).get(1));
        billingPage.enter_city(data.get(5).get(1));
        billingPage.enter_address1(data.get(6).get(1));
        billingPage.enter_postalCode(data.get(7).get(1));
        billingPage.enter_phoneNumber(data.get(8).get(1));

        billingPage.click_billingContinueBtn();
    }

    @Then("user fill the billing detail from {string} sheet for test_scenario {string}")
    public void fill_billing_detail_from_sheet(String SheetName, String ScenarioName) throws Exception{
        Map<String,String> testData = ExcelReaderHelper.gettestDataInMap(SheetName, ScenarioName);

        Thread.sleep(2000);
        billingPage.enter_firstName(testData.get("first_name"));
        billingPage.enter_lastName(testData.get("last_name"));
        billingPage.enter_email(testData.get("email"));
        Thread.sleep(2000);
        billingPage.select_country(testData.get("country"));
        Thread.sleep(2000);
        billingPage.select_state(testData.get("state"));
        billingPage.enter_city(testData.get("city"));
        billingPage.enter_address1(testData.get("address1"));
        billingPage.enter_postalCode(testData.get("zip"));
        billingPage.enter_phoneNumber(testData.get("phone"));

        billingPage.click_billingContinueBtn();
    }

    @And("user click shipping detail continue button")
    public void user_click_shippingContinue(){
        billingPage.click_shippingContinueBtn();
    }

    @And("user select next day shipping and click continue button")
    public void user_click_shippingMethod_continue() throws InterruptedException{
        billingPage.clickRadio_shippingMethodNxtDay();
        Thread.sleep(2000);
        billingPage.click_shippingMethodContinueBtn();
    }

    @And("user fills the payment detail and click continue")
    public void fill_payment_detail(DataTable datatable){
        List<List<String>> cc_detail = datatable.asLists(String.class);
        paymentDetailPage.select_card_type(cc_detail.get(0).get(1));
        paymentDetailPage.enter_cardholder_name(cc_detail.get(1).get(1));
        paymentDetailPage.enter_cardnumber(cc_detail.get(2).get(1));
        paymentDetailPage.select_expire_month(cc_detail.get(3).get(1));
        paymentDetailPage.select_expire_year(cc_detail.get(4).get(1));
        paymentDetailPage.enter_cardcode(cc_detail.get(5).get(1));

        paymentDetailPage.click_paymentInfoContinueBtn();
    }

    @And("user fills the payment detail from {string} sheet for test_scenario {string}")
    public void fill_payment_detail_from_testsheet(String SheetName, String ScenarioName) throws Exception{
        Map<String,String> testData = ExcelReaderHelper.gettestDataInMap(SheetName, ScenarioName);
        
        paymentDetailPage.select_card_type(testData.get("cc_type"));
        paymentDetailPage.enter_cardholder_name(testData.get("cc_name"));
        paymentDetailPage.enter_cardnumber(testData.get("cc_number"));
        paymentDetailPage.select_expire_month(testData.get("cc_month"));
        paymentDetailPage.select_expire_year(testData.get("cc_year"));
        paymentDetailPage.enter_cardcode(testData.get("cc_cvc"));

        paymentDetailPage.click_paymentInfoContinueBtn();
    }

    @Then("validate order price as {string} on order page")
    public void validate_orderPrice_on_orderPage(String expPrice){
        confirmOrderPage.validate_orderPrice(expPrice);
        confirmOrderPage.click_confirmOrderContinueBtn();
    }


}
