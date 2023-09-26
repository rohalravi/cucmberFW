@F7394601 @E7121728
Feature: Validation of your account profile page

  Background:  User Login to web application with valid credentials
    Given user should login in the application with english as a language option
    When user click on the profile icon on home page

  @regression @pi7.4 @p1 @US7543601
  Scenario: Validate change password popup
    And user should be click on your profile sub category
    And user should see change password text on your profile page
    When user click on change password text option on your profile page
    Then popup title and subtitle should be visible
    And cancel and change Password button should be visible on change password popup
    And cross icon should be visible on change password popup
    And change password should not be enabled on change password popup
    And helpLine banner pop up is visible at popup


  @regression @pi7.4 @p1 @US7543601
  Scenario Outline: Validate error messages for incorrect password on change password popup
    And user should see change password text on your profile page
    When user click on change password text option on your profile page
    And user enters "<incorrectPassword>" in new password field
    Then okta requirement text highlight in red color
    Examples:
      | incorrectPassword |
      | lLogint@          |
      | Login@1           |
      | LOGIN@12          |
      | login@12          |
      | 9800007890        |

  @regression @pi7.4 @p1 @US7543601
  Scenario Outline: Validate error messages for same passwords on change password popup
    And user should be click on your profile sub category
    And user should see change password text on your profile page
    When user click on change password text option on your profile page
    And user enters "<current password>" in current password field
    And user enters "<new password>" in new password field
    And user enter same password "<same password>" in confirm password field
    Then user shall see "<message>" on change password popup
    Examples:
      | current password | new password | same password | message                                           |
      | User@123         | User@123     | Test@123      | Both passwords must match                         |
      | User@123         | User@123     | User@123      | New password is the same as the previous password |


  @regression @pi7.4 @p1 @US7543601
  Scenario: Validate password successfully unmasked on all password fields
    And user should be click on your profile sub category
    And user should see change password text on your profile page
    When user click on change password text option on your profile page
    And user enters "Columbia@123" in current password field
    And user enters "User@123" in new password field
    And user enter password "User@123" in confirm password field
    Then password should be masked for all the fields
    And change password button should be enabled on popup
    When user clicks on eye icon on all the fields
    Then password should be unmasked for all the fields



















