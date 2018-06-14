Feature: Delete Story

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Project with story |
      | new_account_name | Willy              |
      | public           | false              |
    And save the response as "Project"
    And I put a valid user and Password
    And I go to project
    And I create a new story
      | STORY_NAME | story |
    And I create a new task
      | TASK_NAME | task_test01 |

  Scenario: Edit a task
    Then I verify the new task "task_test01" was created
