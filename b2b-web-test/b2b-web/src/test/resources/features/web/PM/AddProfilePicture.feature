@F7394601 @E7121728
Feature: Add profile picture popup your Profile page

  Background:  User Login to web application with valid credentials
    Given user should login in the application with english as a language option
    When user click on the profile icon on home page

  @smoke @regression @p1 @pi7.5 @US7543596
  Scenario: Validate picture successfully added
    And user should see supported file format text
    And user click on add profile picture button
    And user add picture ten mb in size
    Then user shall see message "Your profile picture has been added"
    And user shall see close button and cancel popup on your profile picture popup

  @regression @pi7.3 @p2 @US7543596
  Scenario: Validate picture format error messages on 11 mb size and incorrect format
    And user click on replace profile picture button
    And user add picture more than ten mb in size
    Then user should see pop up with message on adding incorrrect picture
    When user clicks on close button
    Then user navigate back to your profile page
    And user click on replace profile picture button
    When user add picture in other format than jpg and png
    Then user should see pop up with message on adding incorrrect picture
    When user clicks on upload again button
    And user add picture ten mb in size
    Then user should see pop up for updating pic with message "Your profile picture has been updated"

  @regression @pi7.5 @p2 @US7543596
  Scenario: Validate replacing a picture
    And user click on replace profile picture button
    And user add picture ten mb in size
    Then user should see pop up for updating pic with message "Your profile picture has been updated"







