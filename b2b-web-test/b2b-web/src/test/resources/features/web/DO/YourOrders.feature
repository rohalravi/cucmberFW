@F7394601
Feature: Verify your orders page

  Background: user navigate to your order screen
    Given user should login in the application with english as a language option
    When user click on the profile icon on home page
    And user click on your orders

  @regression @US7326855 @p1 @pi7.5
  Scenario: validate the navigation of your orders tab
    Then user should see header as "Your orders"
    And user should see all prices with vat text
    And user should see total orders
    And user should see orders data in descending order
    And user should see view order button
    And user should see order date and costs
    And user should see order info below order date
    And user should see order status text "In progress,In transit,Delivered,Cancelled"






