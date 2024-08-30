Feature: channels

  @sourcing
  Scenario: sources

    Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
    And user navigates to "https://techpro-1f4-dev-ed.develop.lightning.force.com/" page
    And clicks on FD Details tab
    And clicks on FD Details new button
    And clicks on FD Details Branch Visit RT record type and click next
    Then verify the sourcing channel value contains "Branch Visit"
#    Then close the application