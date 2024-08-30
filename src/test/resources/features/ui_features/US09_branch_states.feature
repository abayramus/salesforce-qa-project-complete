Feature: branhc

  @branch_list
  Scenario: TC09_branch_states

    Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
    And user navigates to "https://techpro-1f4-dev-ed.develop.lightning.force.com/" page
    And clicks on FD Details tab
    And clicks on FD Details new button
    And clicks on FD Details Branch Visit RT record type and click next
    Then verify the branch list is in  alphabetical order
