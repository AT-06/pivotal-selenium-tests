Feature: Create and Delete Project

  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | Test8   |
      | PROJECT_ACCOUNT | Fundacion |
      | PROJECT_VISIBLE | public    |
    Then I can verify the new project with the project name

  @acceptance @DeleteProjectUI
  Scenario: Edit Project
    When I select the created project
    And I can edit the project
      | DESCRIPTION        | ProjectNewTest |
      | ENABLE_TASKS       | false      |
      | PUBLIC_ACCESS      | false      |
      | START_ITERATION    | Tuesday    |
      | PROJECT_START_DATE | 14/01/2020 |
    Then I can verify the message saved "Changes saved."

  @acceptance
  Scenario: Delete Project
    When I select the created project
    And I delete the project
    Then I can verify the project deleted

