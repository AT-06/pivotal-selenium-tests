Feature: Create Story

  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | FATIMA    |
      | PROJECT_ACCOUNT | Fundacion |
      | PROJECT_VISIBLE | private   |
    Then I can verify the new project with the project name

  @acceptance @DeleteProjectUI
  Scenario: Create story with only the required field
    When I create a new story
      | STORY_NAME | story |
    Then I verify the new story was created

  @acceptance @DeleteProjectUI
  Scenario: Create a new story
    When I create a new story
      | STORY_NAME  | storyTest       |
      | STORY_TYPE  | feature         |
      | BLOCKERS    | blockerTest     |
      | DESCRIPTION | descriptionTest |
      | LABEL       | labelStory      |
      | COMMENT     | commentTest     |
    Then I verify the new story was created