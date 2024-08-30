Feature: user_creation

  @app_verification
  Scenario: TC05_app

    Given user is on "https://login.salesforce.com/" page and login in as "bank_user" profile
    And search for "Fixed Deposit" from the app launcher
    Then verify the result "Fixed Deposit" app
    Then close the application
