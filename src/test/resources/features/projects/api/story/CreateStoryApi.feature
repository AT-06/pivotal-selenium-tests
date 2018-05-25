Feature: Create Story

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Test New ProjectMay333 |
      | new_account_name | Fundacion  |
      | public           | false      |
    And save the response as "Project"
    Then I validate the status code 200

  @acceptance @DeleteStory @DeleteProject
  Scenario: Create story with only the required field
    When I post a new "story" to "/projects/[Project.id]/stories" endpoint
      | name | story |
    And save the response as "Story"
    Then I validate the status code 200
