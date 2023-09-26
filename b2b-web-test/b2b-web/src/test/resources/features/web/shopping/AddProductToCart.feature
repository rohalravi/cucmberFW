Feature: Verify search and add product functionality

  @internaltestdata @shoppingscenario-3 @US547
  Scenario: Verify user search and add a product to card from web site
    Given user on the home page and login successfully
    When user search for HTC
    And user add "htc OneBlue" to cart
    And user click checkout button
    And user click checkout as a guest
    Then user fill the billing details and click continue
    | first_name | John |
    | last_name | Smith |
    | email | kma@hotmail.com |
    | country | United States |
    | state | Ohio |
    | city | Columbus |
    | address1 | 123 Main St |
    | postal_code | 43215 |
    | phone_number | 614-555-1212 |
    And user click shipping detail continue button
    And user select next day shipping and click continue button
    And user fills the payment detail and click continue
    | cc_type | Visa |
    | cc_name | John Smith |
    | cc_number | 4111111111111111 |
    | month | 03 |
    | year | 2023 |
    | cc_cvc | 245 |
    Then validate order price as "$110.00" on order page



  @externaltestdata @shoppingscenario-3 @us547
  Scenario: Verify user add product to cart and checkout with data from external file
    Given user on the home page and login successfully
    When user search for HTC
    And user add "htc OneBlue" to cart
    And user click checkout button
    And user click checkout as a guest
    Then user fill the billing detail from "BillingAddressDetail" sheet for test_scenario "TS_001"
    And user click shipping detail continue button
    And user select next day shipping and click continue button
    And user fills the payment detail from "CardDetail" sheet for test_scenario "TS_001"
    Then validate order price as "$110.00" on order page


    