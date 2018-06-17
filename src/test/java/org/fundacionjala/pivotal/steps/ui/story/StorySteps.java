package org.fundacionjala.pivotal.steps.ui.story;

import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.story.DescriptionsStory;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.util.Helper;

import static org.fundacionjala.pivotal.pages.story.DescriptionsStory.STORY_NAME;

/**
 * StorySteps class that create a story.
 */
public class StorySteps {
    private Story story;
    private Helper feature;
    private DashBoard dashBoard;

    /**
     * Constructor for StorySteps class.
     *
     * @param story object.
     * @param feature     object.
     * @param dashBoard   object.
     */
    public StorySteps(final Story story, final Helper feature, final DashBoard dashBoard) {
        this.story = story;
        this.feature = feature;
        this.dashBoard = dashBoard;
    }

    /**
     * First step to create a story.
     *
     * @param values parameters to create a story.
     */
    @When("^I create a new story$")
    public void iCreateANewStory(final Map<DescriptionsStory, String> values) {
        story.setButtonCreateStory();
        values.keySet().forEach(step -> story.getStrategyStepMap(values).get(step).execute());
        story.setButtonSaveStory();
        feature.setStoryName(values.get(STORY_NAME));
    }

    /**
     * I go to project dashboard.
     */
    @Given("^I go to project$")
    public void iGoToProject() {
        dashBoard.setButtonDashborad();
        dashBoard.searchOnlyProject(feature.getProjectName());
        dashBoard.setProjectTitle();
    }

    /**
     * First step to delete a story.
     */
    @Given("^I delete the story$")
    public void iDeleteTheStory() {
        story.deleteStory();
    }



    /**
     * First step to edit a story.
     *
     * @param values parameters to edit.
     */
    @When("^I edit the next parameters$")
    public void iEditTheNextParameters(final Map<DescriptionsStory, String> values) {
        story.clickSToryExpander();
        values.keySet().forEach(step -> story.getStrategyStepMap(values).get(step).execute());
        story.setButtonCloseEdit();
        feature.setStoryName(values.get(STORY_NAME));
    }
}
