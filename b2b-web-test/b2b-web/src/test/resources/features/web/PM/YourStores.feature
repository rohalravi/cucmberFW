@F7394601 @E7121728
Feature: Verify your stores screen

  Background: user navigate to your stores screen
    Given user should login in the application with english as a language option
    When user click on the profile icon on home page
    And user click on your store option

  @smoke @regression @pi7.5 @p1 @US7370177
  Scenario: Validate the store info-Store image,name,ID,help center number
    Then user see "Your store" text
    And  user should see store image
    And  user should see store name with edit icon
    And  user should see store address
    And user should see store ID number
    And user should see the message "Is any of the information incorrect?"
    And user should see help center text button link
    And user see store points details, badge and trade point button

  @smoke @regression @pi7.5 @p1 @US7370177
  Scenario: Validate help line pop up elements and close button functionality
    When user click on see help center text button link
    Then user can see call help center pop up appear on your store screen
    And user can see store pop up image
    And user can see help line text details
    And user should see close pop up button
    When user click on close pop up button
    Then user should see store name with edit icon

  @smoke @regression @pi7.5 @p1 @US7370177
  Scenario: Verify cross button functionality of help line pop up
    When user click on see help center text button link
    Then user can see call help center pop up appear on your store screen
    When user click on cross button on help line pop up
    Then user should see store name with edit icon

  @smoke @regression @pi7.5 @p1 @US7706009
  Scenario: Validate the Store name edit popup
    Then user should see store name with edit icon
    When user click on edit button on your store page
    Then user can see store name edit pop up appear on your store screen
    And user can see edit store nickname field
    And user can see cancel and save buttons
    And user can see help line text details
    When user click on cancel button on store name popup
    Then user will navigate to your store page

  @smoke @regression @pi7.5 @p1 @US7706009
  Scenario: Verify store name edit popup cross button functionality
    Then user should see store name with edit icon
    When user click on edit button on your store page
    And user click on cross button on store name popup
    Then user will navigate to your store page

  @smoke @regression @pi7.5 @p1 @US7706009
  Scenario: Verify contact help center link functionality
    Then user should see store name with edit icon
    When user click on contact help center link on your store page
    Then user can see help center pop up on store page
    When user click on cross button on help line pop up
    Then user will navigate to your store page

  @smoke @regression @pi7.5 @p1 @US7706009
  Scenario: Verify contact help center link functionality
    Then user should see store name with edit icon
    When user click on contact help center link on your store page
    Then user can see help center pop up on store page
    When user click on close button on help line pop up
    Then user will navigate to your store page

