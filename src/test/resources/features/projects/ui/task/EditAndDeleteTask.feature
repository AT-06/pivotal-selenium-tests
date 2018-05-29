Feature: Delete Story

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Project story task |
      | new_account_name | Kyo                |
      | public           | false              |
    And save the response as "Project"
    And I validate the status code 200
    And I post a new "story" to "/projects/[Project.id]/stories" endpoint
      | name | story |
    And save the response as "Story"
    Then I validate the status code 200
    Then I put a valid user and Password
    Given I go to project

  Scenario: Edit a task
    When I edit the task content
      | TASK_NAME | task_EDITED |
