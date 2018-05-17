Feature: Create and Delete Project

  Background: With valid credentials account
    Given I put a valid user and Password
    And I post a new project
      | name             | P228 |
      | new_account_name | Fundacion  |
      | public           | false      |
    Then I get body of the answer

  @acceptance @PostConditionProject
  Scenario: Edit Project
    When I select any project "P228"
    And I can edit the project
      | DESCRIPTION        | px |
      | ENABLE_TASKS       | false      |
      | PUBLIC_ACCESS      | false      |
      | START_ITERATION    | Tuesday    |
      | PROJECT_START_DATE | 14/01/2020 |
    Then I can verify the message saved "Changes saved."

  @acceptance
  Scenario: Delete Project
    When I click "Project" settings
    Then I can verify the project deleted


