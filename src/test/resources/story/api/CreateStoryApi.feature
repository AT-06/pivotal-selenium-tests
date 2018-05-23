Feature: Create Story

  Background: With valid credentials account
    Given I put a valid user and Password
    And I post a new project to "/projects" endpoint
      | name             | Test New ProjectMay3 |
      | new_account_name | Fundacion  |
      | public           | false      |
    And save the response as "Project"
    Then I validate the status code

  @acceptance
  Scenario: Create story with only the required field
    When I post a new story to "/projects/[Project.id]/stories"
      | name | story |
    And save the response as "Story"
    Then I validate the status code

  @acceptance
  Scenario: Create a new story
    When I create a new story
      | STORY_NAME  | storyTest       |
      | STORY_TYPE  | feature         |
      | BLOCKERS    | blockerTest     |
      | DESCRIPTION | descriptionTest |
      | LABEL       | labelStory      |
      | COMMENT     | commentTest     |
    Then I verify the new story "storyTest" was created