Feature: Create task into Story from a Project

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Test New Project with a story |
      | new_account_name | Fundacion  |
      | public           | false      |
    And save the response as "Project"
    And I validate the status code 200
    When I post a new "story" to "/projects/[Project.id]/stories" endpoint
      | name | story |
    And save the response as "Story"
    Then I validate the status code 200
    When I post a new "task" to "/projects/[Project.id]/stories/[Story.id]/tasks" endpoint
      | description | description task |
    And save the response as "Task"
    Then I validate the status code 200

  @acceptance @DeleteProject
  Scenario: Modify task
    When I put a "task" to "/projects/[Project.id]/stories/[Story.id]/tasks/[Task.id]" endpoint
      | description | description task modified |
    And save the response as "Task"
    Then I validate the status code 200

  @acceptance @DeleteProject
  Scenario: Delete task
    When I delete a "task" with "/projects/[Project.id]/stories/[Story.id]/tasks/[Task.id]" endpoint
    Then I validate the status code 204