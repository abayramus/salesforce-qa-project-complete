Feature: user_creation

  @custom_object
Scenario: TC03_custom_object_creation

  Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
  And user clicks on the setting icon
  And clicks on setup option
  Then verify user is on the setup page
  Then verify custom object contains "FD Detail"
  Then verify custom object contains "Applicant Detail"
    Then close the application