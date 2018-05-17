Feature: Create Account

  Background: With valid credentials account
    Given I put a valid user and Password

  @acceptance
  Scenario: Create a new Account
    Given I can create a new "UserTest1" account
    Then I can verify the new account