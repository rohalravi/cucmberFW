@E7769579 @F7667595
Feature: Verify user registration page

  @smoke @regression @pi7.6 @p1 @US7737816 @sp
  Scenario: Verify ui elements of user registration page
    Given user navigate on the landing page
    When user click on the register now button on landing page
    Then user will navigate to the registration page
    And user can see registration title text and subtext
    And user see Your VAT number and phone number field title texts on registration page
    And user see fields for entering Your VAT number and phone number on registration page
    And user see Go back button
    And user can see inactive Next step button
    When user click on go button on registration page
    Then user navigate on the landing page