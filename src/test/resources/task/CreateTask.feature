Feature: Create Task

  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | Task_Test01    |
      | PROJECT_ACCOUNT | Fundacion |
      | PROJECT_VISIBLE | private   |
    Then I can verify the new project with "Task_Test01" project name
    And I create a new story
      | STORY_NAME | task_story_test01 |
    Then I verify the new story "task_story_test01" was created



  @acceptance
  Scenario: Create Task with only the required field
    When I create a new task
      | TASK_NAME | task_test01 |
    Then I verify the new task "task_test01" was created
