Feature: Create Project

  Background: With valid credentials account
    Given I put a valid user and Password

  @acceptance @DeleteProjectUI
  Scenario: Create Project with a new Account
    Given I can create a new project with the following values
      | PROJECT_TITLE   | Test8   |
      | PROJECT_ACCOUNT | Fundacion |
      | PROJECT_VISIBLE | public    |
    Then I can verify the new project with the project name

