Feature: user_creation

  @fd_details_fields
  Scenario: TC01_user_creation_test

    Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
    And user navigates to "https://techpro-1f4-dev-ed.develop.lightning.force.com/" page
    And clicks on FD Details tab
    And clicks on FD Details new button
    And clicks on FD Details Branch Visit RT record type and click next
    And clicks on FD Details Branch Visit RT save button
    Then verify the "Application Form No", "Customer Type", and "Branch" are the required fields