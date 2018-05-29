Feature: Create Story

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Project with story |
      | new_account_name | Willy  |
      | public           | false      |
    And save the response as "Project"
    And I validate the status code 200
    Then I put a valid user and Password

  @acceptance @DeleteProjectUI
  Scenario: Create story with only the required field
    Given I go to project
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