package org.fundacionjala.pivotal.steps.ui.story;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.story.DescriptionsStory;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.util.Helper;

import java.util.Map;

import static org.fundacionjala.pivotal.pages.story.DescriptionsStory.STORY_NAME;

/**
 * CreateStorySteps class that create a story.
 */
public class CreateStorySteps {
    private Story createStory;
    private Helper feature;
    private DashBoard dashBoard;

    /**
     * Constructor for CreateStorySteps class.
     *
     * @param createStory object.
     * @param feature     object.
     * @param dashBoard   object.
     */
    public CreateStorySteps(final Story createStory, final Helper feature, final DashBoard dashBoard) {
        this.createStory = createStory;
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
        createStory.setButtonCreateStory();
        values.keySet().stream().forEach(step -> createStory.getStrategyStepMap(values).get(step).execute());
        createStory.setButtonSaveStory();
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
}
