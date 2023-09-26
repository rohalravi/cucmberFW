package com.pepsico.retail.steps;

import com.pepsico.retail.pages.web.CentricBillingPage;
import com.pepsico.retail.pages.web.CentricPaymentInfo;
import com.pepsico.retail.pages.web.CentricProductsPage;
import com.pepsico.retail.pages.web.CentricShoppingCart;
import com.pepsico.retail.pages.web.CentricShoppingStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import io.cucumber.datatable.DataTable;

public class ShoppingSteps extends Steps {

   @Autowired
   private CentricShoppingStore shoppingpage;

   @Autowired
   private CentricProductsPage productpage;

   @Autowired
   private CentricShoppingCart shoppingcart;

   @Autowired
   private CentricBillingPage billingpage;

   @Autowired
   private CentricPaymentInfo paymentinfo;

   @Given("I have launched the site")
   public void userNavigateOnTheLandingPage() throws InterruptedException {
      Assert.assertTrue("Welcome to our store", shoppingpage.verifyWelcomeText());

   }

   @And("I have searched for {string}")
   public void userVerifySearch(String device) throws InterruptedException {
      shoppingpage.search(device);

   }

   @And("I have added {string} to my cart")
   public void userVerifyDeviceAdd(String searcheddevice) throws InterruptedException {
      productpage.addToCart(searcheddevice);
      Assert.assertTrue("Welcome text is not visible", productpage.verifyProductText(searcheddevice));
   }

   @And("I begin the checkout process as a guest")
   public void userVerifyGuestCheckout() throws InterruptedException {
      Assert.assertTrue("Shopping cart", shoppingcart.verifyText());
      shoppingcart.guestCheckOut();
   }

   @When("I enter billing address information like {string},{string},{string},{string},{string},{string},{string},{string},{string}")

   public void userVerifyBillingDetails(String first_name, String last_name, String email, String country, String state,
         String city, String address1, String zip, String phone) throws InterruptedException {
      billingpage.enterBillingDetails(first_name, last_name, email, country, state, city, address1, zip, phone);
      Assert.assertTrue("Checkout", billingpage.verifyCheckoutText());
   }

   @And("I pay via details like {string},{string},{string},{string},{string}")
   public void userVerifyPay(String cc_name, String cc_number, String cc_month, String cc_year,
         String cc_cvc) throws InterruptedException {
      Assert.assertTrue("Welcome text is not visible", paymentinfo.verifyPaymentScreenText());
      paymentinfo.enterPaymentDetails(cc_name, cc_number, cc_month, cc_year, cc_cvc);
   }

   @And("I confirm order totalling {string}")
   public void userVerifyOrder(String Amount) throws InterruptedException {
      paymentinfo.confirmPriceDetails(Amount);
   }

   @Then("I will receive a confirmation")
   public void userVerifyOrderConfirmation() throws InterruptedException {
      Assert.assertTrue("Your order has been successfully processed!", paymentinfo.orderConfirm());
   }

   @And("I have searched for product")
   public void userSearchProduct(DataTable table) throws Exception {
      Map<String, String> mapFieldVals = table.asMap();
      Iterator newValIterator = mapFieldVals.entrySet().iterator();
      while (newValIterator.hasNext())

      {

         Map.Entry pair = (Map.Entry) newValIterator.next();

         pair.getKey().toString().equalsIgnoreCase("search_field");

         String searchField = pair.getValue().toString();
         shoppingpage.search(searchField);
      }
   }

   @And("I have added product to my cart")
   public void userAddProductToCart(DataTable table) throws Exception {
      Map<String, String> mapFieldVals = table.asMap();
      Iterator newValIterator = mapFieldVals.entrySet().iterator();
      while (newValIterator.hasNext())

      {

         Map.Entry pair = (Map.Entry) newValIterator.next();

         pair.getKey().toString().equalsIgnoreCase("search_field");

         String searchField = pair.getValue().toString();
         productpage.addToCart(searchField);
      }
   }

   @When("I enter billing address information like")
   public void userAddBillingDetails(DataTable table) throws Exception {

      Map<String, String> mapFieldVals = table.asMap();
      Iterator hmIterator = mapFieldVals.entrySet().iterator();
      while (hmIterator.hasNext()) {

         try {
            Map.Entry pair = (Map.Entry) hmIterator.next();
            billingpage.userDetails(pair.getKey().toString(), pair.getValue().toString());
         } catch (Exception e) {

         }
      }
   }

   @And("I pay via details like")
   public void userPayViaBillingDetails(DataTable table) throws Exception {
      Map<String, String> mapFieldVals = table.asMap();
      Iterator hmIterator = mapFieldVals.entrySet().iterator();
      while (hmIterator.hasNext()) {

         try {
            Map.Entry pair = (Map.Entry) hmIterator.next();
           paymentinfo.cardDetails(pair.getKey().toString(), pair.getValue().toString());
         } catch (Exception e) {

         }
      }
   }
}
