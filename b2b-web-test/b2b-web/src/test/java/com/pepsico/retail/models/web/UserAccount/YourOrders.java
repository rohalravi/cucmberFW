package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class YourOrders implements BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='sidebar-menu']//h2")
    private List<WebElement> allCategories;

    @FindBy(how = How.XPATH, using = "//p[@id='your_order_title']")
    private WebElement yourOrderTitle;

    @FindBy(how = How.XPATH, using = "//p[@id='card_title_title']")
    private WebElement yourOrderCountTitle;

    @FindBy(how = How.XPATH, using = "//p[@id='filter_label_title']")
    private WebElement filterLabelTitle;

    @FindBy(how = How.XPATH, using = "//div[@id='order_dashed_container']")
    private WebElement allPricesWithVatText;

    @FindBy(how = How.XPATH, using = "//button[@id='order_btn']")
    private List<WebElement> viewOrderButton;

    @FindBy(how = How.XPATH, using = "//p[@id='orderCost_title']")
    private List<WebElement> orderCostTitle;

    @FindBy(how = How.XPATH, using = "//div[@id='details_container']")
    private List<WebElement> detailsContainer;

    @FindBy(how = How.XPATH, using = "//p[@name='orderDate_title']")
    private List<WebElement> orderDates;

    @FindBy(how = How.XPATH, using = "//p[@name='orderDate_title']")
    private List<WebElement> orderCosts;

    @FindBy(how = How.XPATH, using = "")
    private List<WebElement> viewOrders;

    @FindBy(how = How.XPATH, using = "//div[@id='order_total_product']")
    private List<WebElement> orderTotalProducts;

    @FindBy(how = How.XPATH, using = "//div[@id='order_order-type']")
    private List<WebElement> orderType;

    @FindBy(how = How.XPATH, using = "//div[@id='order_order_expected_delivery']")
    private List<WebElement> expectedDelivery;

    @FindBy(how = How.XPATH, using = "//p[@name='orderStatus_title']")
    private List<WebElement> orderStatusText;

    public List<WebElement> getAllCategories(){
       return allCategories;
   }

   public WebElement getYourOrderTitle(){
       return yourOrderTitle;
   }

   public WebElement getYourOrderCountTitle(){
       return yourOrderCountTitle;
   }

   public WebElement getFilterLabelTitle(){
       return filterLabelTitle;
   }
   public WebElement getAllPricesWithVatText(){
       return allPricesWithVatText;
   }

   public List<WebElement> getOrderCostTitle(){
       return orderCostTitle;
   }


    public List<WebElement> getOrderDate(){
        return orderDates;
    }

    public List<WebElement> getOrderCosts(){
        return orderCosts;
    }
    public List<WebElement> getViewOrderButton(){
        return viewOrderButton;
    }
    public List<WebElement> getOrderStatusText(){
        return orderStatusText;
    }

   public List<WebElement> getOrderTotalProducts(){
        return orderTotalProducts;
   }

    public List<WebElement> getOrderType(){
        return orderType;
    }

    public List<WebElement> getExpectedDelivery(){
        return expectedDelivery;
    }







}
