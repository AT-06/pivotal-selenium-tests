Feature: Create task into Story from a Project

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Test New ProjectMay333 |
      | new_account_name | Fundacion  |
      | public           | false      |
    And save the response as "Project"
    Then I validate the status code 200
    And I post a new "story" to "/projects/[Project.id]/stories" endpoint
      | name | story |
    And save the response as "Story"
    Then I validate the status code 200

  @acceptance
  Scenario: Create task with only the required field
    When I post a new "task" to "/projects/[Project.id]/stories/[Story.id]/tasks" endpoint
      | description | description task |
    And save the response as "Task"
    Then I validate the status code 200