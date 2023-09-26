@E7121728 @F7460216
Feature: Home page validations

  @regression @pi7.2 @p1 @US7274760
  Scenario: Verify welcome message and CTA button on homepage
    Given user should login in the application with english as a language option
    Then user should see welcome message
    And user should see cta buttons

  @regression @pi7.3 @p1 @US7277952
  Scenario: Verify promotion section title and see all text on homepage
    Given user should login in the application with english as a language option
    And user navigate to promotion section
    Then user should see promotion title and seeAll text
    And user should see both arrow button

  @regression @pi7.3 @p1 @US7277952
  Scenario: Verify different images on promotion carousel on homepage
    Given user should login in the application with english as a language option
    And user navigate to promotion section
    When user click on navigation dots button
    Then different image and text should be displayed

    @regression @pi7.3 @p1 @US7277952
  Scenario: Verify previous image on promotion carousel on homepage
    Given user should login in the application with english as a language option
    And user navigate to promotion section
    And user click on next arrow button
    When user click on previous arrow
    Then previous image should be displayed

     @regression @pi7.3 @p2 @US7277952
  Scenario: Verify promotion carousel greyed out on homepage
    Given user should login in the application with english as a language option
    And user navigate to promotion section
    When user click on right arrow till until last item
    Then user should see last arrow greyed out
    When user click on left arrow until first item
    Then user should see first arrow greyed out

  @regression @pi7.3 @p1 @US6286012
  Scenario: Verify reward section on homepage
    Given user should login in the application with english as a language option
    Then user navigates to rewards section on home page
    And user should see title subtitle and see all option in rewards section
    And user should see rewards name image and points to redeem under reward section on homepage

  @regression @pi7.3 @p1 @US7277881
  Scenario: Verify announcement section title and see all text on homepage
    Given user should login in the application with english as a language option
    And user navigate to announcement section
    Then user should see announcement title
    And user should see both arrow button for announcement section

  @regression @pi7.3 @p1 @US7277881
  Scenario: Verify different images on video announcement carousel on homepage
    Given user should login in the application with english as a language option
    And user navigate to announcement section
    When user click on announcement navigation dots button
    Then different image and text should be displayed in announcement section

  @regression @pi7.3 @p1 @US7277881
  Scenario: Verify previous image on announcement carousel on homepage
    Given user should login in the application with english as a language option
    And user navigate to announcement section
    And user click on announcement next arrow button
    When user click on announcement previous arrow
    Then previous image of announcement should be displayed

  @regression @pi7.3 @p2 @US7277881
  Scenario: Verify announcement carousel greyed out on homepage
    Given user should login in the application with english as a language option
    And user navigate to announcement section
    When user click on announcement right arrow till until last item
    Then user should see announcement last arrow greyed out
    When user click on announcement left arrow until first item
    Then user should see announcement first arrow greyed out

  @regression @pi7.4 @p1 @US7277966
  Scenario: Verify product catalogue section on homepage
    Given user should login in the application with english as a language option
    Then user navigates to product catalogue section on home page
    And user should see title subtitle and see all option in product catalogue section
    And user should see product name image and points to redeem under product catalogue section on homepage