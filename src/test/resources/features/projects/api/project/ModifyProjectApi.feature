Feature: Create Story

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Test New Project 900 |
      | new_account_name | Fundacion  |
      | public           | false      |
    And save the response as "Project"
    Then I validate the status code 200

  @acceptance @DeleteProject
  Scenario: Modify project with only the required field
    When I put a "project" to "/projects/[Project.id]" endpoint
      | name | modified project test |
    And save the response as "Project"
    Then I validate the status code 200

  @acceptance
  Scenario: Delete project with only the required field
    When I delete a "project" with "/projects/[Project.id]" endpoint
    Then I validate the status code 204
