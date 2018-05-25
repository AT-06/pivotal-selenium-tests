Feature: Delete Story

  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | ESCARLETH |
      | PROJECT_ACCOUNT | Fundacion |
      | PROJECT_VISIBLE | private   |
    And I can verify the new project with "ESCARLETH" project name
    And I create a new story
      | STORY_NAME  | storyTest       |
      | STORY_TYPE  | feature         |
      | BLOCKERS    | blockerTest     |
      | DESCRIPTION | descriptionTest |
      | LABEL       | labelStory      |
      | COMMENT     | commentTest     |
    Then I verify the new story "storyTest" was created

  @acceptance
  Scenario: Edit a story
    When I edit the next parameters
      | STORY_NAME  | StoryEdited           |
      | STORY_TYPE  | bug                   |
      | BLOCKERS    | blockerTestEdited     |
      | DESCRIPTION | descriptionTestEdited |
      | LABEL       | descriptionTestEdited |
      | COMMENT     | commentTestEdited     |
    Then I verify the parameters of "StoryEdited" were edited

  @acceptance
  Scenario: Delete a story
    Given I delete the story
    Then I verify that the story was deleted