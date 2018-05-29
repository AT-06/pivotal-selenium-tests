Feature: Create and Delete Project

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Test New Project 900 |
      | new_account_name | Willy  |
      | public           | false      |
    And save the response as "Project"
    And I validate the status code 200
    Then I put a valid user and Password

  @acceptance @DeleteProject @DeleteAccount
  Scenario: Edit Project
    When I select the created project
    And I can edit the project
      | DESCRIPTION        | ProjectNewTest |
      | ENABLE_TASKS       | false      |
      | PUBLIC_ACCESS      | false      |
      | START_ITERATION    | Tuesday    |
      | PROJECT_START_DATE | 14/01/2020 |
    And I can verify the message saved "Changes saved."
    Then I return to dashboard and verify the project

  @acceptance @DeleteAccount
  Scenario: Delete Project
    When I select the created project
    And I delete the project
    Then I can verify the project deleted

