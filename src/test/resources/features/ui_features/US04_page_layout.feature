Feature: user_creation

  @page_layout
  Scenario: TC04_page_layout

    Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
    And user clicks on the setting icon
    And clicks on setup option
    Then verify user is on the setup page
    Then verify custom object contains "FD Detail"
    And click on "FD Detail" object
    And click on "Page Layout" option in the setting
    Then verify "Branch Visit Layout" layout is in the list
    Then verify "Teleservice Layout" layout is in the list
    Then close the application