Feature: Create and Delete Project

  Background: With valid credentials account
    Given I put a valid user and Password
    And I post a new project
      | name             | Test New Project8 |
      | new_account_name | Fundacion  |
      | public           | false      |
    Then I get body of the answer

  @acceptance @PostConditionProject
  Scenario: Edit Project
    When I select any project "Test New Project8"
    And I can edit the project
      | DESCRIPTION        | ProjectNewTest |
      | ENABLE_TASKS       | false      |
      | PUBLIC_ACCESS      | false      |
      | START_ITERATION    | Tuesday    |
      | PROJECT_START_DATE | 14/01/2020 |
    Then I can verify the message saved "Changes saved."

  @acceptance
  Scenario: Delete Project
    When I click "Test New Project" settings
    Then I can verify the project deleted


