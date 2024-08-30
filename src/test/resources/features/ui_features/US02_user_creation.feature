Feature: user_creation

  @user_creation
  Scenario: TC01_user_creation_test

    Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
    And user clicks on the setting icon
    And clicks on setup option
    Then verify user is on the setup page
    And user clicks on User drop down arrow
    And user clicks on Users
    Then verify users contains "Branch Officer" profiles
    Then verify users contains "Sales Representative" profiles
    Then close the application

