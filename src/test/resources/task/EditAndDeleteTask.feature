Feature: Delete Story

  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | Project_test_delete |
      | PROJECT_ACCOUNT | task_account        |
      | PROJECT_VISIBLE | private             |
    And I can verify the new project with "Project_test_delete" project name
    And I create a new story
      | STORY_NAME  | storyTest       |
      | STORY_TYPE  | feature         |
      | BLOCKERS    | blockerTest     |
      | DESCRIPTION | descriptionTest |
      | LABEL       | labelStory      |
      | COMMENT     | commentTest     |
    Then I verify the new story "storyTest" was created
    And I create a new task
      | TASK_NAME | task_test01 |
    Then I verify the new task "task_test01" was created

  Scenario: Edit a task
    When I edit the task content
      | TASK_NAME | task_EDITED |