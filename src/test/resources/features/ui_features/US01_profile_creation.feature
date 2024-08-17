Feature: profile_creation

#  ilk test case
  @profile_test
  Scenario: TC01_profile_creation_test
#    test adimlari
  Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
    And user clicks on the setting icon
    And clicks on setup option
    Then verify user is on the setup page
    And user clicks on User drop down arrow
    And user clicks on profiles
    Then verify user profiles contains "Branch Officer"
    Then verify user profiles contains "Sales Representative"
    Then verify user profiles contains "Relationship Officer"
#    Then close the application

