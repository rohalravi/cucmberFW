@F7394601 @E7121728
Feature: Validation of your account profile page

  Background:  User Login to web application with valid credentials
    Given user should login in the application with english as a language option
    When user click on the profile icon on home page

  @smoke @regression @pi7.3 @p1 @US7543387
  Scenario Outline: Validate category and sub category on the profile page
    Then user should be navigate to your account page
    And user should see main "<Category>" on user account page
    Examples:
      | Category        |
      | Account         |
      | Order history   |
      | Rewards history |
      | Settings        |
      | Need help?      |

  @smoke @regression @pi7.3 @p1 @US7543387
  Scenario Outline: Validate category and sub category on the profile page
    Then user should be navigate to your account page
    And user should see "<subCategory>" within main category
    Examples:
      | subCategory               |
      | Your Profile              |
      | Your Stores               |
      | Your Orders               |
      | Your points breakdown     |
      | Your rewards              |
      | Notifications             |
      | Legal Policy              |
      | Log out                   |
      | Answers to your questions |

  @smoke @regression @pi7.3 @p1 @US7543387
  Scenario: Validate category and sub category on the profile page
    Then user should be click on your profile sub category
    And user can see personal details title texts
    And user can see fields for entering personal details
    And user can see save changes disabled button
    And user can see profile pictures details
    And user can see details for deleting online account

  @smoke @regression @pi7.3 @p1 @US7543387
  Scenario: Validate elements of the personal details updated pop up
    Then user should be click on your profile sub category
    And user changes details in name field
    And user clicks on save changed button
    Then user can see personal details updated pop up
    And user verify elements of the personal details updated pop up
    When user click on close button on pop up
    Then user should be navigate to your account page

  @smoke @regression @pi7.3 @p2 @US7543387
  Scenario: Validate user can close personal details pop up on clicking cross icon
    Then user should be click on your profile sub category
    And user changes details in name field
    And user clicks on save changed button
    Then user can see personal details updated pop up
    When user click on cross icon on pop up
    Then user should be navigate to your account page

  @smoke @regression @pi7.4 @p1 @US7358212
  Scenario: verify logout feature
    Then user should be navigate to your account page
    When user click on log out sub category
    And user should see elements of the log out screen
    When user click on yes button
    Then user navigate on the landing page

  @regression @pi7.4 @p1 @US7366772
  Scenario: Validate notifications screen
    And user click on notification option
    Then user should see notification title subtitles and toggle button on notification page
    And notification toggle button should be turned off by default on notification page
    When user turns on the toggle button on notification page
    Then user will see the message "SMS Notification Turned On" on notification page
    When user turns off the toggle button
    Then user will see the message notification off "SMS Notification Turned OFF" on notification page

  @regression @pi7.4 @p1 @US7366806
  Scenario: Validate legal policy screen
    And user click on legal policy button
    Then user should see title as "Legal Policy" on legal policy page
    And user should see download text and icon on legal policy page
    When user click on download button
    Then pdf file name "Legal_Policy_Pepsico.pdf" should be downloaded

  @regression @pi7.5 @p1 @US7543601
  Scenario: Validate delete account
    And user should be click on your profile sub category
    And user should see "Delete online account" option on your profile screen
    When user click on delete online account option
    Then delete account popup should be displayed
    And user should see title and subtitle on delete account popup
    And cancel button,confirm button and cross icon should be visible on delete account popup
    And helpLine banner pop up is visible at popup

  @regression @pi7.5 @p1 @US7368750
  Scenario: Validate faq page
    And user click on answer to your questions
    Then user should see all title on the faq page
    And helpLine banner pop up is visible at popup
    And user should see three sections under frequently asked questions
    And user will see each section expanded after clicking on each section on faq page

























